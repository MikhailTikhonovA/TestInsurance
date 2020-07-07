package steps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestProperties;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    public static WebDriver getDriver() {
        return driver;
    }

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static String baseUrl;
    protected static Actions actionsMoveOn;
    public static Properties properties = TestProperties.getInstance().getProperties();


    @BeforeClass
    public static void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        actionsMoveOn = new Actions(driver);
        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        if (driver.findElement(By.xpath("//*[@class='cookie-warning__close']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@class='cookie-warning__close']")).click();
        } else
            driver.findElement(By.xpath("//*[@class='kitt-cookie-warning__close']")).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }


}
