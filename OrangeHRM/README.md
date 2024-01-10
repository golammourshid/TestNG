This is for basic JUnit learning.

Jdk version: 17 Build system: Gradle [gradle clean test]

Generate report with allure: allure generate allure-results --clean -output
Show result with allure: allure serve allure-results
To provide username and pass in runtime: gradle clean test -Pusername=admin -Ppassword=admin123

Some tips to smooth the automation process:

1. Download and add Chrome extension named: Selectorhub. This will automatically generate the element locators.