package pageObjects.webPageObjects;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject {

    @FindBy(xpath = "//input[@name = 'q']")
    WebElement searchField;
    @FindBy(xpath = "//div[@id = 'rso']/div")
    List<WebElement> searchList;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    public void searchRequest(String searchRequest) {
        searchField.sendKeys(searchRequest);
        searchField.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getSearchList() {
        return searchList;
    }
}
