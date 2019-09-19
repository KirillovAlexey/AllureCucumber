import org.junit.Test;
import org.openqa.selenium.WebDriver;
import steps.BaseSteps;
import steps.FillsSteps;
import steps.MainSteps;

public class SberTest {

    private static WebDriver driver;
    private static String url;

    @Test
    public void TestApp() {
/*
1) перейти на https://www.sberbank.ru
2) В верхнем меню "навестись" на Ипотека - дождаться открытия выпдающего меню и выбрать "Ипотека на готовое жилье"
3) Заполнить поля
Стоимость недвижмости 5 180 000 ?
Первоначальнй взнос 3 058 000 ?
Срок кредита 30 лет
Снять галочкку - есть зарплатная карта сбербанка
дождаться появляения "есть возможность подтвержить доход справкой"
поставить галочку "молодая семья"

Проверить значение полей
Сумма кредита
2 122 000 ?
Ежемесячный платеж
18 937 ?
Необходимый доход
31 561 ?
Процентная ставка
11% - тут ошибка (специально)
 */
        BaseSteps.setUp();
        new MainSteps().choiceMenu();
        new FillsSteps().fillText();
        BaseSteps.driver.quit();
    }
}
