package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class UniversityResultsPage {

    @FindBy(id = "modal-headline")
    WebElement lblJoinYocket;

    @FindBy(xpath = "//a//button")
    WebElement btnLoginDialog;


    WebDriver driver;

    private WebDriverWait wait;

    SoftAssert softassert = new SoftAssert();

    public UniversityResultsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void verifyCollegeFinderSubmission(){
        wait.until(ExpectedConditions.visibilityOf(lblJoinYocket));
        softassert.assertTrue(lblJoinYocket.isDisplayed());
        btnLoginDialog.click();
        softassert.assertAll();
    }

}
