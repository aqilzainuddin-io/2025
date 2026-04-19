package pages.checkout;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.base.BasePage;

public class CheckoutStepOnePage extends BasePage {
    
    private By titleText = By.cssSelector("[data-test='title']");
    private By shoppingCartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");
    
    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckoutStepOneTitleVisible() {
        return isElementDisplayed(titleText);
    }

    public int getCartItemCount() {
        List<WebElement> badges = driver.findElements(shoppingCartBadge);
        return badges.isEmpty() ? 0 : Integer.parseInt(badges.get(0).getText());
    }

    public void enterFirstName(String firstName) {
        type(firstNameField, firstName);
    }
    public void enterLastName(String lastName) {
        type(lastNameField, lastName);
    }
    public void enterPostalCode(String postalCode) {
        type(postalCodeField, postalCode);
    }

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }

    public void clickContinue() {
        click(continueButton);
    }
    public void clickCancel() {
        click(cancelButton);
    }
}
