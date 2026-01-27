import { test, expect } from '@playwright/test';
import { LoginPage } from '../pages/LoginPage';
import { InventoryPage } from '../pages/InventoryPage';

test('adding items to cart', async ({ page }) => {
  const loginPage = new LoginPage(page);

  await loginPage.goto();

  await loginPage.login('standard_user', 'secret_sauce');
  await expect(page).toHaveURL(/inventory/);

  const inventoryPage = new InventoryPage(page);

  const productsToAdd = [
    { name: 'Sauce Labs Backpack', price: '$29.99' },
    { name: 'Sauce Labs Bike Light', price: '$9.99' },
    { name: 'Sauce Labs Bolt T-Shirt', price: '$15.99' },
    { name: 'Sauce Labs Fleece Jacket', price: '$49.99' },
    { name: 'Sauce Labs Onesie', price: '$7.99' },
    { name: 'Test.allTheThings() T-Shirt (Red)', price: '$15.99' },
  ];

  let cartCount = 0;

  for (const product of productsToAdd) {
    await expect(inventoryPage.getItemName(product.name)).toBeVisible();
    await expect(inventoryPage.getItemDescription(product.name)).toBeVisible();
    await expect(inventoryPage.getItemPrice(product.name)).toHaveText(product.price);
    await inventoryPage.addItemToCart(product.name);
    cartCount++;
    await expect(page.getByTestId('shopping-cart-badge')).toHaveText(cartCount.toString());
  }
});
