package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import Util.ConfigReader;
import java.util.Arrays;
import java.util.Properties;

public class SearchPage extends BasePage {
    static Properties properties;
    Actions action;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        properties = ConfigReader.getProperties();
        action = new Actions(driver);
    }

    By clickAllFiltersButton = By.id("search-reusables__filters-bar");

    public void setClickAllFiltersButton() {
        click(clickAllFiltersButton);
    }


    By scrollToKeywordsElement = By.xpath("//*[text()='Keywords' or  text()='Anahtar sözcükler']");

    public void scrollToKeywords() throws InterruptedException {
        Thread.sleep(1000);
        WebElement find = presenceElement(scrollToKeywordsElement);
        action.moveToElement(find).perform();
        scrollToElement(find);
    }

    By firstNameElement = By.xpath("(//input[@class='mt1'])[1]");
    By lastNameElement = By.xpath("(//input[@class='mt1'])[2]");
    By positionNameElement = By.xpath("(//input[@class='mt1'])[3]");
    By companyNameElement = By.xpath("(//input[@class='mt1'])[4]");

    public void setConnectionsForEscapeToScroll() throws InterruptedException {
        Thread.sleep(1000);
        sendKey(firstNameElement, "-");
        sendKey(lastNameElement, "-");
        sendKey(positionNameElement, "-");
        sendKey(companyNameElement, "-");
    }

    By resultButtonElement = By.xpath("(//span[@class='artdeco-button__text'])[12]");

    public void clickResultButton() throws InterruptedException {
        click(resultButtonElement);
//        Thread.sleep(1000);
    }

    By clickShowKeywordsButtonElement = By.xpath("//*[text()='Keywords' or text()='Anahtar sözcükler']");

    public void clickShowKeywordsButton() throws InterruptedException {
        click(clickShowKeywordsButtonElement);
        Thread.sleep(1000);
    }

    By clickKeywordsResultElement = By.xpath("(//span[@class='artdeco-button__text'])[7]");

    public void clickKeywordsResult() {
        click(clickKeywordsResultElement);
    }

    By checkConnectionInformetionElement = By.xpath("//*[text()='Hiçbir sonuç bulunamadı' or  text()='No results found']");


    public boolean CheckConnectionInformation() {
        String title = getText(checkConnectionInformetionElement) != null ?
                (getText(checkConnectionInformetionElement).contains("Hiçbir sonuç bulunamadı") ?
                        "Hiçbir sonuç bulunamadı" : "No results found") : null;

        return title != null && assertWithBoolean(checkConnectionInformetionElement, title);
    }

    public void setConnectionsKnowledge(String firstName, String lastName, String positionName, String companyName) {
        sendKey(firstNameElement, firstName);
        sendKey(lastNameElement, lastName);
        sendKey(positionNameElement, positionName);
        sendKey(companyNameElement, companyName);
    }



    By getCurrentTitleElement = By.xpath("(//div[contains(@class,'entity-result__primary-subtitle t-14 t-black t-normal')])[1]");


    public boolean checkCurrentTitleWithPosition() {

        String currentTitle = (getText(getCurrentTitleElement) == null) ? "" : getText(getCurrentTitleElement);
        return Arrays.stream(properties.getProperty("Positions")
                .split(",")).anyMatch(position -> find(currentTitle, position));
    }

    By clickOpenProfileElement = By.xpath("(//a[@class='app-aware-link '])[2]");

    public void clickOpenProfile() {
        click(clickOpenProfileElement);
    }

    By clickMoreActionElement = By.xpath("(//span[text()='More' or  text()='Daha Fazla'])[2]");

    public void clickMoreAction() throws InterruptedException {
        WebElement element = findElement(clickMoreActionElement);
        scrollToElement(element);
        Thread.sleep(1000);
        click(clickMoreActionElement);
    }

    By clickStopFollowElementForScreen = By.xpath("/html/body/div[5]/div[3]/div/div/div[2]/div/div/main/section[1]/div[2]/div[3]/div/div[2]/div/div/ul/li[6]/div/span");
    //    By clickStopFollowElementForScreen = By.xpath("(//span[@class='display-flex t-normal flex-1'])[6]");
    By clickStopFollowElement = By.xpath("//span[@class='artdeco-button__text' and text()='Unfollow' or  text()='Takip Etmeyi Durdur']");

    public void clickStopFollow() throws InterruptedException {
        Thread.sleep(1000);
        WebElement element = findElement(clickStopFollowElementForScreen);
        scrollToElement(element);
        Thread.sleep(1000);
        click(clickStopFollowElementForScreen);
        Thread.sleep(1000);
        click(clickStopFollowElement);
    }

    By stopFollowingTextElement = By.xpath("//p[@class='artdeco-toast-item__message']/span");

    public boolean checkStopFollowingText() throws InterruptedException {
        Thread.sleep(1000);
        String message = find(getText(stopFollowingTextElement),
                ("You have unfollowed")) ? "You have unfollowed" : "kullanıcıyı takip etmeyi durdurdunuz";
        return assertWithBoolean(stopFollowingTextElement, message);
    }

    By closeTheFollowMessageElement = By.xpath("//*[local-name()='svg' and @fill='currentColor']/*[local-name()='path' and @d='M14 3.41L9.41 8 14 12.59 12.59 14 8 9.41 3.41 14 2 12.59 6.59 8 2 3.41 3.41 2 8 6.59 12.59 2z']");

    public void clickCloseTheFollowMessageElement() throws InterruptedException {
        Thread.sleep(1000);
        clickSvgItem(closeTheFollowMessageElement);
    }


    By clickDeleteConnectionElement = By.xpath("(//span[contains(@class,'display-flex t-normal flex-1') and text()='Bağlantıyı Sil' or text()='Remove Connection'])[2]");

    public void clickRemoveTheConnectionText() throws InterruptedException {
        WebElement element = findElement(clickDeleteConnectionElement);
        scrollToElement(element);
        Thread.sleep(1000);
        click(clickDeleteConnectionElement);
    }

    By removeConnectionTextElement = By.xpath("/html/body/div[1]/section/div/div/div/p/span");

    public boolean checkRemoveTheConnectionText() throws InterruptedException {
        Thread.sleep(1000);
        String message = find(getText(removeConnectionTextElement), ("removed.")) ? "removed." : "kaldırıldı.";
        return assertWithBoolean(removeConnectionTextElement, message);
    }

    By closeTheRemoveMessageElement = By.xpath("//*[local-name()='svg' and @fill='currentColor']/*[local-name()='path' and @d='M14 3.41L9.41 8 14 12.59 12.59 14 8 9.41 3.41 14 2 12.59 6.59 8 2 3.41 3.41 2 8 6.59 12.59 2z']");

    public void clickCloseTheRemoveMessageElement() throws InterruptedException {
        Thread.sleep(1000);
        clickSvgItem(closeTheRemoveMessageElement);
    }

    public void BackFromCurrentPage() throws InterruptedException {
        backPage();
        Thread.sleep(3000);
    }

    public boolean checkDeleteAndFollow(boolean checkFollowTheConnection, boolean checkDeleteTheConnection) {

        return checkFollowTheConnection && checkDeleteTheConnection;
    }
}
