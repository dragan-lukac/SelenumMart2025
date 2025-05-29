package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;

import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    By productsPageTitleBy = By.className("title");
    By addBackpackToCartButtonBy = By.id("add-to-cart-sauce-labs-backpack");
    By inventoryItemBy = By.xpath("//div[@class='inventory_item']");
    By addToCartButtonBy = By.xpath("//button[contains(@id, 'add-to-cart')]");
    By removeFromCartByttonBy = By.xpath("//button[text()='Remove']");
    By itemPriceBy = By.className("inventory_item_price");
    public By addToCartButtonInsideInventoryItemBy = By.xpath("/button[text()='Add to cart']");
    public void verifyImOnProductsPage() {
        assertElementText(productsPageTitleBy, "Products");
    }

    public Header addSauceLabsBackpackToCart() {
        click(addBackpackToCartButtonBy);
        return new Header(driver);
    }

    public void addRandomItemToCart() {
        WebElement randomItem = getRandomWebElement(addToCartButtonBy);
        click(randomItem);
    }

    public void addMaxPriceItemToCart() {
        WebElement maxPriceItem = getMaxPriceItem();
        click(maxPriceItem);
    }

    public WebElement getMaxPriceItem() {
        List<WebElement> webElementList = driver.findElements(inventoryItemBy);
        int listSize = webElementList.size();
        if (listSize == 0) {
            throw new SkipException("No Available items in web elements list");
        }
        double maxPrice = getPriceAsDoubleFromInventoryItem(webElementList.get(0));
        WebElement maxPriceWebElement = webElementList.get(0);
        for (int i = 1; i < listSize; i++) {
            double price = getPriceAsDoubleFromInventoryItem(webElementList.get(i));
            if (price > maxPrice) {
                maxPrice = price;
                maxPriceWebElement = webElementList.get(i);
            }
        }
        return maxPriceWebElement;
    }

    private double getPriceAsDoubleFromInventoryItem(WebElement webElement) {
        String priceAsString = webElement.findElement(itemPriceBy).getText();
        String priceAsStringNoDollar = priceAsString.replace("$", "");
        return Double.parseDouble(priceAsStringNoDollar);
    }

    public void verifyItemIsAddedToCart() {
        Assert.assertTrue(isElementDisplayed(removeFromCartByttonBy), "Remove button is not displayed");
    }

    public void addMaxPriceElementToCart() {
        WebElement maxPriceItem = getMaxPriceItem();
        click(maxPriceItem.findElement(By.tagName("button")));
    }
}