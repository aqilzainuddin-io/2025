import { test, expect } from '@playwright/test';

test('basic test', async ({ page }) => {
  await page.goto('https://jsonplaceholder.typicode.com/');
  expect(await page.title()).toBe('JSONPlaceholder - Free Fake REST API');
});
