package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    private WebDriver driver;

    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectOption1() {
        new Select(driver.findElement(dropdown)).selectByValue("1");
    }

    public void selectOption2() {
        new Select(driver.findElement(dropdown)).selectByValue("2");
    }

    public String getSelectedOption() {
        return new Select(driver.findElement(dropdown)).getFirstSelectedOption().getText();
    }
}
