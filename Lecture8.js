/*
  =====================================================
  Lecture 8: Introduction to Playwright
  =====================================================

  What is Playwright?
  -------------------
  Playwright is an open-source browser automation framework developed by Microsoft.
  It was released in 2020 and is widely used for:

  - End-to-end (E2E) testing
  - UI automation
  - Cross-browser testing
  - API testing
  - Web scraping and browser automation scripts

  Playwright is built on Node.js, which means it runs in JavaScript/TypeScript
  environments outside the browser itself.

  Why Playwright is Popular?
  --------------------------
  Playwright offers a modern and reliable way to automate modern web applications.
  It is especially useful because it can interact with dynamic web elements,
  wait for pages to load, and handle complex browser behaviors efficiently.

  Key Features of Playwright
  -------------------------
  1. Cross-Browser Support
     Playwright supports:
     - Chromium (Google Chrome, Microsoft Edge)
     - Firefox
     - WebKit (Safari)

  2. Cross-Platform Support
     It runs smoothly on:
     - Windows
     - macOS
     - Linux

  3. Multi-Language Support
     You can write tests in:
     - JavaScript
     - TypeScript
     - Java
     - Python
     - C#

  4. Mobile Web Testing
     Playwright supports mobile browser emulation for:
     - Chrome on Android
     - Safari on iOS

  5. API Testing
     Playwright includes an API testing module that lets you test backend endpoints,
     validate responses, and verify request/response flows without needing a separate tool.

  6. Auto-Waiting
     Playwright automatically waits for elements to be visible, enabled, and ready before
     interacting with them. This reduces flaky tests and manual waits.

  7. Handling Complex Elements
     It works well with modern UI patterns such as:
     - Shadow DOM
     - Dynamic content
     - Frames and iframes
     - Single-page applications (SPAs)

  8. Parallel Execution
     Playwright can run tests in parallel across multiple browsers or workers, allowing faster test execution.

  9. Built-in Reporting
     Playwright supports multiple reporting formats, such as:
     - HTML reports
     - JSON reports
     - JUnit reports
     - Third-party reports like Allure

  Playwright Tools
  ---------------
  Playwright provides useful tools for testing and debugging:

  - Inspector:
    Helps developers inspect locators, check selectors, and debug interactions visually.

  - Code Generation (Codegen):
    Records user actions and generates browser automation code automatically.

  - Trace Viewer:
    Captures a trace of actions, screenshots, logs, and videos to help debug failures.

  Useful References
  -----------------
  https://www.pavanonlinetrainings.com
  https://www.youtube.com/@sdetpavan

  JavaScript vs TypeScript
  -----------------------
  JavaScript
  ----------
  JavaScript is a dynamically typed language.

  Characteristics:
  - No strict type checking
  - Variables can change type during runtime
  - Flexible and fast for small scripts

  Example:
  let age = 30;         // Number
  let name = "John";    // String
  age = "thirty";       // No error, variable type changes

  TypeScript
  ----------
  TypeScript is a superset of JavaScript.
  It adds static typing and helps developers catch bugs earlier during development.

  Characteristics:
  - Stronger type checking
  - Variables must follow the declared type
  - Better for large applications and team projects

  Example:
  let age: number = 30;     // Must remain a number
  let name: string = "John";
  age = "thirty";           // Error: Type 'string' is not assignable to type 'number'

  Why Use TypeScript?
  -------------------
  - JavaScript follows the ECMAScript standard.
  - TypeScript adds extra features like type safety on top of JavaScript.
  - It compiles into normal JavaScript so browsers can run it.
  - It helps detect errors early before execution.

  Summary
  -------
  Playwright is a powerful automation and testing framework that supports modern web
  testing needs, cross-browser execution, API testing, and reliable browser automation.
  JavaScript is flexible, while TypeScript improves maintainability and reduces runtime bugs.

  =====================================================
*/
