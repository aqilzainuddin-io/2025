# SWAGLABS Automation Framework

This project contains an automation framework for **SWAGLABS** web application using **Selenium WebDriver** and **TestNG**. The framework is designed with the **Page Object Model (POM)** pattern for maintainability and scalability.

---

## Project Structure
```text
swaglabs-automation/
├── pom.xml
├── README.md
├── .gitignore
│
└── src/
     ├── main/
     │   └── java/
     │       ├── pages/
     │       │   ├── base/
     │       │   │   └── BasePage.java
     │       │   │
     │       │   ├── login/
     │       │   │   └── LoginPage.java
     │       │   │
     │       │   ├── inventory/
     │       │   │   └── InventoryPage.java
     │       │   │
     │       │   ├── cart/
     │       │   │   └── CartPage.java
     │       │   │
     │       │   ├── checkout/
     │       │   │   ├── CheckoutStepOnePage.java
     │       │   │   ├── CheckoutStepTwoPage.java
     │       │   │   └── CheckoutCompletePage.java
     │       │   │
     │       │   └── menu/
     │       │       └── SideMenuPage.java
     │       │
     │       └── setup/
     │           ├── DriverFactory.java
     │           └── EnvReader.java
     │
     └── test/
         └── java/
             ├── setup/
             │   └── BaseTest.java
             │
             └── tests/
                 ├── login/
                 │   └── LoginTest.java
                 │
                 ├── inventory/
                 │   └── InventoryTest.java
                 │
                 ├── cart/
                 │   └── CartTest.java
                 │
                 ├── checkout/
                 │   └── CheckoutTest.java
                 │
                 └── e2e/
                     └── E2ETest.java

```

---

## Technologies
- Java
- Selenium WebDriver
- TestNG
- Maven
- ChromeDriver
- dotenv-java (for environment variables)

---

## Setup

1. **Clone the repository**
```bash
git clone <repo_url>
```

2. **Install dependencies**
```bash
mvn clean install
```

3. **Set environment variables in .env file**
```text
BASE_URL=https://www.saucedemo.com/
VALID_USERNAME=standard_user
VALID_PASSWORD=secret_sauce
LOCKOUT_USERNAME=locked_out_user
INVALID_PASSWORD=secret_sauce2
BROWSER=chrome
FIRST_NAME=John
LAST_NAME=Doe
POSTAL_CODE=12345
```

4. **ChromeDriver please use the same as your Chrome version**

---

## Running Tests

1. **Run all tests via Maven**
```bash
mvn clean test
```

2. **Run specific TestNG test suite**
```bash
mvn test -DsuiteXmlFile=testng.xml
```

---