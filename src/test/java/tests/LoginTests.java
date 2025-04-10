package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginTests extends BaseTest {

    @Test
    void loginShouldSucceed() {
        new LoginPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickLogin();

        new MainPage().checkFriendsButton();
    }
}