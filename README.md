# 2025 Project Collection

### ⚠️ Status: Discontinued
This repository serves as a snapshot of my work during 2025. It is a collection of various projects (like `orangehrm-gui, swaglabs-automation,typescript-automation`) moved into a single location for archival purposes.

## The Vision
I have decided to **discontinue** updates to this repository. Instead of continuing to build on these older structures, I am choosing to start fresh. 

With the knowledge and experience gained throughout these projects, I am focusing on building a **better foundation** from the ground up. This repository exists as a reference of my progress, but future development will happen in new, more robustly structured projects.

---

## How to move a repository into this collection
If I (or anyone else) need to archive another repository into this collection while preserving its history, use the following steps:

1. **Ensure your workspace is clean:**
   ```bash
   git add .
   git commit -m "Save work before import"
   ```

2. **Add the project as a subdirectory:**
    ```bash
    git subtree add --prefix=<your-repo-name> <your-old-repo-url> main
    ```

3. **Push the changes:**
    ```bash
    git push origin main
    ```