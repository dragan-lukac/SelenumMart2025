package test.ui;

import org.testng.annotations.Test;
import ui.page.Header;
import ui.page.ProductsPage;
import ui.page.YourCartPage;

public class AddItemToCartTest extends BaseTestWithLogin{

    @Test
    public void addItemToCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        Header header = new Header(driver);
        YourCartPage yourCartPage = new YourCartPage(driver);
//        productsPage.addSauceLabsBackpackToCart();
//        header.clickOnShoppingCartButton();
        productsPage.addSauceLabsBackpackToCart().clickOnShoppingCartButton();
        yourCartPage.verifyInventoryItemIsSauceLabsBackPack();
    }

    @Test
    public void addRandomItemToCart(){
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addRandomItemToCart();
        productsPage.verifyItemIsAddedToCart();
    }

    @Test
    public void addItemWithMaxPrice() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addMaxPriceElementToCart();
    }
}