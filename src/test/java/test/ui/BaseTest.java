package test.ui;

import browser.BrowserSetup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest extends BrowserSetup {

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("Edge") String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                startChrome();
                break;
            case "firefox":
                startFirefox();
                break;
            case "edge":
                startEdge();
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}