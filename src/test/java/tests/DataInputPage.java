package tests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.WebDriverRunner;
import java.time.Duration;

public class DataInputPage {

    public void openPage() {
        open("https://demo.vaadin.com/sampler/#ui/data-input/textual/text-field");

        String iframeSelector = "iframe:not(#com.vaadin.demo.sampler.AppWidgetSet):not(.gwt-RichTextArea)";

        SelenideElement iframe = $(iframeSelector).shouldBe(visible, Duration.ofSeconds(20));

        WebDriverRunner.getWebDriver().switchTo().frame(iframe);

        $("body").shouldBe(visible, Duration.ofSeconds(5));
    }

    private SelenideElement getShadowElement(String tagName, String label) {
        String jsScript =
                "const targetTag = arguments[0].toLowerCase();" +
                        "const targetLabel = arguments[1];" +

                        "function findRecursive(root) {" +
                        "    let walker = document.createTreeWalker(root, NodeFilter.SHOW_ELEMENT);" +
                        "    while (walker.nextNode()) {" +
                        "        let node = walker.currentNode;" +

                        "        // 1. VERIFICAÇÃO: Tag name e propriedade JS 'label' devem corresponder.\n" +
                        "        if (node.tagName && node.tagName.toLowerCase() === targetTag && node.label === targetLabel) {" +
                        "            return node;" +
                        "        }" +

                        "        // 2. RECURSÃO: Mergulha no Shadow Root\n" +
                        "        if (node.shadowRoot) {" +
                        "            let found = findRecursive(node.shadowRoot);" +
                        "            if (found) return found;" +
                        "        }" +
                        "    }" +
                        "    return null;" +
                        "}" +
                        "return findRecursive(document.body);";

        WebElement foundElement = null;

        for (int i = 0; i < 30; i++) {
            foundElement = executeJavaScript(jsScript, tagName, label);
            if (foundElement != null) break;
            sleep(500);
        }

        if (foundElement == null) {
            WebDriverRunner.getWebDriver().switchTo().defaultContent();
            throw new RuntimeException("Elemento não encontrado via JS (pós-iframe): " + tagName + " com label '" + label + "'");
        }

        return $(foundElement);
    }

    public void fillDataInput(String value) {
        SelenideElement host = getShadowElement("vaadin-text-field", "Text Field");

        host.scrollIntoView(true).shouldBe(visible).setValue(value);
    }

    public void assertValueDisplayed(String expectedValue) {
        $("div").shouldHave(text(expectedValue));

        WebDriverRunner.getWebDriver().switchTo().defaultContent();
    }

    public void submit() {
        SelenideElement buttonHost = getShadowElement("vaadin-button", "Submit");

        if (!buttonHost.exists()) {
            // Se "Submit" não for a label, tentamos encontrar pelo seletor CSS do tema
            buttonHost = $("vaadin-button[theme='primary']");
        }

        buttonHost.scrollIntoView(true).shouldBe(visible).click();

        WebDriverRunner.getWebDriver().switchTo().defaultContent();
    }
}