# 1. Install playwright command
```bash
npm init playwright@latest
```
## i. Do you want to use TypeScript or JavaScript?
```text
choose: typescript
```

## ii. Where to put your end-to-end tests?
```text
directory name: tests
```

## iii. Add a GitHub Actions workflow?
```text
choose: no (simplicity for now)
```

## iv. Install Playwright browsers (can be done manually via 'npx playwright install')?
```text
choose: yes
```

# 2. Structure after installation
```text
swaglabs-automation/
├── node_modules/          ← installed dependencies
├── playwright.config.ts   ← global playwright config
├── package.json           ← scripts & dependencies
├── package-lock.json      ← dependency lock file
│
├── tests/
│   └── example.spec.ts    ← sample test
│
├── .gitignore
└── README.md
```



