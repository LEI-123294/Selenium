package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import tests.DataInputPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DataInputTest {

    @Test
    public void testFillDataInputForm() {
        DataInputPage page = new DataInputPage();
        page.openPage();

        String testValue = "Teste de Sucesso TS6";

        page.fillDataInput(testValue);

        $("div").shouldBe(visible).shouldHave(com.codeborne.selenide.Condition.text(testValue));
    }

}
