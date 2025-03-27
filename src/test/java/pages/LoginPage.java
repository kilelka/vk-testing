package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final SelenideElement usernameInput = $x("//*[@id='field_email']");
    private final SelenideElement passwordInput = $x("//*[@id='field_password']");
    private final SelenideElement loginButton = $x("//form//input[@type='submit' or @value='Войти']");

    // Вводим логин и пароль
    public LoginPage enterCredentials(String username, String password) {
        usernameInput.shouldBe(visible).setValue(username);  // Ожидаем появления поля и вводим логин
        passwordInput.shouldBe(visible).setValue(password);  // Ожидаем появления поля и вводим пароль
        return this;  // Возвращаем текущий объект для продолжения цепочки вызовов
    }

    // Нажимаем кнопку "Войти"
    public void clickLogin() {
        loginButton.shouldBe(visible).click();  // Ожидаем видимости кнопки и нажимаем на нее
    }
}
