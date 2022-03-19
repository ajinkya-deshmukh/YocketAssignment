package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "college-finder")
    WebElement btnCollegeFinder;

    @FindBy(linkText = "/feed")
    WebElement btnHome;

    @FindBy(xpath = "//h3[contains(text(),'If studying abroad is your dream, ')]")
    WebElement lblHomeTxt;

    @FindBy(id = "login-user-button")
    WebElement btnLogin;

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyHomePage(){
        btnCollegeFinder.isDisplayed();
//        btnHome.isDisplayed();
        lblHomeTxt.isDisplayed();
        btnLogin.isDisplayed();
    }



}
