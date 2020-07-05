package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage {
    @FindBy(xpath = "//ul[@class='lg-menu__list']")
    WebElement mainMenu;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectTypeOfMainMenu(String mainMenuItem, Actions move) {
        move.moveToElement(mainMenu.
                findElement(By.xpath(".//span[contains(text(),'" + mainMenuItem + "')]"))).build().perform();
    }

    public void selectTypeOfSubMenu(String subMenu) {
        mainMenu.findElement
                (By.xpath(".//li[contains(@class,'lg-menu__sub-item')]/a[contains(text(),'" + subMenu + "')]")).click();
    }



}
