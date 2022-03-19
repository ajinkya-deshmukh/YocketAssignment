package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CollegeFinderPage {

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
}
