package pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class AdminPage {
    //dashboard Menue List
    @FindBy(className = "oxd-main-menu-item-wrapper")
    public List<WebElement> manueList;
    @FindBy(className = "oxd-input")
    public List<WebElement> inputField;

    //search button
    @FindBy(css = "[type=submit]")
    WebElement searchBtn;

    //table cell action buttons 1.delete button 2.edit button
    @FindBy(className = "oxd-table-cell-action-space")
    List<WebElement> tableActionButton;

    //edit user filed username
    @FindBy(className = "oxd-input")
   public List<WebElement> editUserField;

   //edit user save button
    @FindBy(className = "oxd-button")
   List <WebElement> savebutton;

    public AdminPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchUserInfo () throws IOException, ParseException, InterruptedException {
//clicking on Admin page section
        manueList.get(0).click();
        String username = (String) Utils.readJSONFile("./src/test/resources/EmployeeList.json", 2).get("username");
        Thread.sleep(1000);
        inputField.get(1).sendKeys(username);
        Thread.sleep(1000);
        searchBtn.click();
    }

    public void updateUsername () throws InterruptedException, IOException, ParseException {
        Thread.sleep(2000);
        //clicking on edit button in users table
        tableActionButton.get(1).click();
        Thread.sleep(2000);
        //keeping the old username for future use
        String oldusername=editUserField.get(1).getAttribute("value");
        //generating newusername
       String randomNewUsername="Test"+Utils.randomNumber();
       Thread.sleep(1000);
       //clearing the username field
        editUserField.get(1).sendKeys(Keys.UP,Keys.CONTROL,"A",Keys.BACK_SPACE,Keys.DOWN);
        Thread.sleep(500);
        //sending the new generated username
       editUserField.get(1).sendKeys(randomNewUsername);

       Thread.sleep(1000);
       savebutton.get(1).click();

       Thread.sleep(2000);
        Utils.updateJSONFileObjectProperty("./src/test/resources/EmployeeList.json",2,"username",randomNewUsername);







    }


}
