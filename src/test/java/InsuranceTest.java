import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Перейти на страницу http://www.sberbank.ru/ru/person
        driver.get(baseUrl);
    }

    @Test
    public void testInsurance() {
        //*Закрытие куки алерта

        driver.findElement(By.xpath("//*[@class='cookie-warning__close']"))
                .click();

        //Нажать на – Страхование
        WebElement insurance = driver.findElement(By.xpath("//button[contains(@class,'lg-menu__link')]/span[contains(text(),'Страхование')]"));
        Actions moveOnInsurance = new Actions(driver);
        moveOnInsurance.moveToElement(insurance).build().perform();
        //Выбрать – Путешествие и покупки
        driver.findElement(By.xpath("//li[contains(@class,'lg-menu__sub-item')]/a[contains(text(),'Страхование путешественников')]"))
                .click();
        //Проверить наличие на странице заголовка – Страхование путешественников
        WebElement title = driver.findElement
                (By.xpath("//div[2][@class='kit-grid kit-grid_fixed']/div[@class='kit-row']/div[1]/h1[contains(text(),'Страхование путешественников')]"));
        wait.until(ExpectedConditions.visibilityOf(title));
        Assert.assertEquals("Страхование путешественников", title.getText());
        //Нажать на – Оформить Онлайн
        driver.findElement(By.xpath("//div[@class='product-teaser-full-width__button']/a/b"))
                .click();
        //На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        driver.findElement(By.xpath("//div[contains(@class,'online-card-program')]/h3[contains(text(),'Минимальная')]"))
                .click();
        //Нажать Оформить
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary btn-large']")));
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-large']")).click();
        //На вкладке Оформить заполнить поля:
        //Фамилию и Имя, Дату рождения застрахованных
        driver.findElement(By.xpath("//input[@id='surname_vzr_ins_0']")).sendKeys("Petro");
        driver.findElement(By.xpath("//input[@id='name_vzr_ins_0']")).sendKeys("Petr");
        driver.findElement(By.xpath("//input[@id='birthDate_vzr_ins_0']")).sendKeys("02021980");


        //Данные страхователя
        //*без клика не отрабатывает корректно не происходит заполнение полей
        driver.findElement(By.id("person_lastName")).click();
        driver.findElement(By.xpath("//input[@id='person_lastName']")).sendKeys("Иванов");
        driver.findElement(By.xpath("//input[@id='person_firstName']")).click();
        driver.findElement(By.xpath("//input[@id='person_firstName']")).sendKeys("Иван");
        driver.findElement(By.xpath("//input[@id='person_middleName']")).click();
        driver.findElement(By.xpath("//input[@id='person_middleName']")).sendKeys("Петрович");
        driver.findElement(By.xpath("//input[@id='person_birthDate']")).click();
        driver.findElement(By.xpath("//input[@id='person_birthDate']")).sendKeys("01011990");
        driver.findElement(By.xpath("//input[@id='passportSeries']")).click();
        driver.findElement(By.xpath("//input[@id='passportSeries']")).sendKeys("1812");
        driver.findElement(By.xpath("//input[@id='passportNumber']")).click();
        driver.findElement(By.xpath("//input[@id='passportNumber']")).sendKeys("123412");
        driver.findElement(By.xpath("//input[@id='documentDate']")).click();
        driver.findElement(By.xpath("//input[@id='documentDate']")).sendKeys("12122015");
        driver.findElement(By.xpath("//input[@id='documentIssue']")).click();
        driver.findElement(By.xpath("//input[@id='documentIssue']")).sendKeys("УВД по г. Москве");
        //Проверка полей
        Assert.assertEquals("Petro", driver.findElement(By.xpath("//input[@id='surname_vzr_ins_0']")).getAttribute("value"));
        Assert.assertEquals("Petr", driver.findElement(By.xpath("//input[@id='name_vzr_ins_0']")).getAttribute("value"));
        Assert.assertEquals("02.02.1980", driver.findElement(By.xpath("//input[@id='birthDate_vzr_ins_0']")).getAttribute("value"));

        Assert.assertEquals("Иванов", driver.findElement(By.xpath("//input[@id='person_lastName']")).getAttribute("value"));
        Assert.assertEquals("Иван", driver.findElement(By.xpath("//input[@id='person_firstName']")).getAttribute("value"));
        Assert.assertEquals("Петрович", driver.findElement(By.xpath("//input[@id='person_middleName']")).getAttribute("value"));
        Assert.assertEquals("01.01.1990", driver.findElement(By.xpath("//input[@id='person_birthDate']")).getAttribute("value"));
        Assert.assertEquals("1812", driver.findElement(By.xpath("//input[@id='passportSeries']")).getAttribute("value"));
        Assert.assertEquals("123412", driver.findElement(By.xpath("//input[@id='passportNumber']")).getAttribute("value"));
        Assert.assertEquals("12.12.2015", driver.findElement(By.xpath("//input[@id='documentDate']")).getAttribute("value"));
        Assert.assertEquals("УВД по г. Москве", driver.findElement(By.xpath("//input[@id='documentIssue']")).getAttribute("value"));

        //Нажать продолжить
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Продолжить')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();

        //Проверить, что появилось сообщение - Заполнены не все обязательные поля
        //сейчас алерт другой
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='alert-form alert-form-error']"))));
        Assert.assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.xpath("//div[@class='alert-form alert-form-error']")).getText());

    }


    @After
    public void afterTest() {
        driver.quit();
    }

}
