package setup;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebElement;

public interface IPageObject {

    WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
    Object getMethod(String meName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

}
