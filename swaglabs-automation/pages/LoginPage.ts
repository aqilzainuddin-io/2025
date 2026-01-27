import { Page, Locator } from '@playwright/test';

/**
 * Page Object Model for Login Page
 * Handles locators and user actions only
 */
export class LoginPage {
  readonly page: Page;

  // Form fields
  readonly usernameField: Locator;
  readonly passwordField: Locator;
  readonly loginButton: Locator;

  // Error messages
  readonly invalidCredMsg: Locator;

  constructor(page: Page) {
    this.page = page;

    // Inputs & actions
    this.usernameField = page.getByTestId('username');
    this.passwordField = page.getByTestId('password');
    this.loginButton = page.getByTestId('login-button');

    // Error messages
    this.invalidCredMsg = page.getByTestId('error');
  }

  async goto() {
    await this.page.goto('https://www.saucedemo.com/');
  }

  async login(username: string, password: string) {
    await this.usernameField.fill(username);
    await this.passwordField.fill(password);
    await this.loginButton.click();
  }
}
