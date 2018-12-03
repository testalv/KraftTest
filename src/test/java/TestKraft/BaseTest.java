package TestKraft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        //Launch browser
        System.out.println("Browser " + browser + " is starting");

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Default browser - Google Chrome");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDowm() {
        System.out.println("Close browser");
        //Close browser
        driver.quit();
    }
}
