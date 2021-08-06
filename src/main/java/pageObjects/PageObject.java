package pageObjects;

import io.appium.java_client.AppiumDriver;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebElement;
import pageObjects.nativePageObjects.NativeLoginPage;
import setup.IPageObject;

import java.lang.reflect.Field;

public class PageObject implements IPageObject {

    Object somePageObject; // it should be set of web page or EPAM Test App WebElements
    //NativeLoginPage nativeLoginPage;
    //NativeRegisterPage nativeRegisterPage;

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {

        System.out.println("Current app type: "+appType);
        switch(appType){
            case "web":
                somePageObject = new WebPageObject(appiumDriver);
                break;
            case "native":
                somePageObject = new NativeLoginPage(appiumDriver);
                //somePageObject = new NativePageObject(appiumDriver);
                //nativeLoginPage = new NativeLoginPage(appiumDriver);
                //nativeRegisterPage = new NativeRegisterPage(appiumDriver);
                break;
            default: throw new Exception("Can't create a page object for "+appType);
        }

    }


    @Override
    public WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = somePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(somePageObject);

    }

    @Override
    public Object getMethod(String meName)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = somePageObject.getClass().getMethod(meName);
        method.setAccessible(true);
        somePageObject = method.invoke(somePageObject);
        return somePageObject;
    }
}
