package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.SearchPage;

public class SearchTests extends BaseTest {

    @Test
    void shouldReturnSearchResults() {
        new LoginPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickLogin();

        new MainPage().search("Тестовый запрос");

        new SearchPage().checkInputVisible();
    }
}
