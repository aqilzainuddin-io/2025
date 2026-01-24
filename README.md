# 1. Install playwright command
```bash
npm init playwright@latest
```
### Do you want to use TypeScript or JavaScript?
```text
choose: typescript
```

### Where to put your end-to-end tests?
```text
directory name: tests
```

### Add a GitHub Actions workflow?
```text
choose: no (simplicity for now)
```

### Install Playwright browsers (can be done manually via 'npx playwright install')?
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



