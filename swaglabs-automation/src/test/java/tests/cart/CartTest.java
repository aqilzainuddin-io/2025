package tests.cart;

import setup.BaseTest;
import pages.inventory.InventoryPage;
import pages.login.LoginPage;
import pages.cart.CartPage;
import setup.EnvReader;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class CartTest extends BaseTest {
    
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void verifyAddAllItemsToCart() {
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        inventoryPage.isInventoryTitleVisible();
        inventoryPage.addAllItemsToCart();
        Assert.assertEquals(inventoryPage.getCartItemCount(), 6,
        "Cart badge should show 6 items");
        inventoryPage.goToShoppingCart();
        Assert.assertTrue(cartPage.isCartTitleVisible());
        Assert.assertTrue(cartPage.verifyAllItemsInCart(), "All 6 items should be visible in the cart");
    }

    @Test
    public void verifyRemoveItemsFromCart() {
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        inventoryPage.isInventoryTitleVisible();
        inventoryPage.addAllItemsToCart();
        inventoryPage.goToShoppingCart();
        Assert.assertTrue(cartPage.isCartTitleVisible());
        Assert.assertEquals(cartPage.getCartItemCount(), 6,
        "Cart badge should show 6 items");
        cartPage.clickRemoveBackPack();
        cartPage.clickRemoveBikeLight();
        Assert.assertEquals(cartPage.getCartItemCount(), 4,
        "Cart badge should show 4 items");
        Assert.assertTrue(cartPage.isBoltTShirtItemVisible());
        Assert.assertTrue(cartPage.isFleeceJacketItemVisible());
        Assert.assertTrue(cartPage.isOnesieItemVisible());
        Assert.assertTrue(cartPage.isRedTShirtItemVisible());
    }
}
