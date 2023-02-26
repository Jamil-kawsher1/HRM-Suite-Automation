package testRunner;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class AdminPageTestRunner extends Setup {
    @BeforeTest
    public void doLogin () {
        LoginPage login = new LoginPage(driver);
        login.doLogin("Admin", "admin123");
    }

    @Test(priority = 1, description = "Search User Info")
    public void searchUserInfo () throws IOException, ParseException, InterruptedException {
        AdminPage admin = new AdminPage(driver);

        admin.searchUserInfo();
        Thread.sleep(7000);
        String titleActual = driver.findElements(By.className("oxd-text")).get(14).getText();
        String titleexpected = "Record Found";

        Assert.assertTrue(titleActual.contains(titleexpected));

    }

    @Test(priority = 2, description = "Update User info")
    public void updateUsername () throws InterruptedException, IOException, ParseException {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.updateUsername();
        Thread.sleep(5000);
        String titleActual = driver.findElement(By.className("oxd-table-filter-title")).getText();

        String titleExpected = "System Users";

        Assert.assertEquals(titleActual, titleExpected);
        Thread.sleep(3000);


    }

    @Test(priority = 3, description = "Reseraching User With updated userid")
    public void researchingUserWithUpdatedUsername () throws IOException, ParseException, InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.searchUserInfo();
        Thread.sleep(7000);
        String titleActual = driver.findElements(By.className("oxd-text")).get(14).getText();
        String titleexpected = "Record Found";

        Assert.assertTrue(titleActual.contains(titleexpected));
    }
}
