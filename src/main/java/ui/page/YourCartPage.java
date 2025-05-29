package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCartPage extends BasePage {
    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    By inventoryItemBy = By.className("inventory_item_name");

    public void verifyInventoryItemIsSauceLabsBackPack() {
        assertElementText(inventoryItemBy, "Sauce Labs Backpack");
    }
}