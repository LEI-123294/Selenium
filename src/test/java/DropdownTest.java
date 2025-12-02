import org.example.DropdownPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTest {

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
    public void testDropdownSelection() {

        DropdownPage page = new DropdownPage(driver);

        page.open();
        page.selectOption1();

        assertEquals("Option 1", page.getSelectedOption());
    }
}
