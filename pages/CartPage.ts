import { Page, Locator } from '@playwright/test';

export class CartPage {
  readonly page: Page;
  readonly checkoutButton: Locator;

  constructor(page: Page) {
    this.page = page;
    this.checkoutButton = page.getByTestId('checkout');
  }

  async clickCheckout() {
    await this.checkoutButton.click();
  }

  async removeItem(productName: string) {
    await this.page.locator('.cart_item').filter({ hasText: productName }).getByRole('button', { name: 'Remove' }).click();
  }

  getCartItem(productName: string): Locator {
    return this.page.locator('.cart_item').filter({ hasText: productName });
  }

  getCartItemName(productName: string): Locator {
    return this.getCartItem(productName).locator('.inventory_item_name');
  }

  getCartItemDescription(productName: string): Locator {
    return this.getCartItem(productName).locator('.inventory_item_desc');
  }

  getCartItemPrice(productName: string): Locator {
    return this.getCartItem(productName).locator('.inventory_item_price');
  }
}
