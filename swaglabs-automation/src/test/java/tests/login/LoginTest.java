package tests.login;

import setup.BaseTest;
import pages.inventory.InventoryPage;
import pages.login.LoginPage;
import setup.EnvReader;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void validLoginTest() {
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(inventoryPage.isInventoryTitleVisible());
        Assert.assertTrue(inventoryPage.isBackPackItemVisible());
        Assert.assertTrue(inventoryPage.isBikeLightItemVisible());
        Assert.assertTrue(inventoryPage.isBoltTShirtItemVisible());
        Assert.assertTrue(inventoryPage.isFleeceJacketItemVisible());
        Assert.assertTrue(inventoryPage.isOnesieItemVisible());
        Assert.assertTrue(inventoryPage.isRedTShirtItemVisible());
    }

    @Test
    public void invalidLoginTest() {
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("INVALID_PASSWORD"));
        Assert.assertTrue(loginPage.isErrorMessageVisible(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void lockedOutUserLoginTest() {
        loginPage.login(EnvReader.get("LOCKED_OUT_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(loginPage.isErrorMessageVisible(),"Epic sadface: Sorry, this user has been locked out.");
    }
}
