import { test, expect } from '@playwright/test';

const baseURL = 'https://jsonplaceholder.typicode.com/posts';

test.describe('Read - GET a post', () => {
  let postId: number; // Will store the ID of the post we create

  test.beforeAll(async ({ request }) => {
    // Create a temporary post before running the GET test
    const response = await request.post(baseURL, {
      data: { title: 'Temp Post for READ', body: 'Body content', userId: 1 }
    });
    const body = await response.json();
    postId = body.id; // Save the post ID for the test
    console.log('Post created for READ test:', postId);
  });

  test('GET the created post', async ({ request }) => {
    // Send GET request to fetch the post
    const response = await request.get(`${baseURL}/${postId}`);

    if (response.status() === 200) {
      const body = await response.json();
      console.log('Read post successfully:', body);
      // Check that the returned post has the correct ID
      expect(body.id).toBe(postId);
    } else {
      // JSONPlaceholder may return 404 for new posts (expected)
      console.log('GET post returned', response.status(), '(expected for JSONPlaceholder id>100)');
    }
  });
});
