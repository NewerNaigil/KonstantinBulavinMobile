package scenarios;

import org.testng.asserts.SoftAssert;
import setup.dataproviders.TestDataProvider;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nativePageObjects.NativeLoginPage;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, dataProvider = "userDataProvider", dataProviderClass = TestDataProvider.class, description = "This test check EPAM Test App")
    @Parameters({"expectedTitle"})
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

        //Assert.assertEquals(header.getText(), expectedTitle);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(header.getText(), expectedTitle);

        softAssert.assertAll();
    }
}
