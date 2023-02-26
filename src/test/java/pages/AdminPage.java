package pages;

import org.json.simple.parser.ParseException;
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
public AdminPage(WebDriver driver){
    PageFactory.initElements(driver,this);
}
    public void searchUserInfo() throws IOException, ParseException {
//clicking on Admin page section
        manueList.get(0).click();
        String username= (String) Utils.readJSONFile("./src/test/resources/EmployeeList.json",1).get("username");
        inputField.get(1).sendKeys(username);
        searchBtn.click();
    }




}
