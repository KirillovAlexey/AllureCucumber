package steps;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.MyProperties;

public class BaseSteps {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", MyProperties.getInstance().getProperty("path.chrome"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(MyProperties.getInstance().getProperty("url"));
    }

    @After
    public void tearDown() {
        driver.quit();

    }
}