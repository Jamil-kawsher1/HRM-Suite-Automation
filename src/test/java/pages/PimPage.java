package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PimPage {

    //Dashboard manue List
    @FindBy(className = "oxd-main-menu-item-wrapper")
    List<WebElement> manueList;


    //page Factory intialization

    public PimPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void doClickOnPIM () {
        manueList.get(1).click();

    }
}
