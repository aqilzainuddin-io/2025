import { Page, Locator } from '@playwright/test';

export class CheckoutCompletePage {
  readonly page: Page;
  readonly completeHeader: Locator;
  readonly completeMessage: Locator;
  readonly backHomeBtn: Locator;

  constructor(page: Page) {
    this.page = page;
    this.completeHeader = page.getByTestId('complete-header');
    this.completeMessage = page.getByTestId('complete-text');
    this.backHomeBtn = page.locator('#back-to-products');
  }

  async getCompleteHeaderText(): Promise<string> {
    return await this.completeHeader.textContent() ?? '';
  }

  async getCompleteMessageText(): Promise<string> {
    return await this.completeMessage.textContent() ?? '';
  }

  async isBackHomeBtnVisible(): Promise<boolean> {
    return await this.backHomeBtn.isVisible();
  }

  async clickBackHome() {
    await this.backHomeBtn.click();
  }
}
