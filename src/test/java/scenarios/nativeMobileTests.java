package scenarios;

import java.lang.reflect.InvocationTargetException;
import org.testng.annotations.Test;
import pageObjects.nativePageObjects.NativeRegisterPage;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

//    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
//    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
//        getPo().getWelement("signInBtn").click();
//        System.out.println("Simplest Android native test done");
//    }

    @Test(groups = {"native"})
    public void registerTest()
        throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException,
        InvocationTargetException {
        getPo().getMethod("clickRegisterButton");
        getPo().getWelement("emailField").sendKeys("1@1.com");
        getPo().getWelement("userNameField").sendKeys("111");
        getPo().getWelement("passwordField").sendKeys("12345678");
        getPo().getWelement("confirmPasswordField").sendKeys("12345678");
        getPo().getMethod("registerButtonClick");
        getPo().getWelement("loginEmailTextField").sendKeys("1@1.com");
        getPo().getWelement("passwordField").sendKeys("12345678");
        getPo().getWelement("singInButton").click();
        //getPo().getMethod("singInButton");

    }

}
