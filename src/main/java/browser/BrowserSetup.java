package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserSetup {

    public WebDriver driver;

    public void startChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions.addArguments("--start-maximized"));
//                .addArguments("--headless"));
    }

    public void startFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        driver = new FirefoxDriver(firefoxOptions.addArguments("--start-maximized"));
        //                .addArguments("--headless"));
    }

    public void startEdge() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        driver = new EdgeDriver(edgeOptions.addArguments("--start-maximized"));
//                .addArguments("--headless"));
    }
}
