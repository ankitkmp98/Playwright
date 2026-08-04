Playwright with JavaScript – Detailed Study Notes (Lecture 1–3)

Module 1: Setting Up Playwright Project
Objective
The goal of this lecture is to create a Playwright automation project from scratch using Node.js, npm, and Visual Studio Code.

Prerequisites
Before starting Playwright, you must have:
1. Node.js
Playwright is built on top of Node.js.
Node.js provides
* JavaScript runtime
* npm (Node Package Manager)
Verify installation
node -v
Example
v22.10.0
Check npm
npm -v
Example
10.8.2
If these commands fail, install Node.js first.

Create Project
Create a new folder
playwright-automation
Open it in VS Code.

Initialize Playwright
Run
npm init playwright
This single command performs multiple tasks automatically.
It
* Initializes Node Project
* Creates package.json
* Downloads Playwright
* Downloads browsers
* Creates configuration file
* Creates sample tests
Instead of manually installing everything, Playwright does all of it.

Questions Asked During Setup
Playwright asks several questions.
Example
Choose language?

> JavaScript
TypeScript
The instructor selected JavaScript.
Why?
Because JavaScript is easier to learn.
Once JavaScript concepts are clear, TypeScript becomes much easier.

Another question
Install Playwright Browsers?

Yes
Always choose Yes.
Otherwise Playwright won't have browsers to automate.

Generated Project Structure
Example
playwright-automation

│
├── node_modules/
│
├── tests/
│      example.spec.js
│
├── playwright.config.js
│
├── package.json
│
├── package-lock.json
│
└── .gitignore
Let's understand every file.

node_modules
Contains
* Playwright library
* All dependencies
Example
node_modules/
      playwright/
      playwright-core/
      ...
Never edit this folder.
Never upload it to Git.

package.json
Think of package.json as
Identity Card of your project.
Example
{
  "name": "playwright-automation",

  "version": "1.0.0",

  "scripts": {

     "test":"playwright test"

  },

  "dependencies": {

      "@playwright/test":"latest"

  }

}
It contains
* project name
* version
* dependencies
* scripts

package-lock.json
Stores exact dependency versions.
Example
Playwright 1.54.0

Node Version

Dependency Tree
This ensures everyone installs identical packages.

playwright.config.js
This is the most important configuration file.
Example
module.exports = {

    use:{

        browserName:'chromium',

        headless:true

    }

}
This controls
* browser
* timeout
* screenshots
* retries
* videos
* parallel execution
Almost every Playwright project customizes this file.

tests Folder
Contains automation scripts.
Example
tests

    login.spec.js

    signup.spec.js

    search.spec.js

Running Tests
Run
npx playwright test
Playwright automatically
* reads config
* launches browser
* runs every file ending in
.spec.js

Module 2: Playwright Test Structure

Naming Convention
Every test file must end with
.spec.js
Example
Correct
login.spec.js

cart.spec.js

checkout.spec.js
Wrong
login.js

abc.txt

cart.java
Playwright automatically detects only
*.spec.js

Import Test
Every Playwright test starts with
const { test } = require('@playwright/test');
Meaning
Import
test()
from Playwright.
Without importing
test()
cannot be used.

Basic Test Structure
const { test } = require('@playwright/test');

test('My First Test', async () => {

});
Breakdown
test()
Creates one test case.

First Parameter
'My First Test'
Test name.
Shown in report.

Second Parameter
async()=>{

}
Contains automation code.

Complete Example
test('Login Test', async () => {

    console.log("Running Login Test");

});

Anonymous Function
Normal function
function login(){

}
Anonymous
function(){

}
Arrow Function
()=>{

}
Playwright mostly uses
async ()=>{

}
because it is shorter and cleaner.

Async and Await
One of the most important concepts.

Why?
JavaScript is asynchronous.
Meaning
Tasks don't always execute one after another.
Example
console.log("A");

setTimeout(()=>{

console.log("B");

},3000);

console.log("C");
Output
A

C

B
Not
A

B

C

Automation needs
Open Browser

↓

Open Website

↓

Enter Username

↓

Enter Password

↓

Click Login
Every step must finish before the next starts.
Otherwise automation fails.

Example
Wrong
page.goto(url);

page.click(login);
Browser may not even open before clicking.

Correct
await page.goto(url);

await page.click(login);
Meaning
Wait.
Don't continue until previous step finishes.

Think of await as
Teacher says
Finish Question 1

↓

Then Question 2

↓

Then Question 3

