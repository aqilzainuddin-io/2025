package pages.inventory;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class InventoryPage extends BasePage {
    
    private By titleText = By.cssSelector("[data-test='title']");
    private By backPackItem = By.xpath("//div[text()='Sauce Labs Backpack']");
    private By bikeLightItem = By.xpath("//div[text()='Sauce Labs Bike Light']");
    private By boltTShirtItem = By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");
    private By fleeceJacketItem = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    private By onesieItem = By.xpath("//div[text()='Sauce Labs Onesie']");
    private By redTShirtItem = By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']");

    private By addToCartBackPackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By addToCartBikeLightButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By addToCartBoltTShirtButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By addToCartFleeceJacketButton = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By addToCartOnesieButton = By.id("add-to-cart-sauce-labs-onesie");
    private By addToCartRedTShirtButton = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    private By removeBackPackButton = By.id("remove-sauce-labs-backpack");
    private By removeBikeLightButton = By.id("remove-sauce-labs-bike-light");
    private By removeBoltTShirtButton = By.id("remove-sauce-labs-bolt-t-shirt");
    private By removeFleeceJacketButton = By.id("remove-sauce-labs-fleece-jacket");
    private By removeOnesieButton = By.id("remove-sauce-labs-onesie");
    private By removeRedTShirtButton = By.id("remove-test.allthethings()-t-shirt-(red)");

    private By shoppingCartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private By shoppingCartLink = By.cssSelector("[data-test='shopping-cart-link']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInventoryTitleVisible() {
        return isElementDisplayed(titleText);
    }
    public boolean isBackPackItemVisible() {
        return isElementDisplayed(backPackItem);
    }
    public boolean isBikeLightItemVisible() {
        return isElementDisplayed(bikeLightItem);
    }
    public boolean isBoltTShirtItemVisible() {
        return isElementDisplayed(boltTShirtItem);
    }
    public boolean isFleeceJacketItemVisible() {
        return isElementDisplayed(fleeceJacketItem);
    }
    public boolean isOnesieItemVisible() {
        return isElementDisplayed(onesieItem);
    }
    public boolean isRedTShirtItemVisible() {
        return isElementDisplayed(redTShirtItem);
    }

    public void addAllItemsToCart() {
        click(addToCartBackPackButton);
        click(addToCartBikeLightButton);
        click(addToCartBoltTShirtButton);
        click(addToCartFleeceJacketButton);
        click(addToCartOnesieButton);
        click(addToCartRedTShirtButton);
    }

    public void addBackPackItemToCart() {
        click(addToCartBackPackButton);
    }
    public void addBikeLightItemToCart() {
        click(addToCartBikeLightButton);
    }
    public void addBoltTShirtItemToCart() {
        click(addToCartBoltTShirtButton);
    }
    public void addFleeceJacketItemToCart() {
        click(addToCartFleeceJacketButton);
    }
    public void addOnesieItemToCart() {
        click(addToCartOnesieButton);
    }

    public void removeAllItemsFromCart() {
        click(removeBackPackButton);
        click(removeBikeLightButton);
        click(removeBoltTShirtButton);
        click(removeFleeceJacketButton);
        click(removeOnesieButton);
        click(removeRedTShirtButton);
    }

    public void removeBackPackItemFromCart() {
        click(removeBackPackButton);
    }
    public void removeBikeLightItemFromCart() {
        click(removeBikeLightButton);
    }
    public void removeBoltTShirtItemFromCart() {
        click(removeBoltTShirtButton);
    }
    public void removeFleeceJacketItemFromCart() {
        click(removeFleeceJacketButton);
    }
    public void removeOnesieItemFromCart() {
        click(removeOnesieButton);
    }
    public void removeRedTShirtItemFromCart() {
        click(removeRedTShirtButton);
    }

    public int getCartItemCount() {
        List<WebElement> badges = driver.findElements(shoppingCartBadge);
        return badges.isEmpty() ? 0 : Integer.parseInt(badges.get(0).getText());
    }

    public void goToShoppingCart() {
        click(shoppingCartLink);
    }
}
