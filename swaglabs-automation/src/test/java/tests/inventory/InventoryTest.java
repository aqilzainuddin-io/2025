package tests.inventory;

import setup.BaseTest;
import pages.inventory.InventoryPage;
import pages.login.LoginPage;
import setup.EnvReader;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class InventoryTest extends BaseTest {
    
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void verifyAddAllItemsToCart() {
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        inventoryPage.isInventoryTitleVisible();
        inventoryPage.addAllItemsToCart();
        Assert.assertEquals(inventoryPage.getCartItemCount(), 6,
        "Cart badge should show 6 items");
    }

    @Test
    public void verifyRemoveAllItemsFromCart() {
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        inventoryPage.isInventoryTitleVisible();
        inventoryPage.addAllItemsToCart();
        inventoryPage.removeAllItemsFromCart();
        Assert.assertEquals(inventoryPage.getCartItemCount(), 0,
        "Cart badge should show 0 items after removing all items");
    }

    @Test
    public void verifyCartBadgeUpdatesCorrectly() {
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        inventoryPage.isInventoryTitleVisible();
        Assert.assertEquals(inventoryPage.getCartItemCount(), 0, "Cart badge should start with 0 items");
        inventoryPage.addAllItemsToCart();
        Assert.assertEquals(inventoryPage.getCartItemCount(), 6, "Cart badge should show 6 items after adding all items");
        inventoryPage.removeBackPackItemFromCart();
        inventoryPage.removeBikeLightItemFromCart();
        Assert.assertEquals(inventoryPage.getCartItemCount(), 4, "Cart badge should show 4 items after removing back pack and bike light items");
    }
}