Async
Whenever we use await
Parent function must become async.
Example
async()=>{

await page.goto();

}
Without async
Error
await is only valid inside async function

Module 3: Browser Fixture, Browser Context and Page Fixture

Browser Fixture
Playwright automatically provides a Browser object.
Example
test('Demo', async ({ browser }) => {

});
Notice
{ browser }
It is passed inside curly braces.
Why?
Because Playwright passes fixtures as objects.

Without braces
Wrong
async(browser)
Correct
async({browser})

Browser
Represents
Chrome
Firefox
Edge
WebKit
Example
Browser

↓

Chromium

Browser Context
Browser Context is one isolated browser session.
Think
Incognito Window.
Every context has
* own cookies
* own cache
* own local storage
Example
Chrome
Browser

      |

Context1

Context2

Context3
Each user is independent.

Create Context
const context = await browser.newContext();
Always use await.
Because browser creation takes time.

Real Example
Testing
User A
User B
At same time.
Browser

↓

Context A

↓

Page

Browser

↓

Context B

↓

Page

No data sharing.
Perfect for multi-user testing.

Page
Page means
Browser Tab.
Create
const page = await context.newPage();
Hierarchy
Browser

↓

Context

↓

Page

Example
Chrome
Chrome

↓

Incognito

↓

Amazon Website
Browser
↓
Context
↓
Page

Navigate Website
await page.goto("https://google.com");

Why Await?
Without await
page.goto();

page.click();
Click may happen before page loads.
With await
await page.goto();

await page.click();
Everything executes correctly.

Page Fixture
Playwright simplifies all of this.
Instead of
const context = await browser.newContext();

const page = await context.newPage();
You can simply use
test('Demo', async ({ page }) => {

});
Playwright automatically creates
Browser
↓
Context
↓
Page
No manual work.

Example
test('Google Test', async ({ page }) => {

    await page.goto("https://google.com");

});
Much cleaner.

Browser Fixture vs Page Fixture
Browser Fixture	Page Fixture
Gives Browser object	Gives ready-to-use Page
Need to create Context manually	Context already created
Need to create Page manually	Page already available
Used for advanced scenarios	Used in most automation scripts
Example using Browser Fixture
test('Browser Fixture', async ({ browser }) => {

const context = await browser.newContext();

const page = await context.newPage();

await page.goto("https://google.com");

});

Example using Page Fixture
test('Page Fixture', async ({ page }) => {

await page.goto("https://google.com");

});
The second approach is preferred for most tests because it is simpler and requires less boilerplate code.

Interview Questions
1. What is Playwright?
A Node.js-based end-to-end automation framework for web application testing that supports Chromium, Firefox, and WebKit.

2. Why is Node.js required for Playwright?
Because Playwright is built on Node.js and uses npm to install packages and execute tests.

3. What does npm init playwright do?
It initializes a Node.js project, installs Playwright and browser binaries, creates the project structure, generates configuration files, and adds sample tests.

4. What is the purpose of package.json?
It stores project metadata, dependencies, and scripts used to manage and run the project.

5. Why should test files end with .spec.js?
Playwright automatically discovers and executes test files following the .spec.js naming convention.

6. What is the difference between async and await?
* async marks a function as asynchronous.
* await pauses execution until an asynchronous operation completes.

7. What is a Browser Context?
A Browser Context is an isolated browser session with its own cookies, cache, and local storage, similar to an incognito window.

8. What is the difference between Browser, Browser Context, and Page?
* Browser: The browser process (Chromium, Firefox, WebKit).
* Browser Context: An isolated session within the browser.
* Page: A single browser tab inside a context.

9. When should you use the Browser fixture instead of the Page fixture?
Use the Browser fixture when you need to create multiple contexts or pages manually (e.g., multi-user scenarios). Use the Page fixture for standard automation tests.

10. Why is the Page fixture commonly used?
Because Playwright automatically creates the browser, context, and page, reducing setup code and making tests cleaner and easier to maintain.

Key Takeaways
* Install Node.js before setting up Playwright.
* Use npm init playwright to bootstrap a Playwright project.
* Understand the role of package.json, playwright.config.js, and the tests folder.
* Name test files using the .spec.js convention.
* Always use async and await for browser interactions.
* Know the hierarchy: Browser → Browser Context → Page.
* Prefer the Page fixture for most tests and the Browser fixture for advanced scenarios requiring multiple isolated sessions.
These concepts form the foundation for all Playwright automation and will make subsequent topics such as locators, assertions, fixtures, and Page Object Model much easier to understand.
