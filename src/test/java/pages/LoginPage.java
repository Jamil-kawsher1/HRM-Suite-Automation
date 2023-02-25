package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//username filed
    @FindBy(name = "username")
    WebElement usernamef;

    //password filed
@FindBy(name = "password")
    WebElement passwordf;


//login button submit type
    @FindBy(tagName = "button")
    WebElement btnLogin;
    //page factory initialization\
    public  LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    //do login steps

    public void doLogin(String username,String password){
       usernamef.sendKeys(username);
       passwordf.sendKeys(password);
       btnLogin.click();
    }
}