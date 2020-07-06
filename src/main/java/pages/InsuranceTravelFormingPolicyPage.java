package pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuranceTravelFormingPolicyPage {

    @FindBy(id = "surname_vzr_ins_0")
    WebElement surNameOfInsured;

    @FindBy(id = "name_vzr_ins_0")
    WebElement nameOfInsured;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement dateOfBirdInsured;

    @FindBy(id = "person_lastName")
    WebElement lastNameOfInsurer;

    @FindBy(id = "person_firstName")
    WebElement firstNameOfInsurer;

    @FindBy(id = "person_middleName")
    WebElement middleNameOfInsurer;

    @FindBy(id = "person_birthDate")
    WebElement dateOfBirdInsurer;

    @FindBy(id = "passportSeries")
    WebElement passportSeriesOfInsurer;

    @FindBy(id = "passportNumber")
    WebElement passportNumberOfInsurer;

    @FindBy(id = "documentDate")
    WebElement docDateOfPassport;

    @FindBy(id = "documentIssue")
    WebElement organizationIssuePassport;

    @FindBy(xpath = "//button[contains(text(),'Продолжить')]")
    WebElement confirmButton;

    @FindBy(xpath = "//div[@class='alert-form alert-form-error']")
    WebElement obligatoryFieldAlert;


    public InsuranceTravelFormingPolicyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private void fillField(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    private String checkField(WebElement element) {
        return element.getAttribute("value");
    }

    public void fieldFiller(String nameOfCell, String value) {
        switch (nameOfCell) {
            case "Фамилия застрахованного":
                fillField(surNameOfInsured, value);
                break;
            case "Имя застрахованного":
                fillField(nameOfInsured, value);
                break;
            case "ДР застрахованного":
                fillField(dateOfBirdInsured, value);
                break;
            case "Фамилия страхуемого":
                fillField(lastNameOfInsurer, value);
                break;
            case "Имя страхуемого":
                fillField(firstNameOfInsurer, value);
                break;
            case "Отчество страхуемого":
                fillField(middleNameOfInsurer, value);
                break;
            case "ДР страхуемого":
                fillField(dateOfBirdInsurer, value);
                break;
            case "Серия паспорта С":
                fillField(passportSeriesOfInsurer, value);
                break;
            case "Номер паспорта С":
                fillField(passportNumberOfInsurer, value);
                break;
            case "Дата выдачи паспорта С":
                fillField(docDateOfPassport, value);
                break;
            case "Организация выдавшая паспорт С":
                fillField(organizationIssuePassport, value);
                break;
        }
    }

    public String fieldChecker(String nameOfCell) {
        switch (nameOfCell) {
            case "Фамилия застрахованного":
                return checkField(surNameOfInsured);
            case "Имя застрахованного":
                return checkField(nameOfInsured);
            case "ДР застрахованного":
                return checkField(dateOfBirdInsured);
            case "Фамилия страхуемого":
                return checkField(lastNameOfInsurer);
            case "Имя страхуемого":
                return checkField(firstNameOfInsurer);
            case "Отчество страхуемого":
                return checkField(middleNameOfInsurer);
            case "ДР страхуемого":
                return checkField(dateOfBirdInsurer);
            case "Серия паспорта С":
                return checkField(passportSeriesOfInsurer);
            case "Номер паспорта С":
                return checkField(passportNumberOfInsurer);
            case "Дата выдачи паспорта С":
                return checkField(docDateOfPassport);
            case "Организация выдавшая паспорт С":
                return checkField(organizationIssuePassport);
        }
        return "err";
    }

    public void confirmChoiceOnPage(WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        confirmButton.click();
    }

    public void checkAlertObligatoryField(WebDriver driver, String textOfObligFieldAlert) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(obligatoryFieldAlert));
        Assert.assertEquals(textOfObligFieldAlert, obligatoryFieldAlert.getText());
    }


}
