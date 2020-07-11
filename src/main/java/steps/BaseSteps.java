package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestProperties;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static String baseUrl;
    protected static Actions actionsMoveOn;
    public static Properties properties = TestProperties.getInstance().getProperties();
    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        actionsMoveOn = new Actions(driver);
        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='cookie-warning__close']")));
        driver.findElement(By.xpath("//*[@class='cookie-warning__close']")).click();

//        if (driver.findElement(By.xpath("//button[@class='kitt-cookie-warning__close']")).isDisplayed()) {
//            driver.findElement(By.xpath("//button[@class='kitt-cookie-warning__close']")).click();
//        }
    }

    @After
    public static void tearDown() {
        driver.quit();
    }


}
