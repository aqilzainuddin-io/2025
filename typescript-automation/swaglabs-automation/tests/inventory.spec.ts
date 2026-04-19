import { test, expect } from '@playwright/test';
import { LoginPage } from '../pages/LoginPage';
import { InventoryPage } from '../pages/InventoryPage';

test('adding items to cart', async ({ page }) => {
  const loginPage = new LoginPage(page);

  await loginPage.goto();

  await loginPage.login('standard_user', 'secret_sauce');
  await expect(page).toHaveURL(/inventory/);

  // initialize inventory page object
  const inventoryPage = new InventoryPage(page);

  // define products to be added to cart
  const productsToAdd = [
    { name: 'Sauce Labs Backpack', price: '$29.99' },
    { name: 'Sauce Labs Bike Light', price: '$9.99' },
    { name: 'Sauce Labs Bolt T-Shirt', price: '$15.99' },
    { name: 'Sauce Labs Fleece Jacket', price: '$49.99' },
    { name: 'Sauce Labs Onesie', price: '$7.99' },
    { name: 'Test.allTheThings() T-Shirt (Red)', price: '$15.99' },
  ];

  // track expected cart item count
  let cartCount = 0;

  // loop through each product and add to cart
  for (const product of productsToAdd) {
    await expect(inventoryPage.getItemName(product.name)).toBeVisible();
    await expect(inventoryPage.getItemDescription(product.name)).toBeVisible();
    
    // verify product price matches expected value
    await expect(inventoryPage.getItemPrice(product.name)).toHaveText(product.price);
    
    // add product to cart
    await inventoryPage.addItemToCart(product.name);
    
    // increment expected cart count
    cartCount++;
    
    // verify cart badge updates correctly
    await expect(page.getByTestId('shopping-cart-badge')).toHaveText(cartCount.toString());
  }
});
