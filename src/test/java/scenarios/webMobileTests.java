package scenarios;

import java.util.Locale;
import org.openqa.selenium.Keys;
import setup.dataproviders.TestDataProvider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.webPageObjects.WebPageObject;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, dataProvider = "searchDataProvider", dataProviderClass = TestDataProvider.class, description = "This test check web search on Google")
    public void googleWebTest(String requestData) {
        getDriver().get("https://www.google.com/");

        new WebDriverWait(getDriver(), 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        WebPageObject webPageObject = (WebPageObject) getPo().getPageObject();

        webPageObject.searchRequest(requestData);

        for (WebElement x : webPageObject.getSearchList()) {
            Assert.assertTrue(x.getText().toUpperCase(Locale.ROOT).contains(requestData));
        }
    }
}
