package tests.checkout;

import setup.BaseTest;
import pages.checkout.CheckoutStepOnePage;
import pages.checkout.CheckoutStepTwoPage;
import pages.cart.CartPage;
import pages.checkout.CheckoutCompletePage;
import pages.inventory.InventoryPage;
import pages.login.LoginPage;
import setup.EnvReader;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;


public class CheckoutTest extends BaseTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutStepOnePage checkoutStepOnePage;
    private CheckoutStepTwoPage checkoutStepTwoPage;
    private CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @Test
    public void completeCheckoutTest() {

        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(inventoryPage.isInventoryTitleVisible());
        inventoryPage.addAllItemsToCart();
        Assert.assertEquals(inventoryPage.getCartItemCount(), 6,
        "Cart badge should show 6 items");
        inventoryPage.goToShoppingCart();

        Assert.assertTrue(cartPage.isCartTitleVisible());
        Assert.assertTrue(cartPage.verifyAllItemsInCart());
        Assert.assertEquals(cartPage.getCartItemCount(), 6,
        "Cart badge should show 6 items");
        cartPage.clickCheckout();

        Assert.assertTrue(checkoutStepOnePage.isCheckoutStepOneTitleVisible());
        checkoutStepOnePage.fillCheckoutInformation(
            EnvReader.get("FIRST_NAME"),
            EnvReader.get("LAST_NAME"),
            EnvReader.get("POSTAL_CODE")
        );
        checkoutStepOnePage.clickContinue();

        Assert.assertTrue(checkoutStepTwoPage.isCheckoutStepTwoTitleVisible());
        Assert.assertEquals(checkoutStepTwoPage.getCartItemCount(), 6,
        "Cart badge should show 6 items");
        Assert.assertTrue(checkoutStepTwoPage.verifyAllItemsInCheckout());
        Assert.assertTrue(checkoutStepTwoPage.isPaymentInformationLabelVisible());
        Assert.assertTrue(checkoutStepTwoPage.isShippingInformationLabelVisible());
        Assert.assertTrue(checkoutStepTwoPage.isPriceTotalLabelVisible());
        checkoutStepTwoPage.clickFinish();

        Assert.assertTrue(checkoutCompletePage.isCheckoutCompleteTitleVisible());
        Assert.assertTrue(checkoutCompletePage.isThankYouMessageVisible());
        Assert.assertTrue(checkoutCompletePage.isOrderConfirmationMessageVisible());
    }

    @Test
    public void cancelCheckoutTest() {

        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(inventoryPage.isInventoryTitleVisible());
        inventoryPage.addAllItemsToCart();
        Assert.assertEquals(inventoryPage.getCartItemCount(), 6,
        "Cart badge should show 6 items");
        inventoryPage.goToShoppingCart();

        Assert.assertTrue(cartPage.isCartTitleVisible());
        Assert.assertTrue(cartPage.verifyAllItemsInCart());
        Assert.assertEquals(cartPage.getCartItemCount(), 6,
        "Cart badge should show 6 items");
        cartPage.clickCheckout();

        Assert.assertTrue(checkoutStepOnePage.isCheckoutStepOneTitleVisible());
        checkoutStepOnePage.fillCheckoutInformation(
            EnvReader.get("FIRST_NAME"),
            EnvReader.get("LAST_NAME"),
            EnvReader.get("POSTAL_CODE")
        );
        checkoutStepOnePage.clickContinue();

        Assert.assertTrue(checkoutStepTwoPage.isCheckoutStepTwoTitleVisible());
        Assert.assertEquals(checkoutStepTwoPage.getCartItemCount(), 6,
        "Cart badge should show 6 items");
        Assert.assertTrue(checkoutStepTwoPage.verifyAllItemsInCheckout());
        Assert.assertTrue(checkoutStepTwoPage.isPaymentInformationLabelVisible());
        Assert.assertTrue(checkoutStepTwoPage.isShippingInformationLabelVisible());
        Assert.assertTrue(checkoutStepTwoPage.isPriceTotalLabelVisible());
        checkoutStepTwoPage.clickCancel();

        Assert.assertTrue(inventoryPage.isInventoryTitleVisible());
        Assert.assertEquals(inventoryPage.getCartItemCount(), 6,
        "Cart badge should show 6 items");
    }
}
