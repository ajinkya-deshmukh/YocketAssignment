package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class SpinUpBrowser {

    public static WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public WebDriver start(@Optional("Chrome") String browser){
        if (browser.equalsIgnoreCase("chrome")){
            driver = SpinUpBrowser.SpinUpBrowser("chrome", Constants.BASE_URL);
            return driver;
        } else if (browser.equalsIgnoreCase( "firefox")){
            driver = SpinUpBrowser.SpinUpBrowser("firefox", Constants.BASE_URL);
            return driver;
        }
        else {
            driver = SpinUpBrowser.SpinUpBrowser("chrome", Constants.BASE_URL);
            return driver;
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public static WebDriver SpinUpBrowser(String browsername , String url)
    {
        if(browsername.equalsIgnoreCase("Firefox"))
        {
            // Set the path for geckodriver
            System.setProperty("webdriver.gecko.driver","Drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        else if(browsername.equalsIgnoreCase("Chrome"))
        {
            // Set the path for chromedriver
            System.setProperty("webdriver.chrome.driver","Drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        driver.get(url);
        return driver;
    }
}