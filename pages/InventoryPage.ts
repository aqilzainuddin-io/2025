import { Page, Locator } from '@playwright/test';

export class InventoryPage {
  readonly page: Page;

  readonly inventoryItems: Locator;

  constructor(page: Page) {
    this.page = page;

    this.inventoryItems = page.getByTestId('inventory-item');
  }

  getItemByName(itemName: string): Locator {
    return this.inventoryItems.filter({ hasText: itemName });
  }

  getItemName(itemName: string): Locator {
    return this.getItemByName(itemName).getByTestId('inventory-item-name');
  }

  getItemDescription(itemName: string): Locator {
    return this.getItemByName(itemName).getByTestId('inventory-item-desc');
  }

  getItemPrice(itemName: string): Locator {
    return this.getItemByName(itemName).getByTestId('inventory-item-price');
  }

  async addItemToCart(itemName: string): Promise<void> {
    const item = this.getItemByName(itemName);
    await item.getByRole('button', { name: 'Add to cart' }).click();
  }

  async goToCart(): Promise<void> {
    await this.page.getByTestId('shopping-cart-link').click();
  }
}
