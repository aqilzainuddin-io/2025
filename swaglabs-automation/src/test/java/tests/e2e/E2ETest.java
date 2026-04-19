package tests.e2e;

import setup.BaseTest;
import pages.checkout.CheckoutStepOnePage;
import pages.checkout.CheckoutStepTwoPage;
import pages.cart.CartPage;
import pages.checkout.CheckoutCompletePage;
import pages.inventory.InventoryPage;
import pages.login.LoginPage;
import pages.menu.SideMenuPage;
import setup.EnvReader;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;


public class E2ETest extends BaseTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutStepOnePage checkoutStepOnePage;
    private CheckoutStepTwoPage checkoutStepTwoPage;
    private CheckoutCompletePage checkoutCompletePage;
    private SideMenuPage sideMenuPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        sideMenuPage = new SideMenuPage(driver);
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

        Assert.assertTrue(sideMenuPage.isMenuButtonVisible());
        sideMenuPage.clickMenuButton();
        Assert.assertTrue(sideMenuPage.isAllItemsLinkVisible());
        Assert.assertTrue(sideMenuPage.isLogoutLinkVisible());
        sideMenuPage.clickLogoutLink();
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
        
        Assert.assertTrue(sideMenuPage.isMenuButtonVisible());
        sideMenuPage.clickMenuButton();
        Assert.assertTrue(sideMenuPage.isAllItemsLinkVisible());
        Assert.assertTrue(sideMenuPage.isLogoutLinkVisible());
        sideMenuPage.clickLogoutLink();
    }

    @Test
    public void checkoutFourItemsTest() {
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(inventoryPage.isInventoryTitleVisible());
        inventoryPage.addBackPackItemToCart();
        inventoryPage.addBoltTShirtItemToCart();
        inventoryPage.addFleeceJacketItemToCart();
        inventoryPage.addOnesieItemToCart();
        Assert.assertEquals(inventoryPage.getCartItemCount(), 4,
        "Cart badge should show 4 items");
        inventoryPage.goToShoppingCart();

        Assert.assertTrue(cartPage.isCartTitleVisible());
        Assert.assertTrue(cartPage.isBackPackItemVisible());
        Assert.assertTrue(cartPage.isBoltTShirtItemVisible());
        Assert.assertTrue(cartPage.isFleeceJacketItemVisible());
        Assert.assertTrue(cartPage.isOnesieItemVisible());
        Assert.assertEquals(cartPage.getCartItemCount(), 4,
        "Cart badge should show 4 items");
        cartPage.clickCheckout();

        Assert.assertTrue(checkoutStepOnePage.isCheckoutStepOneTitleVisible());
        checkoutStepOnePage.fillCheckoutInformation(
            EnvReader.get("FIRST_NAME"),
            EnvReader.get("LAST_NAME"),
            EnvReader.get("POSTAL_CODE")
        );
        checkoutStepOnePage.clickContinue();

        Assert.assertTrue(checkoutStepTwoPage.isCheckoutStepTwoTitleVisible());
        Assert.assertEquals(checkoutStepTwoPage.getCartItemCount(), 4,
        "Cart badge should show 4 items");
        Assert.assertTrue(checkoutStepTwoPage.isBackPackItemVisible());
        Assert.assertTrue(checkoutStepTwoPage.isBoltTShirtItemVisible());
        Assert.assertTrue(checkoutStepTwoPage.isFleeceJacketItemVisible());
        Assert.assertTrue(checkoutStepTwoPage.isOnesieItemVisible());
        Assert.assertTrue(checkoutStepTwoPage.isPaymentInformationLabelVisible());
        Assert.assertTrue(checkoutStepTwoPage.isShippingInformationLabelVisible());
        Assert.assertTrue(checkoutStepTwoPage.isPriceTotalLabelVisible());
        checkoutStepTwoPage.clickFinish();

        Assert.assertTrue(checkoutCompletePage.isCheckoutCompleteTitleVisible());
        Assert.assertTrue(checkoutCompletePage.isThankYouMessageVisible());
        Assert.assertTrue(checkoutCompletePage.isOrderConfirmationMessageVisible());

        Assert.assertTrue(sideMenuPage.isMenuButtonVisible());
        sideMenuPage.clickMenuButton();
        Assert.assertTrue(sideMenuPage.isAllItemsLinkVisible());
        Assert.assertTrue(sideMenuPage.isLogoutLinkVisible());
        sideMenuPage.clickLogoutLink();
    }

    @Test
    public void checkoutOneItemTest() {
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
        cartPage.clickRemoveBikeLight();
        cartPage.clickRemoveBoltTShirt();
        cartPage.clickRemoveFleeceJacket();
        cartPage.clickRemoveOnesie();
        cartPage.clickRemoveRedTShirt();
        Assert.assertEquals(cartPage.getCartItemCount(), 1,
        "Cart badge should show 1 item");
        cartPage.clickCheckout();

        Assert.assertTrue(checkoutStepOnePage.isCheckoutStepOneTitleVisible());
        checkoutStepOnePage.fillCheckoutInformation(
            EnvReader.get("FIRST_NAME"),
            EnvReader.get("LAST_NAME"),
            EnvReader.get("POSTAL_CODE")
        );
        checkoutStepOnePage.clickContinue();

        Assert.assertTrue(checkoutStepTwoPage.isCheckoutStepTwoTitleVisible());
        Assert.assertEquals(checkoutStepTwoPage.getCartItemCount(), 1,
        "Cart badge should show 1 item");
        Assert.assertTrue(checkoutStepTwoPage.isBackPackItemVisible());
        Assert.assertTrue(checkoutStepTwoPage.isPaymentInformationLabelVisible());
        Assert.assertTrue(checkoutStepTwoPage.isShippingInformationLabelVisible());
        Assert.assertTrue(checkoutStepTwoPage.isPriceTotalLabelVisible());
        checkoutStepTwoPage.clickFinish();

        Assert.assertTrue(checkoutCompletePage.isCheckoutCompleteTitleVisible());
        Assert.assertTrue(checkoutCompletePage.isThankYouMessageVisible());
        Assert.assertTrue(checkoutCompletePage.isOrderConfirmationMessageVisible());
        
        Assert.assertTrue(sideMenuPage.isMenuButtonVisible());
        sideMenuPage.clickMenuButton();
        Assert.assertTrue(sideMenuPage.isAllItemsLinkVisible());
        Assert.assertTrue(sideMenuPage.isLogoutLinkVisible());
        sideMenuPage.clickLogoutLink();
    }
}   