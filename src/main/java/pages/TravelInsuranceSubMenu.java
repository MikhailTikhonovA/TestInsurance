package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class TravelInsuranceSubMenu {
    @FindBy(xpath = "//div[@class='product-teaser-full-width uuid-c1579d79-f7ac-4779-bcbf-31c2d18dc9e1']")
    WebElement mainTeaser;

    @FindBy(xpath = ".//div[2][@class='kit-grid kit-grid_fixed']/div[@class='kit-row']/div[1]/h1[contains(text(),'Страхование путешественников')]")
    WebElement headerOfTeaser;


    public TravelInsuranceSubMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkCurrentSubmenu(String title, WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(headerOfTeaser));
        testNameOfHeader(headerOfTeaser, title);
    }

    public static void testNameOfHeader(WebElement headerOfTeaser, String expectedText) {
        Assert.assertEquals(expectedText, headerOfTeaser.getText());
    }

    public void startProcessingPolicy (){
        mainTeaser.findElement(By.xpath(".//div[@class='product-teaser-full-width__button']/a/b")).click();
    }


}
