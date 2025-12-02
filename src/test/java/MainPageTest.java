import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPageTest {

    @Test
    public void testeAberturaPagina() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Abrir página de exemplo
        driver.get("https://www.example.com");

        // Pausa de 2 segundos
        Thread.sleep(2000);

        // Fecha o browser
        driver.quit();
    }
}