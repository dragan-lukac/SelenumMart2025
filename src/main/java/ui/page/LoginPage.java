package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By usernameFieldBy = By.id("user-name");
    By passwordFieldBy = By.id("password");
    By loginButtonBy = By.id("login-button");
    By errorMessageBy = By.className("error-message-container");

    public void login(String username, String password) {
        insertText(usernameFieldBy, username);
        insertText(passwordFieldBy, password);
        click(loginButtonBy);
    }

    public void verifyErrorMessageText(String expectedText) {
        assertElementText(errorMessageBy, expectedText);
    }
}