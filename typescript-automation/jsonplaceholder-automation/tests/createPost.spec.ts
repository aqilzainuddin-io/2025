import { test, expect } from '@playwright/test'; 

const baseURL = 'https://jsonplaceholder.typicode.com/posts';

test('Create - POST a new post', async ({ request }) => {
  // Data for the new post we want to create
  const newPost = {
    title: 'My First Test Post',
    body: 'This is a test post created for automation.',
    userId: 1
  };

  // Send POST request to create a new post
  const response = await request.post(baseURL, { data: newPost });

  // Check that the response status is 201 (Created)
  expect(response.status()).toBe(201);

  // Parse the JSON response body
  const body = await response.json();
  console.log('Created post with id:', body.id);

  // Validate that the returned post has the correct title and body
  expect(body.title).toBe(newPost.title);
  expect(body.body).toBe(newPost.body);

  // Try to GET the post immediately after creating it
  const getResponse = await request.get(`${baseURL}/${body.id}`);
  if (getResponse.status() === 200) {
    const getBody = await getResponse.json();
    console.log('GET immediately after POST succeeded:', getBody);
  } else {
    console.log('GET immediately after POST failed (expected for JSONPlaceholder id>100)');
  }
});
