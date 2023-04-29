package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    By email = By.id("session_key");
    By password = By.id("session_password");
    By signIn = By.xpath("//button[@data-id='sign-in-form__submit-btn']");

    public void login(String setEmail, String setPassword) {
        sendKey(email, setEmail);
        sendKey(password, setPassword);
        click(signIn);
        checkUrl("/feed");
    }
}
