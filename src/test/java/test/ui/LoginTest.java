package test.ui;

import test.data.TestData;
import org.testng.annotations.Test;
import ui.page.LoginPage;
import ui.page.ProductsPage;

public class LoginTest extends BaseTest{

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        productsPage.verifyImOnProductsPage();
    }

    @Test
    public void loginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "invalid");
        loginPage.verifyErrorMessageText("Epic sadface: Username and password do not match any user in this service");
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "getLoginData")
    public void loginWithInvalidCredentialsUsingDataProvider(String username, String password, String expectedErrorMessageText) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        loginPage.verifyErrorMessageText(expectedErrorMessageText);
    }
}