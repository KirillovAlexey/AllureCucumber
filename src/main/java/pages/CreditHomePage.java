package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.Map;
import java.util.function.Function;


public class CreditHomePage extends BasePage {

    @FindBy(xpath = "//input[@id='estateCost']")
    private WebElement estateCost;
    @FindBy(xpath = "//input[@id='initialFee']")
    private WebElement initialFee;
    @FindBy(xpath = "//input[@id='creditTerm']")
    private WebElement creditTerm;

    @FindBy(id = "//span[@data-test-id='amountOfCredit']")
    private WebElement amountOfCredit;
    @FindBy(xpath = "//span[@data-test-id='monthlyPayment']")
    private WebElement paidToCard;
    @FindBy(xpath = "//span[@data-test-id='requiredIncome']")
    private WebElement requiredIncome;
    @FindBy(xpath = "//span[@data-test-id='rate']")
    private WebElement rate;

    @FindBy(xpath = "//input[@data-test-id='paidToCard']/..")
    private WebElement checkCard;
    @FindBy(xpath = "//input[@data-test-id='canConfirmIncome']//..")
    private WebElement checkPayment;
    @FindBy(xpath = "//input[@data-test-id='youngFamilyDiscount']//..")
    private WebElement youngFamily;

    private final WebDriver driver = BaseSteps.driver;

    @Step
    public void initilizeFill(Map<String, String> map) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , driver.findElement(By.xpath("//h2[contains(text(),'Рассчитайте ипотеку')]")));
        driver.switchTo().frame("iFrameResizer0");

        waitingChange(estateCost, map.get("Стоимость"));
        waitingChange(initialFee, map.get("Первый взнос"));
        waitingChange(creditTerm, map.get("Срок"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , driver.findElement(By.xpath("//input[@id='creditTerm']")));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(checkCard));
        checkCard.click();
        wait.until(ExpectedConditions.visibilityOf(checkPayment)).click();
        wait.until(ExpectedConditions.visibilityOf(youngFamily)).click();
        wait.until(ExpectedConditions.textToBePresentInElement(paidToCard, "18 937 \u20BD"));
        driver.switchTo().defaultContent();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , driver.findElement(By.xpath("//h2[contains(text(),'Рассчитайте ипотеку')]")));
    }

    @Step
    public void checkAssert(Map<String, String> map) {
        Assert.assertEquals("Сумма кредита", map.get("Сумма кредита"), amountOfCredit.getAttribute("textContent"));
        Assert.assertEquals("Ежемесячный платеж", map.get("Ежемесячный платеж"), paidToCard.getAttribute("textContent"));
        Assert.assertEquals("Необходимый доход", map.get("Необходимый доход"), requiredIncome.getAttribute("textContent"));
        Assert.assertEquals("Процентная ставка", map.get("Процентная ставка"), rate.getAttribute("textContent"));
    }

    private void waitingChange(WebElement element, String text) {
        String oldValue = paidToCard.getText();
        Function<? super WebDriver, Object> valueChanged = (ExpectedCondition<Object>) webDriver -> {
            String newValue = paidToCard.getText();
            return !oldValue.equals(newValue);
        };
        //действие для изменения значения
        WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
        fillsArea(element, text);
        wait.until(valueChanged);
    }

    private void fillsArea(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
}
