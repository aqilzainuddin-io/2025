import { test, expect } from '@playwright/test';
import { LoginPage } from '../pages/LoginPage';
import { InventoryPage } from '../pages/InventoryPage';
import { CartPage } from '../pages/CartPage';
import { CheckoutPage } from '../pages/CheckoutPage';
import { CheckoutStepTwoPage } from '../pages/CheckoutStepTwoPage'; // new

test('User can fill checkout info, verify overview, and finish checkout with 6 items', async ({ page }) => {
  const loginPage = new LoginPage(page);
  const inventoryPage = new InventoryPage(page);
  const cartPage = new CartPage(page);
  const checkoutPage = new CheckoutPage(page);
  const checkoutStepTwo = new CheckoutStepTwoPage(page);

  await loginPage.goto();
  await loginPage.login('standard_user', 'secret_sauce');

  const products = [
    { name: 'Sauce Labs Backpack', price: '$29.99' },
    { name: 'Sauce Labs Bike Light', price: '$9.99' },
    { name: 'Sauce Labs Bolt T-Shirt', price: '$15.99' },
    { name: 'Sauce Labs Fleece Jacket', price: '$49.99' },
    { name: 'Sauce Labs Onesie', price: '$7.99' },
    { name: 'Test.allTheThings() T-Shirt (Red)', price: '$15.99' },
  ];

  for (const product of products) {
    await inventoryPage.addItemToCart(product.name);
  }

  // Go to cart and verify items
  await inventoryPage.goToCart();
  for (const product of products) {
    await expect(cartPage.getCartItemName(product.name)).toHaveText(product.name);
    await expect(cartPage.getCartItemDescription(product.name)).toBeVisible();
    await expect(cartPage.getCartItemPrice(product.name)).toHaveText(product.price);
  }

  await cartPage.clickCheckout();
  await checkoutPage.fillCheckoutInfo('John', 'Doe', '92000');
  await checkoutPage.clickContinue();

  await expect(page).toHaveURL(/.*checkout-step-two.html/);

  const stepTwoItems = await checkoutStepTwo.getItemDetails();
  expect(stepTwoItems).toEqual(
    products.map(product => ({
      name: product.name,
      price: product.price,
      quantity: '1',
    }))
  );

  await checkoutStepTwo.clickFinish();

  await expect(page).toHaveURL(/.*checkout-complete.html/);
  await expect(page.locator('.complete-header')).toHaveText('Thank you for your order!');
});
