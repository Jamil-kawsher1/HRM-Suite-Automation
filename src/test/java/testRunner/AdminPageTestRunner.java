package testRunner;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import pages.PimPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class AdminPageTestRunner extends Setup {
    @BeforeTest
    public void doLogin () {
        LoginPage login = new LoginPage(driver);
        login.doLogin("Admin", "admin123");
    }
    @Test(priority = 1, description = "Search User with invalid Info")
    public void searchUserInfoWithInvalidInfo () throws IOException, ParseException, InterruptedException {
        AdminPage admin = new AdminPage(driver);

        admin.searchUserInfoWithInvalidInfo();
        Thread.sleep(7000);
        String titleActual = driver.findElements(By.className("oxd-text")).get(14).getText();
        String titleexpected = "No Records Found";
        System.out.println(titleActual);
        System.out.println(titleexpected);

        Assert.assertTrue(titleActual.contains(titleexpected));

    }
    @Test(priority = 2, description = "Search User Info")
    public void searchUserInfo () throws IOException, ParseException, InterruptedException {
        AdminPage admin = new AdminPage(driver);

        admin.searchUserInfo();
        Thread.sleep(7000);
        String titleActual = driver.findElements(By.className("oxd-text")).get(14).getText();
        String titleexpected = "Record Found";

        Assert.assertTrue(titleActual.contains(titleexpected));

    }

    @Test(priority = 3, description = "Update User info")
    public void updateUsername () throws InterruptedException, IOException, ParseException {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.updateUsername();
        Thread.sleep(5000);
        String titleActual = driver.findElement(By.className("oxd-table-filter-title")).getText();

        String titleExpected = "System Users";

        Assert.assertEquals(titleActual, titleExpected);
        Thread.sleep(3000);


    }

    @Test(priority = 4, description = "Reseraching User With updated userid")
    public void researchingUserWithUpdatedUsername () throws IOException, ParseException, InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.searchUserInfo();
        Thread.sleep(7000);
        String titleActual = driver.findElements(By.className("oxd-text")).get(14).getText();
        String titleexpected = "Record Found";

        Assert.assertTrue(titleActual.contains(titleexpected));
    }

    @Test(priority = 5, description = "Logout from admin dashboard")
    public void doLogout () throws InterruptedException {
        AdminPage admin = new AdminPage(driver);
        admin.doLogout();

    }

    @Test(priority = 6)
    public void doLoginWith2ndUser () throws IOException, ParseException, InterruptedException {
        LoginPage login = new LoginPage(driver);
        Thread.sleep(500);
        String username = (String) Utils.readJSONFile("./src/test/resources/EmployeeList.json", 1).get("username");
        String password = (String) Utils.readJSONFile("./src/test/resources/EmployeeList.json", 1).get("password");
        Thread.sleep(500);
        login.doLogin(username, password);

    }

    @Test(priority = 7)
    public void userContactOtherInfoUpdate () throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        Thread.sleep(3000);
        adminPage.userContactOtherInfoUpdate(driver);


    }

    @Test(priority = 8, description = "Update user contact and email")
    public void updateContactAndEmail () throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.updateContactAndEmail(driver);
        Thread.sleep(10000);
        adminPage.doLogout();

    }
}
