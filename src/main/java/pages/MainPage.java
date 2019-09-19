package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[@aria-label='ћеню »потека']")
    private WebElement fNameMenu;
    @FindBy(xpath = "//div[@class='kit-grid kit-grid_fixed']//a[contains(text(),'»потека на готовое жильЄ')]")
    private WebElement creditForHome;

    public void CreditForNewHome() {
        //Actions actions = new Actions(BaseSteps.getDriver());
        new Actions(BasePage.getDriver()).moveToElement(fNameMenu).build().perform();
        creditForHome.click();
    }
}
