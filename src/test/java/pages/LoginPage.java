package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final SelenideElement usernameInput = $x("//*[@id='field_email']");
    private final SelenideElement passwordInput = $x("//*[@id='field_password']");
    private final SelenideElement loginButton = $x("//form//input[@type='submit' or @value='Войти']");

    public LoginPage enterCredentials(String username, String password) {
        usernameInput.shouldBe(visible).setValue(username);
        passwordInput.shouldBe(visible).setValue(password);
        return this;
    }

    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }
}
