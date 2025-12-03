package org.example;

import static com.codeborne.selenide.Selenide.*;

public class InteractionPage {

    public String getTitle() {
        return $("h1").getText();
    }
}
