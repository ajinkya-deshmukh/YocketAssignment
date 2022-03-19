package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SpinUpBrowser {

    static WebDriver driver;

//    public SpinUpBrowser(WebDriver driver) {
//        this.driver = driver;
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