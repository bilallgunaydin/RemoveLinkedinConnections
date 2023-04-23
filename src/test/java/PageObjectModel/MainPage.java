package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    By clickMyNetworkButton = By.xpath("//a[@href='https://www.linkedin.com/mynetwork/?']");
    By clickConnectionsButton = By.xpath("(//a[@class='ember-view mn-community-summary__link link-without-hover-state'])[1]");
    By clickSearchWithFilterButton = By.xpath("//a[@class='ember-view mn-connections__search-with-filters link-without-visited-state']");


    public void setClickMyNetworkButton() {
        click(clickMyNetworkButton);
    }

    public void setClickConnectionsButton() {
        click(clickConnectionsButton);
    }

    public void setClickSearchWithFilterButton() {
        click(clickSearchWithFilterButton);
    }
}
