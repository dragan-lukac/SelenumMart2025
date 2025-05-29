package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);
    }

    By shoppingCartBy = By.id("shopping_cart_container");

    public void clickOnShoppingCartButton() {
        click(shoppingCartBy);
    }
}