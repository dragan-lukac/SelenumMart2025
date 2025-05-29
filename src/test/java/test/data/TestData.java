package test.data;

import org.testng.annotations.DataProvider;
import test.ui.BaseTest;

public class TestData {

    @DataProvider
    public Object[][] getLoginData() {
        return new Object[][] {
                {"standard_user", "bad-pass", "Epic sadface: Username and password do not match any user in this service"},
                {"bad-user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"}
        };
    }

    @DataProvider
    public Object[][] getPaymentData() {
        return new Object[][] {
                {"1235", "675865"},
                {"76455", "2345"}
        };
    }
}