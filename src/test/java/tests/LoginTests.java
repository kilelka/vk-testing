package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertAll;

public class LoginTests extends BaseTest {

    @DisplayName("Проверка логина с разными данными")
    @Tag("auth")
    @Timeout(30)
    @ParameterizedTest(name = "Логин: [{0}], Пароль: [{1}] → Успешно: {2}")
    @CsvSource({
            "technopol43, technopolisPassword, true",
            "wrongUser, wrongPass, false"
    })
    void loginTest(String username, String password, boolean shouldLoginSucceed) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(username)
                .enterPassword(password)
                .clickLogin();

        if (shouldLoginSucceed) {
            MainPage mainPage = new MainPage();
            assertAll("Проверка успешного логина",
                    () -> mainPage.checkFriendsButton(),
                    () -> mainPage.checkToolbarVisible()
            );
        } else {
            loginPage.checkErrorVisible();
        }
    }
}
