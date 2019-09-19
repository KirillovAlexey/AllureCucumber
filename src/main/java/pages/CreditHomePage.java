package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.function.Function;

public class CreditHomePage extends BasePage {

    private By priceCredit = By.xpath("//input[@id='estateCost']");
    private By firstPay = By.xpath("//input[@id='initialFee']");
    private By timeToPay = By.xpath("//input[@id='creditTerm']");
    private By checkCard = By.xpath("//input[@data-test-id='paidToCard']/..");
    private By checkPayment = By.xpath("//input[@data-test-id='canConfirmIncome']//..");
    private By youngFamily = By.xpath("//input[@data-test-id='youngFamilyDiscount']//..");

    By amountOfCredit = By.xpath("//span[@data-test-id = 'amountOfCredit']");
    By monthlyPayment = By.xpath("//span[@data-test-id = 'monthlyPayment']");
    By requiredIncome = By.xpath("//span[@data-test-id = 'requiredIncome']");
    By rate = By.xpath("//span[@data-test-id = 'rate']");

    private WebDriver driver = BaseSteps.driver;

    public void initilizeFill() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , driver.findElement(By.xpath("//h2[contains(text(),'Рассчитайте ипотеку')]")));
        driver.switchTo().frame("iFrameResizer0");
        fillsArea(priceCredit, "5180000");
        waitingChange(firstPay);
        fillsArea(firstPay, "3058000");
        fillsArea(timeToPay, "30");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , driver.findElement(By.xpath("//input[@id='creditTerm']")));

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(checkCard)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkPayment));
        driver.findElement(checkPayment).click();
        driver.findElement(youngFamily).click();
    }

    public void checkAssert() {
        Assert.assertEquals("Сумма кредита", driver.findElement(amountOfCredit).getAttribute("textContent"), "2 122 000 \u20BD");
        Assert.assertEquals("Ежемесячный платеж", driver.findElement(monthlyPayment).getAttribute("textContent"), "18 937 \u20BD");
        Assert.assertEquals("Минимальная ЗП", driver.findElement(requiredIncome).getAttribute("textContent"), "31 561 \u20BD\n");
        Assert.assertEquals("Процентная ставка", driver.findElement(rate).getAttribute("textContent"), "11%");
    }

    public void waitingChange(By by) {
        String oldValue = driver.findElement(by).getAttribute("value");
        Function<? super WebDriver, Object> valueChanged = new ExpectedCondition<Object>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return !webDriver.findElement(by).getAttribute("value").equals(oldValue);
            }
        };
        //действие для изменения значения
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(valueChanged);
    }

    public void fillsArea(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
}
