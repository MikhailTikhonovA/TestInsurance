package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsuranceTravelFormingPolicyPage {
    @FindBy(xpath = "//form[@class='needs-validation page-form forming-product-form ng-untouched ng-dirty ng-invalid']")
    WebElement mainForm;
}
