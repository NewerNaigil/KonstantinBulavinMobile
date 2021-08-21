package scenarios;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.nativePageObjects.NativeLoginPage;
import setup.BaseTest;
import setup.dataproviders.TestDataProvider;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"},
          dataProvider = "userDataProvider",
          dataProviderClass = TestDataProvider.class,
          description = "This test check EPAM Test App")
    public void registerTest(String expectedTitle, String email, String userName, String password) {

        NativeLoginPage nativeLoginPage = (NativeLoginPage) getPo().getPageObject();

        WebElement header = nativeLoginPage.clickRegisterButton()
                                           .registerNewUser(
                                               email,
                                               userName,
                                               password)
                                           .login(
                                               email,
                                               password)
                                           .getHeaderText();

        Assert.assertEquals(header.getText(), expectedTitle);
    }
}
