# Welcome to API automation using Json Placeholder

This is a simple maven Java project using to automate test the fake API on 
[{Json} Placeholder](
https://jsonplaceholder.typicode.com/)
It's main purpose is to perform the validations for the comments for the post made by a specific user. 

## How to install 
***Before you start make sure that you have already installed the following on your machine:***
 1. [Java](https://www.java.com/en/download/manual.jsp) JDK.
 2. [Apache maven](https://maven.apache.org/).
 3. IDE as [**_intellij_**](https://www.jetbrains.com/idea/) or [**_Eclipse_**](https://www.eclipse.org/).
 
***Steps to run the project:***

 1. Click on "Clone" button and copy the link.
 2. Open Intellij IDE and create new project from source control.
 3. Paste the URL which copied and set the path which you want to add your cloned project.
 4. Wait until all dependencies are finishing the setup.
 5. In the project panel click on "Mobiquity code [Framework]" folder, Then open the path "src/test/java/runner".
 6. Run "TestRunner" class.

***Steps to generate HTML Report:***

 1. Open terminal into your project or in the same path
 2. Write the command "mvn clean verify" and wait until it finish.
 3. Open target folder then open the path "cucumber-html-reports".
 4. Right click on any html file then choose open in >Browser>Choose any browser.

now cucumber report will be opened on your browser successfully.

## Technologies used in the project

 - Rest Assured 
 - Maven
 - Junit
 - Cucumber 
 - Cucumber html reports
