package Pages;

import Utils.Constants;
import Utils.SpinUpBrowser;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CollegeFinderPage extends SpinUpBrowser{

    @FindBy(xpath = "//button[contains(text(),'Masters')]")
    WebElement btnMasters;

    @FindBy(xpath = "//div[@documentclick='']")
    WebElement btnCloseChatWindow;

    @FindBy(xpath = "//*[contains(text(),'TAKE US THROUGH YOUR DREAM EDUCATION')]")
    WebElement lblHeaderTextStep1;

    @FindBy(xpath = "//label[contains(text(),'Where do you want to study?')]")
    WebElement lblWhereToStudy;

    @FindBy(xpath = "//label[contains(text(),'Where do you want to study?')]//span")
    WebElement iconWhereToStudyMandatory;

    @FindBy(xpath = "//label[contains(text(),'What are you planning to study?')]")
    WebElement lblWhatToStudy;

    @FindBy(xpath = "//label[contains(text(),'What are you planning to study?')]//span")
    WebElement iconWhatToStudyMandatory;

    @FindBy(xpath = "//div[@id='country']//input[@class='vs__search']")
    WebElement dropdownCountry;

    @FindBy(xpath = "//div[@id='area_of_study']//input[@class='vs__search']")
    WebElement dropdownAreaOfStudy;

    @FindBy(xpath = "//div[@id='specialization']//input[@class='vs__search']")
    WebElement dropdownSpecializationDisabled;

    @FindBy(xpath = "//*[contains(text(),'Step 1 of 4')]")
    WebElement lblStep1Header;

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Next')]")
    WebElement btnNext;

    @FindBy(xpath = "//input[@placeholder=\"Select Major\" and @aria-activedescendant='vs2__option-0']")
    WebElement searchSubject;


    @FindBy(xpath = "//div[@id='college']//input")
    WebElement dropdownUniversity;

    @FindBy(xpath = "//div[@id='major']//input")
    WebElement dropdownMajor;

    @FindBy(id = "vs4__option-0")
    WebElement universityFirstOption;

    @FindBy(id = "vs6__option-0")
    WebElement majorFirstOption;

    @FindBy(id = "marks")
    WebElement txtMarks;

    @FindBy(xpath = "//div[contains(text(),'IELTS')]")
    WebElement btnIELTS;

    @FindBy(id = "ielts_overall_score")
    WebElement txtIELTSScore;

    @FindBy(xpath = "//div[contains(text(),'None')]")
    WebElement btnNone;

    @FindBy(id = "work_exp")
    WebElement txtWorkExp;

    @FindBy(xpath = "//div[contains(text(),'International')]")
    WebElement btnInternationalPapers;

    @FindBy(id = "project")
    WebElement txtProject;

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Find Universities')]")
    WebElement btnFindUniversities;

    WebDriver driver;

    private WebDriverWait wait;

    SoftAssert softassert = new SoftAssert();

    public CollegeFinderPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);
    }

    public void clickOnMasters(){
        btnMasters.click();
    }

    public void findMastersCollege() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        CollegeFinderPage collegeFinder = new CollegeFinderPage(driver);
        homePage.clickOnCollegeFinder();

        // Start College Finder
        wait.until(ExpectedConditions.visibilityOf(btnMasters));
        btnMasters.click();
        wait.until(ExpectedConditions.visibilityOf(lblHeaderTextStep1));
        softassert.assertTrue(lblHeaderTextStep1.isDisplayed());
        dropdownCountry.click();
        dropdownCountry.sendKeys(Constants.MASTER_COUNTRY);
        dropdownCountry.sendKeys(Keys.ENTER);

        dropdownAreaOfStudy.click();
        dropdownAreaOfStudy.sendKeys(Constants.MASTER_SUBJECT);
        wait.until(ExpectedConditions.visibilityOf(searchSubject));
        dropdownAreaOfStudy.sendKeys(Keys.ENTER);

        btnNext.click();

        // Enter University Details
        wait.until(ExpectedConditions.visibilityOf(dropdownUniversity));
        dropdownUniversity.sendKeys(Constants.UNIVERSITY_NAME);
        wait.until(ExpectedConditions.visibilityOf(universityFirstOption));
        dropdownUniversity.sendKeys(Keys.ENTER);

        dropdownMajor.sendKeys(Constants.MAJOR_NAME);
        wait.until(ExpectedConditions.visibilityOf(majorFirstOption));
        dropdownMajor.sendKeys(Keys.ENTER);

        txtMarks.sendKeys(Constants.GPA);
        btnNext.click();

        // Enter External Scores
        wait.until(ExpectedConditions.visibilityOf(btnIELTS));

        btnIELTS.click();
        txtIELTSScore.sendKeys(Constants.VALID_IELTS_SCORE);

        btnNone.click();
        btnNext.click();

        // Enter Exp Details
        wait.until(ExpectedConditions.visibilityOf(txtWorkExp));
        txtWorkExp.sendKeys(Constants.WORK_EXP);
        btnInternationalPapers.click();
        txtProject.sendKeys(Constants.NUMBER_PROJECTS);;
        btnFindUniversities.click();
        softassert.assertAll();
    }
}
