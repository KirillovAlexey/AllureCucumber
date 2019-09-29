package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[@aria-label='Меню Ипотека']")
    private WebElement fNameMenu;
    @FindBy(xpath = "//div[@class='kit-grid kit-grid_fixed']//a[contains(text(),'Ипотека на готовое жильё')]")
    private WebElement creditForHome;

    public void CreditForNewHome() {
        new Actions(BasePage.getDriver()).moveToElement(fNameMenu).build().perform();
        creditForHome.click();
    }
}
