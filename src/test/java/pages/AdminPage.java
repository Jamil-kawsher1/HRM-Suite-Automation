package pages;

import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
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


    //user dropdown menu
    @FindBy(className = "oxd-userdropdown-tab")
    WebElement userDropdown;

    //user dropdown menus option like logout,about,support
    @FindBy(className = "oxd-userdropdown-link")
    List<WebElement> dropdownmenuList;

    //user menu list myinfo page
    @FindBy(className = "oxd-main-menu-item--name")
    List<WebElement> userMenuList;

    //personal details inner tab like contact details personal details
    @FindBy(className = "orangehrm-tabs-item")
    List<WebElement> innertabs;


    //gender and blood group selection on user info filed at 13 index male in 14 index female nad in 17 index blood group
    @FindBy(className = "oxd-input-field-bottom-space")
    List<WebElement> genderBloodSelection;
    //gender selection and other lebel selection male at 12 index and female at 12 index
    @FindBy(tagName = "label")
    List<WebElement> genderSelection;
    //blood group selection
    @FindBy(className = "oxd-select-text-input")
    public List<WebElement> bloodgroup;
    //user info save buttons
    @FindBy(css = "[type=submit]")
    List<WebElement> saveButtons;

    //my info sidebar menu list
    @FindBy(className = "orangehrm-tabs-item")
    List<WebElement> userinfoMenuList;

    //contact details input fields
    @FindBy(className = "oxd-input")
    List<WebElement> contactInputFields;
    //select country in Contact update page
    @FindBy(className = "oxd-select-text-input")
    WebElement countrySelect;

    public AdminPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchUserInfoWithInvalidInfo () throws IOException, ParseException, InterruptedException {
//clicking on Admin page section
        manueList.get(0).click();

        Thread.sleep(1000);
        inputField.get(1).sendKeys("invalid243");
        Thread.sleep(1000);
        searchBtn.click();
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

    public void userContactOtherInfoUpdate (WebDriver driver) throws InterruptedException {
        //clicking on My Info tab
        userMenuList.get(2).click();
        Thread.sleep(7000);
        //clicking on blood group
        genderSelection.get(12).click();
        Thread.sleep(3000);
        savebutton.get(0).click();
        Thread.sleep(1000);
        Utils.doScroll(driver, 550);
        Thread.sleep(3000);
        bloodgroup.get(2).click();
        Thread.sleep(5000);

        bloodgroup.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        bloodgroup.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        bloodgroup.get(2).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        savebutton.get(1).click();
//        driver.findElement(By.className("oxd-select-dropdown")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);

    }

    public void updateContactAndEmail (WebDriver driver) throws InterruptedException {
        Utils.doScroll(driver, -550);
        Thread.sleep(4000);
        //clicking on contact details
        innertabs.get(1).click();
        Thread.sleep(4000);
        Faker faker = new Faker();
        String streetAddress = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String zipcode = faker.address().zipCode();
        String Workemail = faker.internet().emailAddress();
        String otheremail = faker.internet().emailAddress();
        //street address
        contactInputFields.get(1).sendKeys(streetAddress);

        //city
        contactInputFields.get(3).sendKeys(city);

        //state
        contactInputFields.get(4).sendKeys(state);
        //zipcode
        contactInputFields.get(5).sendKeys(zipcode);
        Thread.sleep(2000);
        countrySelect.click();
        Thread.sleep(500);
        countrySelect.sendKeys("u");
        Thread.sleep(500);
        countrySelect.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        countrySelect.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        countrySelect.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        countrySelect.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        countrySelect.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        //filling up email adderess
        contactInputFields.get(9).sendKeys(Workemail);
        contactInputFields.get(10).sendKeys(otheremail);

        Thread.sleep(2000);
        //saving info
        searchBtn.click();
    }


}
