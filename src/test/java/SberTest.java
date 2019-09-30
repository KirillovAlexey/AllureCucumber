import org.junit.After;
import org.junit.Test;
import steps.BaseSteps;
import steps.FillsSteps;
import steps.MainSteps;

import java.util.HashMap;

public class SberTest {

    @Test
    public void TestApp() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Стоимость", "5180000");
        map.put("Первый взнос", "3058000");
        map.put("Срок", "30");
        map.put("Сумма кредита","2 122 000 \u20BD");
        map.put("Ежемесячный платеж", "18 937 \u20BD");
        map.put("Необходимый доход", "31 561 \u20BD");
        map.put("Процентная ставка","11 %");
            BaseSteps.setUp();
            new MainSteps().choiceMenu();
            new FillsSteps().fillText(map);
            new FillsSteps().check(map);
            BaseSteps.tearDown();
            BaseSteps.takeScreenshot();
    }
    @After
    public void close(){
        BaseSteps.tearDown();
    }
}
