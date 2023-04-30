# RemoveLinkedinConnections


![Linkedin](https://www.hizliresim.com/pq77wnb)

In this project, I aimed to delete our links other than those in the position list we set on Linkedin. We can use it to avoid seeing the posts of people outside the positions we want on the homepage.
## Used technologies

![Intellij İdea](https://www.hizliresim.com/6onjunw) **Intellij İdea Community**: IntelliJ IDEA is an Integrated Development Environment (IDE) for JVM languages designed to maximize developer productivity. It does the routine and repetitive tasks for you by providing clever code completion, static code analysis, and refactorings, and lets you focus on the bright side of software development, making it not only productive but also an enjoyable experience.

![Java](https://www.hizliresim.com/8stwn6q) **Java**: The programming language in which the project is written

![TestNG](https://www.hizliresim.com/siuypkf) **TestNG**: Test Authoring Tool used for writing Test Cases and controlling outputs.

![Selenium](https://www.hizliresim.com/5dchpz3) **Selenium**: Test Automation Tool used to test Website 

**WebDriverManager**: WebDriverManager is an open-source Java library that carries out the management (i.e., download, setup, and maintenance) of the drivers required by Selenium WebDriver (e.g., chromedriver, geckodriver, msedgedriver, etc.) in a fully automated manner. In addition, as of version 5, WebDriverManager provides other relevant features, such as the capability to discover browsers installed in the local system, building WebDriver objects (such as ChromeDriver, FirefoxDriver, EdgeDriver, etc.), running browsers in Docker containers seamlessly, and monitoring capabilities.

![Page-Object-Model](https://www.hizliresim.com/268mmhe) **Page Object Model**: It is the architectural structure used in the project.

![Excel](https://www.hizliresim.com/c5m2zy9) **Microsoft Excel**: A software program created by Microsoft that uses spreadsheets to organize numbers and data with formulas and functions. Excel analysis is ubiquitous around the world and used by businesses of all sizes to perform financial analysis. 

Note: For Excel, you should use a version that runs the XLS and XLSX file extensions.

![Junit](https://www.hizliresim.com/1aap09s) **Junit**: JUnit is an open source test automation tool in Java language. The purpose of this tool is to provide a simple, repeatable and readable testing framework that is used to test the accuracy of your code. JUnit is very widely used in the Java world, as well as the existence of similar tools for many other languages.

![png-transparent-leaf-apache-mave](https://www.hizliresim.com/seqll8w) **Maven**: Automation and build tool that is usually used during the compilation of commands on the Java platform.

![log4j](https://www.hizliresim.com/fu64mo2) **LOG4J**: log4j is a reliable, fast and flexible logging framework (APIs) written in Java, which is distributed under the Apache Software License. 
## Demo

## https://www.youtube.com/watch?v=VTaQWcnO5X4

  ## Screenshots
![Screenshot](https://www.hizliresim.com/illo07j)

![Screenshot](https://www.hizliresim.com/2jo2ire)

![Screenshot](https://www.hizliresim.com/6ol05u0)

![Screenshot](https://www.hizliresim.com/52cj70t)

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
   After that you should searching for 'Encodings'. 
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
```
 ```bash

    Open the google sheets link. Then you should login. 

 ```
[Google Sheet](https://www.google.com/sheets/about/)

```bash
    
    Then follow the orders:

    Empty Button > File > Open > Upload > Browse

    Select your Connections .Csv file in the winrar file

    Wait just a few seconds. 
    
    Google Sheet fixed this file.
    Then you will delete the first 3 lines. 
    You also delete the "Email Address" and "Connected On" columns. 
    Do not change the column names. 

    You can view a Template Connections Excel file here:

```
[Template Connections](https://github.com/bilallgunaydin/RemoveLinkedinConnections/blob/master/src/test/java/ExcelTools/Template%20Connection.xlsx)

```bash
   We download our new table by following the order of File > Download > Microsoft Excel (.xlsx). Do not delete the downloaded file until your links on LinkedIn are deleted. Store it somewhere. Because sometimes, while the project is running, it may encounter problems that are not caused by us on the Chrome side and it freezes for some reason, and in the meantime, it can delete the entire table because it processes the data in Excel. I think it probably deletes all of them by default because it could not find the right data to set at that moment. So copy the downloaded file into ExcelTools in my project and make sure the file name is "Connections.xlsx".
```

```bash
  If you change the file name, change the "ExcelFilePath" variable in the class in the link below.
```
[Utils](https://github.com/bilallgunaydin/RemoveLinkedinConnections/blob/master/src/test/java/Util/Utils.java)


I wrote several methods to check our data in Excel. I'll write what those methods do. You can reach the methods from the link below:

[CheckForConnectionValues](https://github.com/bilallgunaydin/RemoveLinkedinConnections/blob/master/src/test/java/Util/CheckForConnectionValues.java)

In Main you will see methods that are commented out. I have prepared them for you to browse your links, delete them from them, check them out.

**getNormalList**: It is the method that will write our links to the console according to the letter order of the names. In addition, our links will be deleted from the Excel file after the deletion from LinkedIn is completed. In any case, in order to protect our original Connections file, this method will create an Excel file called Connections Copy in the ExcelTools folder after it runs. If there is no such file there, it will create it. If it does it won't.

**getPositionList**: Excel dosyamızda yer alan pozisyonlarımızı tekrarsız bir şekilde konsola yazmamızı sağlayacak metottur. 

**getConnectionListForRemove**: Sileceğimiz kişileri konsola yazmamızı sağlayacak metottur. Linkedin ‘den sileceğimiz kişileri silmeden önce gözden geçirmek için kullanabiliriz. 

**DeleteWithRowNumber**: Bu metodu silinecekler listesinden silmek istediğimiz kişiler için bireysel olarak kullanabilmeniz için yazdım. Sileceğiniz kişinin silinecekler listesinde yer alan RowNumber yani satır numarasını buraya yazıp kullanabilirsiniz. 

**DeleteWithRowNumberList**: Bu metot bir üstteki metotla aynı işlemi yapıyor ama birden fazla kişiyi silmenize olanak sağlıyor. Bu metodu çalıştırmadan önce RowNumberList listenize silmek istediğiniz kişilerin RowNumber numaralarını aralarında virgül bırakarak yazıyorsunuz. En son yazacağınız satır numarası için virgül yazmanıza gerek yok. 

**typePositionsForFilter**: It is the method I wrote for you to write the positions of the people we do not want to delete. We have 2 options to write the positions.

1) You can come into the Positions.properties file in [Position.properties](https://github.com/bilallgunaydin/RemoveLinkedinConnections/blob/master/Configs/Positions.properties) and write the positions by hand, leaving a comma between them, without getting caught in the big or small harmony.
 
2) You can run the typePositionsForFilter method and write the positions you want from the keyboard in order and ask it to create data for you in [Position.properties](https://github.com/bilallgunaydin/RemoveLinkedinConnections/blob/master/Configs/Positions.properties)

  After you run the method, it will ask you if you want to write additional new positions to the positions you wrote before with the question “Do you want to add positions to existing positions?” on the console. If you type 1 and press Enter, it will add new positions to the positions you typed before. If you type 2 and press Enter, it will create a new position list for you. “Add another position?” after each position you write. It will ask you if you want to add another position. You can create a new position by typing 1 again and typing Enter, or you can complete the process of adding a position by typing 2 and pressing Enter.

You can use these methods individually by removing them from the comment. Do not run methods at the same time. Since I could not predict the programming knowledge level of the people who will use the project, I had to act so frequently and in a controlled manner.

You just need to uncomment the RowNumberList list for the DeleteWithRowNumberList method.


## Case Stages

Now I will tell you what you should pay attention to when writing the position names for the project.

Since the existing search filters didn't work, I researched and wrote another method. You can access this method called "Find" by clicking this link: [Utils](https://github.com/bilallgunaydin/RemoveLinkedinConnections/blob/master/src/test/java/Util/Utils.java)


Here, I supported this code with UNICODE_Case so that letters like 'I' 'İ' 'ı' 'i' would not be a problem. Because there are not some Turkish letters in English. If you want to write HR or ik and find Human Resources, you are likely to have problems. I wanted the search to be done by removing the upper and lower case separation.

Your choice of position: Let it be a test. The various positions below will match this Test value.
"Test"
"test"
"tester"
"tester"
"Quality Assurance Test Engineer"
"Senior Tester"

So you don't need to write extra Quality vs while you've already written a test. But it won't match your link with a position that only has Quality Assurance in the position. So, you should choose the right position words for your possible positions.

Unfortunately, we also have some disadvantages. Since LinkedIn allows manual position entry, when you type words such as IT, IT also finds the positions to pass.

I will give you a last example.

You don't need to type the position name twice for 'Accounting' and 'Account'.

If you type "Account", this also works for "Accounting".

Here I make a second reminder. Our goal is to find the links that we will remove and delete the people we do not want to delete with the position keywords we wrote.

# How to Run

```bash
   You must change the "Value" values for "email" and "password" in Testng.xml.  
```
[TestNG](https://github.com/bilallgunaydin/RemoveLinkedinConnections/blob/master/Testng.xml) click the link for Testng.xml

```bash
   Run "Testng.xml" file. 
```

I will end with a very important note.

# Important note:

After the project is running, it will quickly log into LinkedIn and go to the search screen. There he will pull our to-delete list from Excel one by one and check one last time. Because Linkedin has determined position entry in 2 different ways.
These:

1) Position information in the experience section
2) Title section under our profile


We need to check this. Some of our links write directly to the Title section instead of writing their position in the experience section. If he checks this part and does not find a match, he will enter the profile and unfollow first, respectively, and delete the link.

When these two are successful, it will also delete that link from Excel.

Note: When doing this check for the second time, the project waits between 20 and 30 seconds. I couldn't find the reason for this. It's waiting here when you don't expect anything. If anyone can solve the problem, they can contact me and express their solution. I will write the solution and update the codes.

While the project is running, I give information with a few screenshots and finish the article.

The lines I wrote here are a convenience that I use to get rid of the Scroll. I did it like this so that it wouldn't go down and write data again every time. The actual deletion process starts from here.

![ForEscapeTheScroll](https://img.onl/a3tzgP)

If you see the screen below once in a while after typing the names, do not close the project. There is no problem. Here we can understand that the data from Excel is not correct for the moment. Some of your connections may change their positions or make other changes until you run the project. When it can't find the person who wrote it, it deletes that person from Excel in order not to write it again.

![SomeNoResultsForSearching](https://img.onl/JIjka)

Wrote a connection information and showed the result. If there is no match in the list of positions, it will enter the profile and delete it and come back. Then it will delete the name of that link from Excel. Then he will write the new name. If you check a link and don't click and enter the profile, you can tell it matches a key from your list of positions. Then it will delete that person from Excel and write the new name.

While the project is running, you can look at the Log screen and follow the processes and understand this.

![LogScreen](https://img.onl/Qljy3)

If you see a connection information with a green tick on the left, you will understand that it has been deleted.

Depending on the number of positions and control status you have written for the positions, each link to be deleted will be deleted on average between 40 and 50 seconds. I hope I have written a useful project for you. Thank you for patiently reading this far.









  
## Feedback

If you have any feedback on the project, please contact me at bilallgunaydin@gmail.com.

  
