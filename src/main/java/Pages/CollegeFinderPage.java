package Pages;

import Utils.Constants;
import Utils.SpinUpBrowser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CollegeFinderPage extends SpinUpBrowser{

    @FindBy(xpath = "//button[contains(text(),'Masters')]")
    WebElement btnMasters;

//    @FindBy(xpath = "//div[@documentclick='']")
//    WebElement btnCloseChatWindow;

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

    @FindBy(xpath = "//div[contains(text(),'GRE')]")
    WebElement btnGRE;

    @FindBy(id = "work_exp")
    WebElement txtWorkExp;

    @FindBy(xpath = "//div[contains(text(),'International')]")
    WebElement btnInternationalPapers;

    @FindBy(id = "project")
    WebElement txtProject;

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Find Universities')]")
    WebElement btnFindUniversities;

    @FindBy(xpath = "//span[contains(text(),'Required field')]/parent::span//div[@id='country']")
    WebElement lblRequireTextCountry;

    @FindBy(xpath = "//span[contains(text(),'Required field')]/parent::span//div[@id='area_of_study']")
    WebElement lblRequireTextAreaOfStudy;

    @FindBy(xpath = "//span[contains(text(),'Required field')]/parent::span//div[@id='college']")
    WebElement lblRequireTextCollegeName;

    @FindBy(xpath = "//span[contains(text(),'Required field')]/parent::span//div[@id='major']")
    WebElement lblRequireTextMajor;

    @FindBy(xpath = "//span[contains(text(),'Required field')]//preceding-sibling::div//input[@id='marks']")
    WebElement lblRequireTextMarks;

    @FindBy(xpath = "//*[contains(text(),'Required field')]//parent::div//*[contains(text(),'IELTS')]")
    WebElement lblRequireTextIELTS;

    @FindBy(xpath = "//*[contains(text(),'Required field')]//parent::div//*[contains(text(),'GRE')]")
    WebElement lblRequireTexGRE;

    @FindBy(xpath = "//span[@class='text-red-600']//preceding-sibling::input[@id='ielts_overall_score']")
    WebElement lblRequireTextIELTSOverallScore;

    @FindBy(xpath = "//span[@class='text-red-600']//preceding-sibling::input[@id='verbal_score']")
    WebElement lblRequireTextVerbalScore;

    @FindBy(xpath = "//span[@class='text-red-600']//preceding-sibling::input[@id='quant_score']")
    WebElement lblRequireTextQuantScore;

    @FindBy(xpath = "//span[@class='text-red-600']//preceding-sibling::input[@id='awa_score']")
    WebElement lblRequireTextAWAScore;

    @FindBy(xpath = "//div[@themeid='8']")
    WebElement btnCloseChatWindow;

    @FindBy(xpath = "//iframe[@id='siqiframe']")
    WebElement iFrame;

    @FindBy(xpath = "//div[@data-id='zsalesiq']")
    WebElement btnOpenChatWindow;

    WebDriver driver;

    private WebDriverWait wait;

    SoftAssert softassert = new SoftAssert();

    public CollegeFinderPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickOnMasters(){
        btnMasters.click();
    }

    public void findMastersCollegePositiveFlow() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        CollegeFinderPage collegeFinder = new CollegeFinderPage(driver);
        homePage.clickOnCollegeFinder();

        // Start College Finder
        wait.until(ExpectedConditions.visibilityOf(btnMasters));
        btnMasters.click();
        Thread.sleep(11000);

        // Opening chat window manually as the chat is not opening automatically (must be time based feature)
        if(!btnCloseChatWindow.isDisplayed()){
            btnOpenChatWindow.click();
        }
        // Switching to the chat window iframe
        driver.switchTo().frame(iFrame);
        // Waiting for the close button
        wait.until(ExpectedConditions.visibilityOf(btnCloseChatWindow));
        // Clicking on Closing button inside the chat iFrame
        btnCloseChatWindow.click();
        // Switching back to the base/normal window for the yocket application
        driver.switchTo().defaultContent();

        // Continue with the test after closing chat window.
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
        txtProject.sendKeys(Constants.NUMBER_PROJECTS);
        btnFindUniversities.click();
        softassert.assertAll();
    }

    public void validateRequiredFieldsCollegeFinder() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        CollegeFinderPage collegeFinder = new CollegeFinderPage(driver);
        homePage.clickOnCollegeFinder();

        // Start College Finder
        wait.until(ExpectedConditions.visibilityOf(btnMasters));
        btnMasters.click();
        wait.until(ExpectedConditions.visibilityOf(lblHeaderTextStep1));
        softassert.assertTrue(lblHeaderTextStep1.isDisplayed());

        // Validate Required Field
        btnNext.click();
        softassert.assertTrue(lblRequireTextCountry.isDisplayed());
        softassert.assertTrue(lblRequireTextAreaOfStudy.isDisplayed());

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

        // Validate required field
        btnNext.click();
        softassert.assertTrue(lblRequireTextCollegeName.isDisplayed());
        softassert.assertTrue(lblRequireTextMajor.isDisplayed());

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

        // Validate Required Field

        btnIELTS.click();
        btnGRE.click();
        btnNext.click();
        softassert.assertTrue(lblRequireTextIELTSOverallScore.isDisplayed());
        softassert.assertTrue(lblRequireTextVerbalScore.isDisplayed());
        softassert.assertTrue(lblRequireTextQuantScore.isDisplayed());
        softassert.assertTrue((lblRequireTextAWAScore.isDisplayed()));


        btnIELTS.click();
        txtIELTSScore.sendKeys(Constants.VALID_IELTS_SCORE);

        btnNone.click();
        btnNext.click();

        // Enter Exp Details
        wait.until(ExpectedConditions.visibilityOf(txtWorkExp));

        txtWorkExp.sendKeys(Constants.WORK_EXP);
        btnInternationalPapers.click();
        txtProject.sendKeys(Constants.NUMBER_PROJECTS);;
        softassert.assertAll();
    }
}
