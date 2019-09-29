package steps;

import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {
    @Step("Переход в меню ипотеки")
    @Когда("Переход в меню ипотеки")
    public void choiceMenu(){
        new MainPage().CreditForNewHome();
    }
}
