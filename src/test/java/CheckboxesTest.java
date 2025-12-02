import org.example.CheckboxesPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class CheckboxesTest {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
    
    @Test
    public void testCheckboxInteraction() throws InterruptedException {

        CheckboxesPage page = new CheckboxesPage(driver);

        page.open();

        // Ensure checkbox 1 becomes selected
        if (!page.isCheckbox1Selected()) page.clickCheckbox1();
        assertTrue(page.isCheckbox1Selected());

        // Ensure checkbox 2 becomes unselected, then selected
        if (page.isCheckbox2Selected()) page.clickCheckbox2();
        assertFalse(page.isCheckbox2Selected());

        page.clickCheckbox2();
        assertTrue(page.isCheckbox2Selected());
    }

}
