import { Page, Locator } from '@playwright/test';

export class CartPage {
  readonly page: Page;
  readonly checkoutButton: Locator;

  constructor(page: Page) {
    this.page = page;
    this.checkoutButton = page.locator('#checkout');
  }

  async clickCheckout() {
    await this.checkoutButton.click();
  }

  async removeItem(productName: string) {
    await this.page.getByTestId('inventory-item').filter({ hasText: productName }).getByRole('button', { name: 'Remove' }).click();
  }

  getCartItem(productName: string): Locator {
    return this.page.getByTestId('inventory-item').filter({ hasText: productName });
  }

  getCartItemName(productName: string): Locator {
    return this.getCartItem(productName).getByTestId('inventory-item-name');
  }

  getCartItemDescription(productName: string): Locator {
    return this.getCartItem(productName).getByTestId('inventory-item-desc');
  }

  getCartItemPrice(productName: string): Locator {
    return this.getCartItem(productName).getByTestId('inventory-item-price');
  }
}
