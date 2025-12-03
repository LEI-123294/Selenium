import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.InteractionPage;
import org.example.Main;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class InteractionTest {

    @Test
    public void testInteractionComponentLoads() {

        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );

        Main mp = new Main();
        InteractionPage ip = new InteractionPage();

        mp.openPage();
        mp.goToButtonsSection();

        $("div").shouldHave(text("Button"));
    }
}
