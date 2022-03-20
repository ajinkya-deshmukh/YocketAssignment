import Pages.HomePage;
import Utils.SpinUpBrowser;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePageVerification extends SpinUpBrowser{

    @Test
    public void verifyHomePage(){
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
    }
}
