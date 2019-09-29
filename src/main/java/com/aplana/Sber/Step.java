package com.aplana.Sber;

import io.cucumber.java.ru.Когда;
import pages.CreditHomePage;
import pages.MainPage;
import steps.BaseSteps;
import steps.FillsSteps;
import steps.MainSteps;


public class Step {
    MainSteps mainSteps = new MainSteps();

    @Когда("Подготовка тестовой стреды")
    public void init() {
        new BaseSteps().setUp();
    }

    @Когда("Переход в меню ипотеки")
    public void openSite() {
        new MainPage().CreditForNewHome();
    }

    @Когда("Заполнение полей")
    public void inputData() {
        new FillsSteps().fillText();
    }

    @Когда("Проверка данных")
    public void checkError() {
        new CreditHomePage().checkAssert();
    }

    @Когда("Окончание работы")
    public void exit() {
        new BaseSteps().tearDown();
    }
}
