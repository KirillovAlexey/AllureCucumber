package steps;

import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;
import pages.CreditHomePage;

public class FillsSteps {
    @Step("Заполнение полей")
    @Когда("Заполнение полей")
    public void fillText(){
        new CreditHomePage().initilizeFill();
    }
    @Step("Проверка данных")
    @Когда("Проверка данных")
    public void check(){
        new CreditHomePage().checkAssert();
    }
}
