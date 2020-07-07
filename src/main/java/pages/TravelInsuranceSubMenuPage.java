package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class TravelInsuranceSubMenuPage {

    @FindBy(xpath = ".//div[2][@class='kit-grid kit-grid_fixed']/div[@class='kit-row']/div[1]/h1[contains(text(),'Страхование путешественников')]")
    WebElement headerOfTeaser;

    @FindBy(xpath = ".//div[@class='product-teaser-full-width__button']/a/b")
    WebElement startProcessingButton;


    public TravelInsuranceSubMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public TravelInsuranceSubMenuPage checkCurrentSubmenu(String title, WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(headerOfTeaser));
        testNameOfHeader(headerOfTeaser, title);
        return this;
    }

    public static void testNameOfHeader(WebElement headerOfTeaser, String expectedText) {
        Assert.assertEquals(expectedText, headerOfTeaser.getText());
    }

    public TravelInsuranceSubMenuPage startProcessingPolicy() {
        startProcessingButton.click();
        return this;
    }


}
