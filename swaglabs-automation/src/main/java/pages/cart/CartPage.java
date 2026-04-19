package pages.cart;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.base.BasePage;

public class CartPage extends BasePage {
    private By cartTitle = By.cssSelector("[data-test='title']");
    
    private By backPackItem = By.xpath("//div[text()='Sauce Labs Backpack']");
    private By bikeLightItem = By.xpath("//div[text()='Sauce Labs Bike Light']");
    private By boltTShirtItem = By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");
    private By fleeceJacketItem = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    private By onesieItem = By.xpath("//div[text()='Sauce Labs Onesie']");
    private By redTShirtItem = By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']");

    private By removeBackPackButton = By.id("remove-sauce-labs-backpack");
    private By removeBikeLightButton = By.id("remove-sauce-labs-bike-light");
    private By removeBoltTShirtButton = By.id("remove-sauce-labs-bolt-t-shirt");
    private By removeFleeceJacketButton = By.id("remove-sauce-labs-fleece-jacket");
    private By removeOnesieButton = By.id("remove-sauce-labs-onesie");
    private By removeRedTShirtButton = By.id("remove-test.allthethings()-t-shirt-(red)");

    private By shoppingCartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    
    private By checkoutButton = By.id("checkout");
    private By continueShoppingButton = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartTitleVisible() {
        return isElementDisplayed(cartTitle);
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

    public boolean verifyAllItemsInCart() {
        return isBackPackItemVisible() 
            && isBikeLightItemVisible() 
            && isBoltTShirtItemVisible() 
            && isFleeceJacketItemVisible() 
            && isOnesieItemVisible() 
            && isRedTShirtItemVisible();
    }

    public void clickRemoveBackPack() {
        click(removeBackPackButton);
    }
    public void clickRemoveBikeLight() {
        click(removeBikeLightButton);
    }
    public void clickRemoveBoltTShirt() {
        click(removeBoltTShirtButton);
    }
    public void clickRemoveFleeceJacket() {
        click(removeFleeceJacketButton);
    }
    public void clickRemoveOnesie() {
        click(removeOnesieButton);
    }
    public void clickRemoveRedTShirt() {
        click(removeRedTShirtButton);
    }

    public int getCartItemCount() {
        List<WebElement> badges = driver.findElements(shoppingCartBadge);
        return badges.isEmpty() ? 0 : Integer.parseInt(badges.get(0).getText());
    }

    public void clickCheckout() {
        click(checkoutButton);
    }

    public void clickContinueShopping() {
        click(continueShoppingButton);
    }
    
}
