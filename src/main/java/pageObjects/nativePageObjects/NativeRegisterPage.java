package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativeRegisterPage extends NativeAbstractPage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    WebElement emailField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement userNameField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement passwordField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement confirmPasswordField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    WebElement registerNewAccountButton;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_cancel_button")
    WebElement cancelButton;

    public NativeRegisterPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public NativeLoginPage registerNewUser(String email, String login, String password) {
        emailField.sendKeys(email);
        userNameField.sendKeys(login);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        registerNewAccountButton.click();
        return new NativeLoginPage(appiumDriver);
    }
}
