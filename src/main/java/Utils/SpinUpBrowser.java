package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SpinUpBrowser {

    public static WebDriver driver;

    @BeforeTest
    public WebDriver start(){
        driver = SpinUpBrowser.SpinUpBrowser("chrome", Constants.BASE_URL);
        return driver;
    }

//    @AfterTest
//    public void tearDown(){
//        driver.quit();
//    }

    public static WebDriver SpinUpBrowser(String browsername , String url)
    {
        if(browsername.equalsIgnoreCase("Firefox"))
        {
            // Set the path for geckodriver.exe
            System.setProperty("webdriver.firefox.marionette","Drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        else if(browsername.equalsIgnoreCase("Chrome"))
        {
            // Set the path for chromedriver.exe
            System.setProperty("webdriver.chrome.driver","Drivers/chromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}