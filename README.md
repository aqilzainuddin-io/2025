# TypeScript Automation Projects
This repository contains multiple automation projects built with *Playwright and TypeScript*:

## 1. JSONPlaceholder API Automation
   - Automated API tests for the fake API [JSONPlaceholder](https://jsonplaceholder.typicode.com/), covering *CRUD operations* on the `/posts` endpoint.  
   - See instructions and how to run tests in the folder: [`jsonplaceholder-automation/`](./jsonplaceholder-automation)

## 2. SwagLabs Web Automation  
   - Automated web UI tests for the [SwagLabs](https://www.saucedemo.com/) application, testing *login, shopping cart, and checkout flows*.  
   - See instructions and how to run tests in the folder: [`swaglabs-automation/`](./swaglabs-automation)

---

# Repository Structure
```text
TYPESCRIPT-AUTOMATION/
├─ jsonplaceholder-automation/ # API automation project
│ ├─ tests/ # CRUD test files
│ ├─ playwright.config.ts
│ ├─ package.json
│ └─ README.md # Project-specific instructions
├─ swaglabs-automation/ # Web automation project
│ ├─ tests/ # UI test files
│ ├─ pages/ # Page objects
│ ├─ playwright.config.ts
│ ├─ package.json
│ └─ README.md # Project-specific instructions
└─ README.md # Root-level overview (this file)
```

---

# How to get started

## 1. Clone the repository 
```bash
git clone https://github.com/aqilzainuddin-io/typescript-automation.git
cd TYPESCRIPT-AUTOMATION
```

## 2. Go into the desired project
For API automation testing
```text
cd jsonplaceholder-automation
```

For web app automation testing
```text
cd swaglabs-automation
```

# Notes
- Each project is self-contained — you can run one without affecting the other.
- All projects use Playwright with TypeScript.
- Test reports and results are generated in each project folder (playwright-report/ and test-results/).