# OrangeHRM Recruitment Module — Hybrid BDD-DDT Automation Framework

A personal automation project built to explore and experiment with hybrid framework architecture. This framework combines Behavior-Driven Development (BDD) and Data-Driven Testing (DDT) strategies to automate key workflows within the OrangeHRM Recruitment module — designed to be readable, maintainable, and extensible.

---

## About the Project

This framework was built from scratch to deepen my understanding of how well-structured test automation should behave — not just as a collection of scripts, but as an architecture that scales.

The **BDD layer** uses Gherkin feature files to describe test scenarios in plain, human-readable language, making test intent clear to both technical and non-technical stakeholders. The **DDT layer** extends selected scenarios with data-driven execution, reading test inputs from Excel files to validate behavior across multiple data combinations — such as date format validations.

---

## What It Tests

The framework covers end-to-end recruitment workflows on the OrangeHRM web application:

**Candidate Management**
- Adding new candidates and initiating applications
- Progressing candidates through intermediate hiring stages
- Marking candidates as hired or rejected at various stages of the pipeline

**Vacancy Management**
- Adding new job vacancies
- Managing and updating existing vacancy records

---

## Tech Stack

| Tool | Purpose |
|---|---|
| Java | Core programming language |
| Selenium WebDriver | Browser automation |
| Cucumber | BDD framework — feature files and step definitions |
| TestNG | Test execution and reporting |
| Maven | Build and dependency management |
| Apache POI | Excel data reading for DDT scenarios |

---

## Project Structure

```
OrangeHRM_Recruitment_Module/
├── src/
│   └── test/
│       ├── java/
│       │   ├── features/          # Gherkin feature files
│       │   ├── hooks/             # Cucumber hooks (setup/teardown)
│       │   ├── pageObjects/       # Page Object Model classes
│       │   ├── stepDefinition/    # Step definition implementations
│       │   ├── testRunner/        # TestNG runner configurations
│       │   └── utilities/         # Reusable utilities (Excel reader, etc.)
│       └── resources/             # Config files and supporting resources
├── testData/                      # Excel files for data-driven scenarios
├── test-output/                   # TestNG reports
├── logs/                          # Execution logs
├── reports/                       # Cucumber reports
└── pom.xml                        # Maven configuration
```

---

## How to Run

### Prerequisites

- Java JDK 8 or above
- Maven installed and configured
- Chrome browser with a compatible ChromeDriver

### Option 1 — Run via TestNG Runner (IDE)

To run all tests, execute the following file from your IDE:

```
src/test/java/testRunner/TestNGTestRunner.java
```

### Option 2 — Re-run Failed Tests Only

To re-run only the scenarios that failed in the last execution:

```
src/test/java/testRunner/FailedTestNGTestRunner.java
```

### Option 3 — Run via Maven (IDE or Terminal)

From the project root directory:

```bash
mvn test
```

Or to trigger a clean build before running:

```bash
mvn clean test
```

---

## Reports & Logs

- **TestNG Reports** — generated under `test-output/` after each run
- **Cucumber Reports** — available under `reports/` for scenario-level pass/fail visibility
- **Logs** — execution logs stored under `logs/`

---

## What Makes It Hybrid

Most BDD frameworks run a fixed set of scenarios with static data. This framework extends that by integrating a data-driven layer for scenarios where the same behavior needs to be validated across multiple inputs.

An Excel reader utility (`utilities/`) reads test data directly from files in the `testData/` folder. This means adding new test data combinations requires no changes to the automation code — just update the Excel file.

This separation of test logic and test data is what makes the framework hybrid, and it reflects the kind of maintainable, scalable architecture that real-world test automation demands.

---

## Author

**Abhijith Iyer**
QA Automation Engineer | Test Framework Design & Maintenance
[LinkedIn](https://www.linkedin.com/in/abhijith-iyer-02983337/) · [GitHub](https://github.com/Abhijith-Iyer)
