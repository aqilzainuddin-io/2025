# SwagLabs Playwright Automation
This project contains automated tests for the SwagLabs web application using Playwright with TypeScript.

## 1. Prerequisites
Before you start, make sure you have Node.js installed. You can download it here: https://nodejs.org/

Check installation by running following command line
```text
node -v
npm -v
```

Both commands should show a version number.

## 2. Clone this repository
Open your terminal (or command prompt) and run:
```text
git clone https://github.com/aqilzainuddin-io/typescript-automation.git
cd swaglabs-automation
```

## 3. Install dependencies 
Install all required packages:
```bash
npm install
```

## 4. Install Playwright browsers
Playwright requires browser binaries to run tests. Install them with:
```bash
npx playwright install
```

## 5. Update playwright config (if needed)
Insert bellow line of code in between "use:{<here>}"
```text
testIdAttribute: 'data-test'
```

## 6. How to run test
for headless:
```text
npx playwright test
```
for visual:
```text
npx playwright test --headed
```


