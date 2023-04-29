# RemoveLinkedinConnections


![Linkedin](https://img.onl/izv5yG)

In this project, I aimed to delete our links other than those in the position list we set on Linkedin. We can use it to avoid seeing the posts of people outside the positions we want on the homepage.
## Used technologies

![Intellij İdea](https://img.onl/TtbK6C)   **Intellij İdea Community**: IntelliJ IDEA is an Integrated Development Environment (IDE) for JVM languages designed to maximize developer productivity. It does the routine and repetitive tasks for you by providing clever code completion, static code analysis, and refactorings, and lets you focus on the bright side of software development, making it not only productive but also an enjoyable experience.

![Java](https://user-images.githubusercontent.com/21973124/221045301-8ba20fed-9b89-4a2d-aa1a-144f18081059.png) **Java**: The programming language in which the project is written

![TestNG](https://user-images.githubusercontent.com/21973124/221045634-305f0c6a-0fb4-4516-a7b6-7e2b5ea77f97.png) **TestNG**: Test Authoring Tool used for writing Test Cases and controlling outputs.

![Selenium](https://user-images.githubusercontent.com/21973124/198895496-06aa962b-f22e-478e-bc86-ce482c513192.png) 
**Selenium**: Test Automation Tool used to test Website 

**WebDriverManager**: WebDriverManager is an open-source Java library that carries out the management (i.e., download, setup, and maintenance) of the drivers required by Selenium WebDriver (e.g., chromedriver, geckodriver, msedgedriver, etc.) in a fully automated manner. In addition, as of version 5, WebDriverManager provides other relevant features, such as the capability to discover browsers installed in the local system, building WebDriver objects (such as ChromeDriver, FirefoxDriver, EdgeDriver, etc.), running browsers in Docker containers seamlessly, and monitoring capabilities.

![Page-Object-Model](https://user-images.githubusercontent.com/21973124/198896027-6ad45ea7-7ac5-4a5d-ae30-34a7ae5efcda.png) **Page Obj ect Model**: It is the architectural structure used in the project.

![Excel](https://img.onl/S1tyfQ) **Microsoft Excel**: A software program created by Microsoft that uses spreadsheets to organize numbers and data with formulas and functions. Excel analysis is ubiquitous around the world and used by businesses of all sizes to perform financial analysis. 

Note: For Excel, you should use a version that runs the XLS and XLSX file extensions.

![Junit](https://user-images.githubusercontent.com/21973124/221034802-128fa8ba-16e5-43be-8012-e95a0d808eb3.png) **Junit**: JUnit is an open source test automation tool in Java language. The purpose of this tool is to provide a simple, repeatable and readable testing framework that is used to test the accuracy of your code. JUnit is very widely used in the Java world, as well as the existence of similar tools for many other languages.

![png-transparent-leaf-apache-mave](https://user-images.githubusercontent.com/21973124/198895707-3ea65ae1-48fc-4ca3-9e82-87d09a301959.png) **Maven**: Automation and build tool that is usually used during the compilation of commands on the Java platform.

![log4j](https://user-images.githubusercontent.com/21973124/221046060-6dee577f-68d4-4075-ac1e-fd86107f8e05.png) **LOG4J**: log4j is a reliable, fast and flexible logging framework (APIs) written in Java, which is distributed under the Apache Software License. 
## Demo

## https://www.youtube.com/watch?v=VTaQWcnO5X4

  ## Screenshots
![Screenshot](https://img.onl/WL5fu1)

![Screenshot](https://img.onl/md2rJ)

![Screenshot](https://img.onl/brAUus)

![Screenshot](https://img.onl/D6Zjw)
## Run Locally

Clone the project

```bash
  https://github.com/bilallgunaydin/GithubCheckFollowers.git

```
Before Running

```bash
   I used IntelliJ. You have to make a few settings there.
   File> Settings> "Console" write for searching label. 
   Then Ovveride console cycle buffer size change for 4096 KB. 
   Because sometimes excel values be to much for writing the console.
   Sometimes the console cach size doesn't enough for writing. 
   You should change it. 
   
   Check below the screenshot
   
```

![IntelliJ Settings](https://img.onl/7WC88f)

```bash

   After that you should searching for "Encodings". 
   Sometimes our positions categories can't supported for English language. 
   
   You should change it. Check below the screenshot


```
![IntelliJ Settings](https://img.onl/CrURdV)

```bash
    We need a list for our connections. You should open the link:
```
  [Create Linkedin Connections .csv](https://www.linkedin.com/mypreferences/d/download-my-data) 

```bash
    Click Request archive button. 10 minutes wait and Check the e-mail address you registered on LinkedIn. After download the winrar file. 
    
    Some characters may be corrupted in the .csv file inside. We will fix them and add them to Intellij.

    Open the google sheets link. You must login. 
    
    Then follow the orders:

    Empty Button > File > Open > Upload > Browse

    Select your Connections .Csv file in the winrar file

    Wait just a few seconds. 




```

[Google Sheet](https://www.google.com/sheets/about/)

  ```bash
   You must change the "Value" values for "email" and "password" in Testng.xml.  
```

How to Run

```bash
   Run "Testng.xml" file. 
```



  
## Case Aşamaları




  Scenario: Adding a product to the cart on Hepsiburada.com

    1)Adding a product to the cart by logging in
    
    -The user visits Hepsiburada.com site.
    -User login is done.
    -After the redirect, it is verified that the user login is done on the homepage
    -The user will search for the product he wants to buy here.
    -The user selects a product from the list of products displayed as a result of the Search (or a single result may also be returned).
    -The product is selected from 2 different vendors for the selected product and added to the cart.
    -It should be verified on the 'My Cart' page that the selected product has been added correctly.

    1)Adding the specified product to the cart without user login
    
    -The user visits Hepsiburada.com site.
    -The user selects a product from the list of products displayed as a result of the Search (or a single result may also be returned).
    -For the selected product, products from 2 different vendors are selected and added to the cart.
    -It should be verified on the 'My Cart' page that the selected product has been added correctly.

    
## Feedback

If you have any feedback on the project, please contact me at bilallgunaydin@gmail.com.

  
