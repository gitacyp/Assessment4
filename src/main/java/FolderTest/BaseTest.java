package FolderTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<>();
    //explicit : wait for exact minutes
    //implicit : wait until the element is displayed

    //Before (open browser, additional open website atau url)
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();

        //Getter and setter to open the browser and url
        driver.set(new FirefoxDriver(options));
        driver.get().manage().window().maximize();
        driver.get().get("https://demoblaze.com");
        explicitWait.set(new WebDriverWait((driver.get()), Duration.ofSeconds(120)));

    }

    //After (close browser / close connection)
    @AfterMethod
    public void closeBrowser(){
        driver.get().quit();
    }
}
