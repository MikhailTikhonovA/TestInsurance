package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuranceTravelChosePolicyPage {

    @FindBy(xpath = "//form//div[@class='container']")
    WebElement mainForm;

    @FindBy(xpath = ".//button[@class='btn btn-primary btn-large']")
    WebElement confirmButton;

    public InsuranceTravelChosePolicyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectTypeOfInsuranceProtection(String kindOf) {
        mainForm.findElement
                (By.xpath(".//div[contains(@class,'online-card-program')]/h3[contains(text(),'" + kindOf + "')]")).click();
    }

    public void confirmChoiceOnPage(WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        confirmButton.click();
    }

}
