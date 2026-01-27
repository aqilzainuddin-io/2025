import { test, expect } from '@playwright/test';
import { LoginPage } from '../pages/LoginPage';
import { InventoryPage } from '../pages/InventoryPage';
import { CartPage } from '../pages/CartPage';
import { CheckoutPage } from '../pages/CheckoutPage';

test('checkout items and fill checkout information', async ({ page }) => {
  const loginPage = new LoginPage(page);
  const inventoryPage = new InventoryPage(page);
  const cartPage = new CartPage(page);
  const checkoutPage = new CheckoutPage(page);

  await loginPage.goto();
  await loginPage.login('standard_user', 'secret_sauce');

  // define products to be added to cart
  const products = [
    { name: 'Sauce Labs Backpack', price: '$29.99' },
    { name: 'Sauce Labs Bike Light', price: '$9.99' },
    { name: 'Sauce Labs Bolt T-Shirt', price: '$15.99' },
    { name: 'Sauce Labs Fleece Jacket', price: '$49.99' },
    { name: 'Sauce Labs Onesie', price: '$7.99' },
    { name: 'Test.allTheThings() T-Shirt (Red)', price: '$15.99' },
  ];

  // add all products to cart
  for (const product of products) {
    await inventoryPage.addItemToCart(product.name);
  }

  // navigate to cart page
  await inventoryPage.goToCart();

  // verify cart items details
  for (const product of products) {
    await expect(cartPage.getCartItemName(product.name)).toHaveText(product.name);
    await expect(cartPage.getCartItemDescription(product.name)).toBeVisible();
    await expect(cartPage.getCartItemPrice(product.name)).toHaveText(product.price);
  }

  // proceed to checkout and fill checkout information
  await cartPage.clickCheckout();
  await checkoutPage.fillCheckoutInfo('John', 'Doe', '92000');
  await checkoutPage.clickContinue();
  await expect(page).toHaveURL(/.*checkout-step-two.html/);
});
