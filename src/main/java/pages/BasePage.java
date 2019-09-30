package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

class BasePage {
    //private static WebDriver driver;
    WebDriver driver = BaseSteps.getDriver();
    /*static WebDriver getDriver() {
        return driver;
    }*/

    BasePage() {
        //driver = BaseSteps.getDriver();
        PageFactory.initElements(driver, this);
    }
}
