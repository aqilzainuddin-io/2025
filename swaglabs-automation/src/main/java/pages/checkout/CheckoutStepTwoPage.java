package pages.checkout;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class CheckoutStepTwoPage extends BasePage {

    private By titleText = By.cssSelector("[data-test='title']");
    private By shoppingCartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    
    private By backPackItem = By.xpath("//div[text()='Sauce Labs Backpack']");
    private By bikeLightItem = By.xpath("//div[text()='Sauce Labs Bike Light']");
    private By boltTShirtItem = By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");
    private By fleeceJacketItem = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    private By onesieItem = By.xpath("//div[text()='Sauce Labs Onesie']");
    private By redTShirtItem = By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']");

    private By paymentInformationLabel = By.cssSelector("[data-test='payment-info-label']");
    private By shippingInformationLabel = By.cssSelector("[data-test='shipping-info-label']");
    private By priceTotalLabel = By.cssSelector("[data-test='total-info-label']");


    private By finishButton = By.id("finish");
    private By cancelButton = By.id("cancel");

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckoutStepTwoTitleVisible() {
        return isElementDisplayed(titleText);
    }

    public int getCartItemCount() {
        List<WebElement> badges = driver.findElements(shoppingCartBadge);
        return badges.isEmpty() ? 0 : Integer.parseInt(badges.get(0).getText());
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

    public boolean verifyAllItemsInCheckout() {
        return isBackPackItemVisible()
            && isBikeLightItemVisible()
            && isBoltTShirtItemVisible()
            && isFleeceJacketItemVisible()
            && isOnesieItemVisible()
            && isRedTShirtItemVisible();
    }

    public boolean isPaymentInformationLabelVisible() {
        return isElementDisplayed(paymentInformationLabel);
    }
    public boolean isShippingInformationLabelVisible() {
        return isElementDisplayed(shippingInformationLabel);
    }
    public boolean isPriceTotalLabelVisible() {
        return isElementDisplayed(priceTotalLabel);
    }

    public void clickFinish() {
        click(finishButton);
    }

    public void clickCancel() {
        click(cancelButton);
    }
    
}
