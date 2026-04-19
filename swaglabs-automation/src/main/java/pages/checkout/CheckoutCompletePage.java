package pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class CheckoutCompletePage extends BasePage {
    
    private By titleText = By.cssSelector("[data-test='title']");
    
    private By thankYouMessage = By.cssSelector("[data-test='complete-header']");
    private By orderConfirmationMessage = By.cssSelector("[data-test='complete-text']");

    private By backHomeButton = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckoutCompleteTitleVisible() {
        return isElementDisplayed(titleText);
    }

    public boolean isThankYouMessageVisible() {
        return isElementDisplayed(thankYouMessage);
    }
    
    public boolean isOrderConfirmationMessageVisible() {
        return isElementDisplayed(orderConfirmationMessage);
    }

    public void clickBackHome() {
        click(backHomeButton);
    }
}