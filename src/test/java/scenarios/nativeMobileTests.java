package scenarios;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nativePageObjects.NativeLoginPage;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This test check EPAM Test App")
    @Parameters({"expectedTitle"})
    public void registerTest(String expectedTitle) {

        NativeLoginPage nativeLoginPage = (NativeLoginPage) getPo().getPageObject();

        WebElement header = nativeLoginPage.clickRegisterButton()
                                           .registerNewUser(
                                               configReader.getEmail(),
                                               configReader.getUserName(),
                                               configReader.getPassword())
                                           .login(
                                               configReader.getEmail(),
                                               configReader.getPassword())
                                           .getHeaderText();

        Assert.assertEquals(header.getText(), expectedTitle);
    }
}
