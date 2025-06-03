package test.ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ui.page.LoginPage;

public class BaseTestWithLogin extends BaseTest {

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("edge") String browser) {
       super.setup(browser);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}