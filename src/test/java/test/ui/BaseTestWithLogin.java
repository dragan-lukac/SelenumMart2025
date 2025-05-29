package test.ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.page.LoginPage;

public class BaseTestWithLogin extends BaseTest {

    @BeforeMethod
    public void setup() {
       super.setup();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}