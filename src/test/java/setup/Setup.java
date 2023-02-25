package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Setup {
    //setting up baisc setup and driver

  public   WebDriver driver;

    @BeforeTest
    public void setup () {
        //setting up connect with chrome driver with external Driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterTest
    public void close () {


//        driver.close();
    }
}