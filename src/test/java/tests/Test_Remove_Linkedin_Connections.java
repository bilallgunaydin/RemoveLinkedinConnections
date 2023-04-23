package tests;

import PageObjectModel.LoginPage;
import PageObjectModel.MainPage;
import PageObjectModel.SearchPage;
import Util.Utils;
import org.junit.Assert;

import org.testng.annotations.*;
import Util.ConfigReader;
import Util.Log4j;


import java.io.IOException;

import java.util.*;


public class Test_Remove_Linkedin_Connections extends BaseTest {
    static Properties properties;
    LoginPage loginPage;
    MainPage mainPage;
    SearchPage searchPage;

    @BeforeClass
    void createSomeInstances() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        properties = ConfigReader.getProperties();
    }

    @Parameters({"email", "password"})
    @Test(priority = 1)
    public void login(String email, String password) {
        loginPage.login(email, password);
        Log4j.info("Login done.");
    }

    @Test(priority = 2)
    public void setClickMyNetworkButton() {
        mainPage.setClickMyNetworkButton();
        Log4j.info("Clicked my network button.");
    }

    @Test(priority = 3)
    public void setClickConnectionsButton() {
        mainPage.setClickConnectionsButton();
        Log4j.info("Clicked connections button.");
    }

    @Test(priority = 4)
    public void setClickSearchWithFilterButton() {
        mainPage.setClickSearchWithFilterButton();
        Log4j.info("Clicked 'Search With Filter' button.");
    }

    @Test(priority = 5)
    public void setClickAllFiltersButton() {
        searchPage.setClickAllFiltersButton();
        Log4j.info("Clicked 'All Filters' button.");
    }

    @Test(priority = 6)
    public void scrollToKeywords() throws InterruptedException {
        searchPage.scrollToKeywords();
        Log4j.info("Keywords field has been scrolled.");
    }

    @Test(priority = 7)
    public void setConnectionsForEscapeToScroll() throws InterruptedException {
        searchPage.setConnectionsForEscapeToScroll();
        Log4j.info("Entered the text boxes for Escape To Scroll");
    }

    @Test(priority = 8)
    public void clickResultButton() throws InterruptedException {
        searchPage.clickResultButton();
        Log4j.info("Clicked Result Button");
    }

    @DataProvider(name = "setConnectionListForRemove")

    public Object[][] setConnectionListForRemove() throws Exception {
        return Utils.setConnectionListForRemove();

    }

    @Test(priority = 9, dataProvider = "setConnectionListForRemove")
    public void setConnectionListForRemove(String firstName, String lastName, String company, String position, int rowNumber)
            throws InterruptedException, IOException {

        searchPage.clickShowKeywordsButton();
        Log4j.info("Clicked Showing Keywords List Button");
        searchPage.setConnectionsKnowledge(firstName, lastName, position, company);
        Log4j.info("Connection related data has been entered.");
        searchPage.clickKeywordsResult();
        Log4j.info("Clicked the Show results button.");
        boolean checkConnectionInformetion = searchPage.CheckConnectionInformation();
        Log4j.info("Checked About Connection Informations");
        if (!checkConnectionInformetion) {
            boolean checkPosition = searchPage.checkCurrentTitleWithPosition();
            if (!checkPosition) {
                searchPage.clickOpenProfile();
                Log4j.info(firstName + " " + lastName + " profile is opened");
                searchPage.clickMoreAction();
                Log4j.info("'More Menu' opened");
                searchPage.clickStopFollow();
                Log4j.info("Clicked Stop follow button for Screen");
                Log4j.info("Clicked stop follow button");
                boolean checkFollow = searchPage.checkStopFollowingText();
                searchPage.clickCloseTheFollowMessageElement();
                Log4j.info("Closed the text message");
                searchPage.clickMoreAction();
                Log4j.info("'More Menu' opened again");
                searchPage.clickRemoveTheConnectionText();
                Log4j.info("Clicked 'Remove Connection Button'");
                boolean checkDelete = searchPage.checkRemoveTheConnectionText();
                searchPage.clickCloseTheRemoveMessageElement();
                Log4j.info("Closed the text message for deleted connection");
                boolean checkDeleteAndFollow = searchPage.checkDeleteAndFollow(checkFollow, checkDelete);
                if (checkDeleteAndFollow) {
                    Log4j.info(firstName + " " + lastName + " " + position + " " + company + "connection has been removed from your connection. ");
                    Utils.DeletewithRowNumber(rowNumber);
                    Log4j.info(firstName + " " + lastName + " " + position + " " + company + "connection has been removed from your connection excel file ");
                }
                searchPage.BackFromCurrentPage();
                Assert.assertTrue(checkDeleteAndFollow);


            } else {
                Log4j.info("This test has been terminated because the entered connection information is included in the positions you are looking for. The connection was deleted from excel because it was included in the positions you are looking for");
                Utils.DeletewithRowNumber(rowNumber);
                Assert.assertTrue(checkPosition);

            }
        } else {
            Log4j.info("This test was terminated because the entered connection information could not be found. The connection was deleted from excel because it could not be found.");
            Utils.DeletewithRowNumber(rowNumber);
            Assert.assertTrue(checkConnectionInformetion);
        }
    }
}
