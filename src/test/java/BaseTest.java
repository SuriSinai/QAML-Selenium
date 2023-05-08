import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class BaseTest {
    private WebDriver webDriver;

    public WebDriver getWebDriver() { //para obtener el webdriver, está encapsulado, sólo el getter lo crea, solo se llama una vez
        File ruta = new File("C:\\Drivers-selenium\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", ruta.getPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        return webDriver;
    }

}
