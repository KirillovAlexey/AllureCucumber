package steps;

import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;
import pages.CreditHomePage;

import java.util.Map;

public class FillsSteps {
    @Step("Заполнение полей:")
    @Когда("^Заполнение полей:$")
    public void fillText(Map<String,String> map) {
        new CreditHomePage().initilizeFill(map);
    }

    @Step("Проверка данных")
    @Когда("Проверка данных:")
    public void check(Map<String,String> map) {
        try {
            BaseSteps.takeScreenshot();
        } catch (Exception e){
            e.printStackTrace();
        }
        new CreditHomePage().checkAssert(map);
    }
}
