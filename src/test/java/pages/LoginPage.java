package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static final By USERNAME_INPUT = By.id("field_email");
    private static final By PASSWORD_INPUT = By.id("field_password");
    private static final By LOGIN_BUTTON = By.cssSelector("input[type='submit']");
    private static final By LOGIN_ERROR = By.xpath(".//*[contains(@class, 'login_error')]");

    public LoginPage enterUsername(String username) {
        $(USERNAME_INPUT).shouldBe(visible.because("Поле ввода имени пользователя должно быть видно")).setValue(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $(PASSWORD_INPUT).shouldBe(visible.because("Поле ввода пароля должно быть видно")).setValue(password);
        return this;
    }

    public void clickLogin() {
        $(LOGIN_BUTTON).shouldBe(visible.because("Кнопка входа должна быть видимой")).click();
    }

    public void checkErrorVisible() {
        $(LOGIN_ERROR).shouldBe(visible.because("Должно отображаться сообщение об ошибке логина"));
    }
}
