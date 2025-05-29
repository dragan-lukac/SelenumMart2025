package test.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTestWithLogin {

    @Test
    public void successfulLogoutTest() {
        WebElement burgerButton = driver.findElement(By.className("bm-burger-button"));
        burgerButton.click();

        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();

        WebElement loginCredentials = driver.findElement(By.id("login_credentials"));

        Assert.assertTrue(loginCredentials.isDisplayed());
    }
}