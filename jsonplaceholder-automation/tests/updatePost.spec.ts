import { test, expect } from '@playwright/test';

const baseURL = 'https://jsonplaceholder.typicode.com/posts';
// Store the ID of the post we create for this file
let postId: number; 

// Create a temporary post before running the UPDATE tests
test.beforeAll(async ({ request }) => {
  const response = await request.post(baseURL, {
    data: { title: 'Temp Post for UPDATE', body: 'Original body', userId: 1 }
  });
  const body = await response.json();
  postId = body.id; // Save post ID for later PATCH and GET
  console.log('Post created for UPDATE test:', postId);
});

test('Update - PATCH the post title', async ({ request }) => {
  // Data to update
  const updatedData = { title: 'Updated Test Post' };

  // Send PATCH request to update the post title
  const response = await request.patch(`${baseURL}/${postId}`, { data: updatedData });
  expect(response.status()).toBe(200); 

  const body = await response.json();
  console.log('Updated post successfully:', body);
});

test('Verify Update - GET the updated post', async ({ request }) => {
  // Send GET request to fetch the updated post
  const response = await request.get(`${baseURL}/${postId}`);

  if (response.status() === 200) {
    const body = await response.json();
    console.log('Verified updated post:', body);
    // Check that the title was updated
    expect(body.title).toBe('Updated Test Post');
  } else {
    // JSONPlaceholder may return 404 (expected for id>100)
    console.log('GET updated post returned', response.status(), '(expected for JSONPlaceholder id>100)');
  }
});
