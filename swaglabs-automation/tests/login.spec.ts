import { test, expect } from '@playwright/test';
import { LoginPage } from '../pages/LoginPage';

test.describe('login functionality', () => {

  test('login with valid credentials', async ({ page }) => {
    const loginPage = new LoginPage(page);

    await loginPage.goto();
    await loginPage.login('standard_user', 'secret_sauce');

    // verify user is redirected to inventory page
    await expect(page).toHaveURL(/inventory/);
  });

  test('login with invalid credentials', async ({ page }) => {
    const loginPage = new LoginPage(page);

    await loginPage.goto();
    await loginPage.login('invalid_user', 'invalid_password');

    // verify invalid credentials error message
    await expect(loginPage.invalidCredMsg).toHaveText('Epic sadface: Username and password do not match any user in this service');
  });

  test('username is required error message is displayed', async ({ page }) => {
    const loginPage = new LoginPage(page);

    await loginPage.goto();
    await loginPage.login('', 'some_password');

    // verify username required error message
    await expect(loginPage.invalidCredMsg).toHaveText('Epic sadface: Username is required');
  });

  test('password is required error message is displayed', async ({ page }) => {
    const loginPage = new LoginPage(page);

    await loginPage.goto();
    await loginPage.login('some_user', '');

    // verify password required error message
    await expect(loginPage.invalidCredMsg).toHaveText('Epic sadface: Password is required');
  });

});
