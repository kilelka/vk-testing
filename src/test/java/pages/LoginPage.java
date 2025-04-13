package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final By usernameInput = By.id("field_email");
    private final By passwordInput = By.id("field_password");
    private final By loginButton = By.cssSelector("input[type='submit']");
    private final By loginError = By.xpath("//form//div[contains(text(), 'Неправильно указан логин и/или пароль')]");

    public LoginPage enterUsername(String username) {
        $(usernameInput).shouldBe(visible).setValue(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $(passwordInput).shouldBe(visible).setValue(password);
        return this;
    }

    public void clickLogin() {
        $(loginButton).shouldBe(visible).click();
    }

    public void checkErrorVisible() {
        $(loginError).shouldBe(visible);
    }
}
