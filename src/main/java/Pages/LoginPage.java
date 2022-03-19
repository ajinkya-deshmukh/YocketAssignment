package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id= "phone")
    WebElement txtPhoneNumber;

    @FindBy(css = "type='submit'")
    WebElement btnGetOTP;

    @FindBy(xpath = "//input[@id='phone']/following-sibling::p")
    WebElement txtPhoneNumberValidationMessage;

}
