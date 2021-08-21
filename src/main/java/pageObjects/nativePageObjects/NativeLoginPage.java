package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativeLoginPage extends NativeAbstractPage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    WebElement loginEmailTextField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    WebElement passwordField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement singInButton;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    WebElement registerButton;

    public NativeLoginPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public NativeBudgetActivityPage login(String email, String password) {
        loginEmailTextField.sendKeys(email);
        passwordField.sendKeys(password);
        singInButton.click();
        return new NativeBudgetActivityPage(appiumDriver);
    }

    public NativeRegisterPage clickRegisterButton() {
        registerButton.click();
        return new NativeRegisterPage(appiumDriver);
    }
}
