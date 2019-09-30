package steps;

import io.cucumber.java.ru.Когда;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.MyProperties;

public class BaseSteps {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    @Step
    @Когда("Подготовка тестовой среды")
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", MyProperties.getInstance().getProperty("path.chrome"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(MyProperties.getInstance().getProperty("url"));
    }

    @After
    @Step
    public static void tearDown() {
        getDriver().quit();
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}