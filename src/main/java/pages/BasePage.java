package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

class BasePage {
    private WebDriver driver = BaseSteps.getDriver();

    BasePage() {
        PageFactory.initElements(driver, this);
    }
}
