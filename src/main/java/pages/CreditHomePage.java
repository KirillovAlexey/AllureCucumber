package pages;

import com.google.common.base.Function;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;


public class CreditHomePage extends BasePage {

    @FindBy(xpath = "//input[@id='estateCost']")
    WebElement estateCost;
    @FindBy(xpath = "//input[@id='initialFee']")
    WebElement initialFee;
    @FindBy(xpath = "//input[@id='creditTerm']")
    WebElement creditTerm;
    @FindBy(xpath = "//span[@data-test-id = 'amountOfCredit']")
    WebElement amountOfCredit;
    @FindBy(xpath = "//span[@data-test-id = 'monthlyPayment']")
    WebElement paidToCard;
    @FindBy(xpath = "//span[@data-test-id = 'requiredIncome']")
    WebElement requiredIncome;
    @FindBy(xpath = "//span[@data-test-id = 'rate']")
    WebElement rate;
    @FindBy(xpath = "//span[@data-test-id='monthlyPayment']")
    WebElement monthlyPayment;

    @FindBy(xpath = "//input[@data-test-id='paidToCard']/..")
    WebElement checkCard;
    @FindBy(xpath = "//input[@data-test-id='canConfirmIncome']//..")
    WebElement checkPayment;
    @FindBy(xpath = "//input[@data-test-id='youngFamilyDiscount']//..")
    WebElement youngFamily;

    private WebDriver driver = BaseSteps.driver;


    public void initilizeFill() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , driver.findElement(By.xpath("//h2[contains(text(),'Рассчитайте ипотеку')]")));
        driver.switchTo().frame("iFrameResizer0");

        waitingChange(estateCost, "5180000");
        waitingChange(initialFee, "3058000");
        waitingChange(creditTerm, "30");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , driver.findElement(By.xpath("//input[@id='creditTerm']")));
        WebDriverWait wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(checkCard)).click();
        checkPayment.click();
        //wait.until(ExpectedConditions.elementToBeClickable(checkPayment)).click();
        //youngFamily.click();
        wait.until(ExpectedConditions.elementToBeClickable(youngFamily)).click();
    }


    public void checkAssert() {
        WebDriverWait wait = new WebDriverWait(driver, 2, 1000);
        Assert.assertEquals("Сумма кредита", "2 122 000 \u20BD", amountOfCredit.getAttribute("textContent"));
        wait.until(ExpectedConditions.textToBePresentInElement(monthlyPayment, "18 937 \u20BD"));
        Assert.assertEquals("Ежемесячный платеж", "18 937 \u20BD", paidToCard.getAttribute("textContent"));
        Assert.assertEquals("Необходимый доход", "31 561 \u20BD", requiredIncome.getAttribute("textContent"));
        Assert.assertEquals("Процентная ставка", "10,2 %", rate.getAttribute("textContent"));
    }

    public void waitingChange(WebElement element, String text) {
        String oldValue = monthlyPayment.getText();
        Function<? super WebDriver, Object> valueChanged = new ExpectedCondition<Object>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                element.clear();
                element.sendKeys(text);
                String newValue = monthlyPayment.getText();
                return !oldValue.equals(newValue);
            }
        };
        //действие для изменения значения
        WebDriverWait wait = new WebDriverWait(driver, 20, 1000);
        wait.until(valueChanged);
    }

    public void fillsArea(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
}
