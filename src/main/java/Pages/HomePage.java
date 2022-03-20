package Pages;

import Utils.SpinUpBrowser;
import io.netty.util.internal.logging.Log4JLoggerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.maven.plugin.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePage {
//    private static org.apache.log4j.Logger log = Logger.getLogger(LogClass.class);
//    Logger logger = (Logger) LogManager.getLogger(HomePage.class);
    private static Logger logger = (Logger) LogManager.getLogger(HomePage.class);

//    Log4JLoggerFactory logger = new Log4JLoggerFactory();

    @FindBy(id = "college-finder")
    WebElement btnCollegeFinder;

    @FindBy(css = "a[href='/feed']")
    WebElement btnHome;

    @FindBy(xpath = "//h3[contains(text(),'If studying abroad is your dream')]")
    WebElement lblHomeTxt;

    @FindBy(id = "login-user-button")
    WebElement btnLogin;

    SoftAssert softassert = new SoftAssert();

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyHomePage(){
        softassert.assertTrue(btnCollegeFinder.isDisplayed());
        softassert.assertTrue(btnHome.isDisplayed());
//        softassert.assertTrue(lblHomeTxt.isDisplayed());
        softassert.assertTrue(btnLogin.isDisplayed());
        softassert.assertAll();
        logger.info("Verified Home Page");
    }

    public void clickOnLogin(){
        btnLogin.click();
        logger.info("Login clicked");
    }

    public void clickOnCollegeFinder(){
        btnCollegeFinder.click();
    }



}
