package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxesPage {

    private WebDriver driver;

    private By checkbox1 = By.cssSelector("#checkboxes input:nth-of-type(1)");
    private By checkbox2 = By.cssSelector("#checkboxes input:nth-of-type(2)");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    public void clickCheckbox1() {
        driver.findElement(checkbox1).click();
    }

    public void clickCheckbox2() {
        driver.findElement(checkbox2).click();
    }

    public boolean isCheckbox1Selected() {
        return driver.findElement(checkbox1).isSelected();
    }

    public boolean isCheckbox2Selected() {
        return driver.findElement(checkbox2).isSelected();
    }
}
