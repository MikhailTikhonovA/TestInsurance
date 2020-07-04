import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InsuranceTest {
    private WebDriver driver;
    private WebDriverWait wait;
    String baseUrl;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver");
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait (driver, 200);
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void testInsurance() {
        //Закрытие куки алерта
        driver.findElement(By.xpath("//*[@class='cookie-warning__close']")).click();
        //навигация по основному менб на меню страхование
        WebElement insurance = driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div[4]/div[1]/div[2]/div/div[1]/ul/li[6]/button/span"));
        Actions moveOnInsurance = new Actions(driver);
        moveOnInsurance.moveToElement(insurance).build().perform();


        driver.findElement(By.linkText("Страхование для путешественников")).isEnabled();


    }

    @After
    public void afterTest() {
        //driver.quit();
    }

}
