import { Page, Locator } from '@playwright/test';

export class CheckoutStepTwoPage {
    readonly page: Page;
    readonly itemNames: Locator;
    readonly itemPrices: Locator;
    readonly itemQuantities: Locator;
    readonly finishBtn: Locator;

    constructor(page: Page) {
        this.page = page;
        this.itemNames = page.locator('.cart_item .inventory_item_name');
        this.itemPrices = page.locator('.cart_item .inventory_item_price');
        this.itemQuantities = page.locator('.cart_quantity');
        this.finishBtn = page.locator('#finish'); // finish button
    }

    async getItemDetails() {
        const names = await this.itemNames.allTextContents();
        const prices = await this.itemPrices.allTextContents();
        const quantities = await this.itemQuantities.allTextContents();
        return names.map((name, index) => ({
            name,
            price: prices[index],
            quantity: quantities[index],
        }));
    }

    async clickFinish() {
        await this.finishBtn.click();
    }
}
