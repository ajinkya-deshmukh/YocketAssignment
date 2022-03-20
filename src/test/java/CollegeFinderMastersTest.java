import Pages.CollegeFinderPage;
import Pages.HomePage;
import Pages.UniversityResultsPage;
import Utils.SpinUpBrowser;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CollegeFinderMastersTest extends SpinUpBrowser{


    HomePage homePage;
    CollegeFinderPage collegeFinder;
    UniversityResultsPage universityResultsPage;

    @Test
    public void verifyCollegeFinder(){
        homePage = new HomePage(driver);
        collegeFinder = new CollegeFinderPage(driver);
        homePage.clickOnCollegeFinder();
        collegeFinder.clickOnMasters();
    }

    @Test
    public void findMastersCollegeTest() throws InterruptedException {
        homePage = new HomePage(driver);
        collegeFinder = new CollegeFinderPage(driver);
        universityResultsPage = new UniversityResultsPage(driver);
        collegeFinder.findMastersCollegePositiveFlow();
        universityResultsPage.verifyCollegeFinderSubmission();
    }

    @Test
    public void  findMastersCollegeNegativeFlow() throws InterruptedException {
        homePage = new HomePage(driver);
        collegeFinder = new CollegeFinderPage(driver);
        universityResultsPage = new UniversityResultsPage(driver);
        collegeFinder.validateRequiredFieldsCollegeFinder();
    }
}
