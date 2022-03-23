package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HomePage {
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

    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void verifyHomePage(){
        wait.until(ExpectedConditions.visibilityOf(lblHomeTxt));
        softassert.assertTrue(btnCollegeFinder.isDisplayed());
        softassert.assertTrue(btnHome.isDisplayed());
        softassert.assertTrue(lblHomeTxt.isDisplayed());
        softassert.assertTrue(btnLogin.isDisplayed());
        softassert.assertAll();
    }

    public void clickOnLogin(){
        btnLogin.click();
    }

    public void clickOnCollegeFinder(){
        btnCollegeFinder.click();
    }
}
