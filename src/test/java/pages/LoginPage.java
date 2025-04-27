package pages;

import elements.InputField;
import models.UserCredentials;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static final By USERNAME_INPUT = By.id("field_email");
    private static final By PASSWORD_INPUT = By.id("field_password");
    private static final By LOGIN_BUTTON = By.cssSelector("input[type='submit']");
    private static final By LOGIN_ERROR = By.xpath(".//*[contains(@class, 'login_error')]");

    private final InputField usernameInput = new InputField($(USERNAME_INPUT));
    private final InputField passwordInput = new InputField($(PASSWORD_INPUT));

    public LoginPage enterUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public LoginPage login(UserCredentials user) {
        enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .clickLogin();
        return this;
    }

    public void clickLogin() {
        $(LOGIN_BUTTON).shouldBe(visible.because("Кнопка входа должна быть видимой")).click();
    }

    public void checkErrorVisible() {
        $(LOGIN_ERROR).shouldBe(visible.because("Должно отображаться сообщение об ошибке логина"));
    }
}
