package PageObjectModel;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    Actions action;
    public JavascriptExecutor jsdriver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        action = new Actions(driver);
    }

    /**
     * @param key
     * @return WebElement
     */
    public WebElement findElement(By key) {
        WebElement element = presenceElement(key);
        scrollToElement(element);
        return element;
    }


    /**
     * @param key
     * @return List<WebElement>
     */
    public List<WebElement> findElements(By key) {
        List<WebElement> elements = presenceElements(key);
        scrollToElement(elements.get(0));
        return elements;
    }

    /**
     * @param key
     */


    public void click(By key) {
        wait.until(ExpectedConditions.elementToBeClickable(key)).click();
    }

    public void clickSvgItem(By item) {
        WebElement element = findElement(item);
        action.moveToElement(element).click().build().perform();
    }

    /**
     * @param key
     * @param text
     */
    public void sendKey(By key, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(key)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(key)).sendKeys(text);
    }

    public String getText(By key) {
        WebElement element = findElement(key);
        if (element != null)
            return findElement(key).getText();
        return null;
    }

    /**
     * @param key
     * @param text
     * @return boolean
     */
    public boolean checkElementText(By key, String text) {
        return wait.until(ExpectedConditions.textToBe(key, text));
    }

    /**
     * @param key
     */
    public void checkElementVisible(By key) {

        wait.until(ExpectedConditions.visibilityOf(findElement(key)));
    }


    /**
     * @param key
     */

    public void selectRandomProduct(By key) {
        List<WebElement> products = findElements(key);
        Random random = new Random();
        int number = 0;
        number = random.nextInt(products.size());
        try {
            products.get(number).click();
        } catch (Exception e) {
            jsdriver.executeScript("arguments[0].click();", products.get(number));
        }
    }

    /**
     * @param key
     * @param element
     */

    public void selectElementFromDropdown(By key, String element) {
        WebElement product = findElement(key);
        Select slc = new Select(product);
        slc.selectByVisibleText(element);
    }

    public void checkElementPresence(By key) {

        wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    /**
     * @param text
     * @return boolean
     */
    public boolean checkTitle(String text) {

        return wait.until(ExpectedConditions.titleIs(text));
    }

    /**
     * @param text
     */
    public void checkUrl(String text) {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

    public void backPage() {
        driver.navigate().back();
    }

    /**
     * @param key
     * @param attr
     * @return String
     */
    public String getAttribute(By key, String attr) {
        return findElement(key).getAttribute(attr);
    }

    /**
     * @param key
     * @param attr
     * @param text
     */
    public void checkAttribute(By key, String attr, String text) {
        Assert.assertEquals(getAttribute(key, attr), text);
    }

    /**
     * @param key
     * @param text
     */
    public boolean assertWithBoolean(By key, String text) {
        boolean find = false;
        WebElement element = findElement(key);
        if (find(element.getText(), text)) {
            find = true;
        }
        return find;
    }


    /**
     * @param key
     * @param text
     */
    public void clickElementWithText(By key, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                element.click();
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    /**
     * @param key
     * @param text
     */
    public void checkElementWithText(By key, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    /**
     * @param expectedList
     * @param actualList
     */

    public void checkStringList(List<String> expectedList, List<String> actualList) {
        Assert.assertEquals(expectedList, actualList);
    }

    /**
     * @param key
     * @param text
     * @param text2
     */
    public void sendKeyElementWithText(By key, String text, String text2) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.sendKeys(text2);
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    /**
     * @param key
     * @return WebElement
     */
//    public WebElement presenceElement(By key) {
//        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
//    }
    public WebElement presenceElement(By key) {
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(key));
        } catch (TimeoutException e) {

        }
        return element;
    }

    /**
     * @param key
     * @return List<WebElement>
     */
    public List<WebElement> presenceElements(By key) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
    }

    /**
     * @param element
     */
    public void scrollToElement(WebElement element) {
        if (element != null) {
            String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                    + "var elementTop = arguments[0].getBoundingClientRect().top;" + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
            ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
        }

    }

    public void scrollToUp() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
    }


    /**
     * @param filename
     * @return boolean
     */
    public boolean check_file_exist(String filename) {
        boolean result = false;
        String home = System.getProperty("user.home");
        String file_with_location = home + "\\Downloads\\" + filename;
        File file = new File(file_with_location);
        if (file.exists()) result = true;

        return result;
    }

    /**
     * @param haystack
     * @param needle
     * @return boolean
     */

    public static boolean find(String haystack, String needle) {
        Pattern p = Pattern.compile(needle, Pattern.LITERAL | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher m = p.matcher(haystack);
        return m.find();
    }

    public static boolean checkPositionsEquals(String positions, String currentPosition) {
        if (!positions.endsWith(","))
            positions += ",";

        String regex = "[\\p{Punct}]";
        List<String> Positions_Words_List = Arrays.stream(positions.split(","))
                .map(String::trim)
                .map(String::toLowerCase)
                .map(word -> word.replaceAll(regex, "")).toList();

        List<String> currentPosition_Words_List = Arrays.stream(currentPosition.split("\\s+"))
                .map(String::trim)
                .map(String::toLowerCase)
                .map(word -> word.replaceAll(regex, "")).toList();
        return Positions_Words_List.stream().anyMatch(currentPosition_Words_List::equals);
    }

}