import Pages.HomePage;
import Utils.SpinUpBrowser;
import org.openqa.selenium.WebDriver;
import Utils.Constants;
import org.testng.annotations.Test;

public class HomePageVerification {

    WebDriver driver;

    public void startTest(){
        driver = SpinUpBrowser.SpinUpBrowser("chrome", Constants.BASE_URL);
    }

    @Test
    public void verifyHomePage(){
        startTest();
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
    }




}
