# Yocket College Finder Assignment

This is test assignment for the college finder module, implemented with Java Selenium.

## Installation

Use the package manager maven to install. Please have Java and Maven installed in your system.

```bash
mvn clean install
```

## Usage

```bash
mvn clean test
```

## 
The tests written cover the basic home page verification, college finder happy path and college finder required field negative path.

Reports are generated via the surefire plugin and the email-able report .pdf can be found in the target folder.

## Note
The Sorting of the College Results page was not possible as it was restricted via login and I did not have an API exposed to fetch the OTP.