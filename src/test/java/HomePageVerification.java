import Pages.CollegeFinderPage;
import Pages.HomePage;
import Utils.SpinUpBrowser;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePageVerification extends SpinUpBrowser{

    HomePage homePage;
    @Test
    public void verifyHomePage(){
        homePage = new HomePage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
    }
}
