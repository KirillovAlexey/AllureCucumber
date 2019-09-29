import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.CreditHomePage;
import steps.BaseSteps;
import steps.FillsSteps;
import steps.MainSteps;

public class SberTest {

    @Test
    public void TestApp() {
/*
1) ������� �� https://www.sberbank.ru
2) � ������� ���� "���������" �� ������� - ��������� �������� ���������� ���� � ������� "������� �� ������� �����"
3) ��������� ����
��������� ����������� 5 180 000 ?
������������� ����� 3 058 000 ?
���� ������� 30 ���
����� �������� - ���� ���������� ����� ���������
��������� ���������� "���� ����������� ����������� ����� ��������"
��������� ������� "������� �����"

��������� �������� �����
����� �������
2 122 000 ?
����������� ������
18 937 ?
����������� �����
31 561 ?
���������� ������
11% - ��� ������ (����������)
 */
        BaseSteps.setUp();
        new MainSteps().choiceMenu();
        new FillsSteps().fillText();
        new FillsSteps().check();
        BaseSteps.tearDown();
    }
}
