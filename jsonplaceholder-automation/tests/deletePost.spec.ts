import { test, expect } from '@playwright/test';

const baseURL = 'https://jsonplaceholder.typicode.com/posts';
let postId: number; // Store the ID of the post we create for deletion

// Create a temporary post before running the DELETE tests
test.beforeAll(async ({ request }) => {
  const response = await request.post(baseURL, {
    data: { title: 'Temp Post for DELETE', body: 'Body to delete', userId: 1 }
  });
  const body = await response.json();
  postId = body.id; // Save post ID for DELETE
  console.log('post created for DELETE test:', postId);
});

test('Delete - DELETE the post', async ({ request }) => {
  // Send DELETE request
  const response = await request.delete(`${baseURL}/${postId}`);
  // JSONPlaceholder may return 200 or 204 for delete
  expect([200, 204]).toContain(response.status());
  console.log('Deleted post with id:', postId);
});

test('Verify Deletion - GET deleted post should fail (expected)', async ({ request }) => {
  // Attempt to GET the post after deletion
  const response = await request.get(`${baseURL}/${postId}`);
  console.log('GET after DELETE returned', response.status(), '(expected for JSONPlaceholder fake API)');
});
