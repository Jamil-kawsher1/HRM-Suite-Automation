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
    List<WebElement> savebutton;


    //user dropdown menue
    @FindBy(className = "oxd-userdropdown-tab")
    WebElement userDropdown;

    //user dropdown menus option like logout,about,support
    @FindBy(className = "oxd-userdropdown-link")
    List<WebElement> dropdownmenuList;

    //user menu list myinfo page
    @FindBy(className = "oxd-main-menu-item")
    List<WebElement> userMenuList;

    //gender and blood group selection on user info filed at 13 index male in 14 index female nad in 17 index blood group
    @FindBy(className = "oxd-input-field-bottom-space")
    List<WebElement> genderBloodSelection;
    //gender selection and other lebel selection male at 12 index and female at 12 index
    @FindBy(tagName = "label")
    List<WebElement> genderSelection;

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
        String oldusername = editUserField.get(1).getAttribute("value");
        //generating newusername
        String randomNewUsername = "Test" + Utils.randomNumber();
        Thread.sleep(1000);
        //clearing the username field
        editUserField.get(1).sendKeys(Keys.UP, Keys.CONTROL, "A", Keys.BACK_SPACE, Keys.DOWN);
        Thread.sleep(500);
        //sending the new generated username
        editUserField.get(1).sendKeys(randomNewUsername);

        Thread.sleep(1000);
        savebutton.get(1).click();

        Thread.sleep(2000);
        Utils.updateJSONFileObjectProperty("./src/test/resources/EmployeeList.json", 2, "username", randomNewUsername);


    }

    public void doLogout () throws InterruptedException {
        Thread.sleep(500);
        //clicking on user dropdown menu
        userDropdown.click();
        //clicking on logout from dropdown list
        Thread.sleep(500);
        dropdownmenuList.get(3).click();

    }

    public void userContactOtherInfoUpdate () throws InterruptedException {
        //clicking on My Info tab
        userMenuList.get(2).click();
        Thread.sleep(7000);
        genderSelection.get(12).click();
    }


}
