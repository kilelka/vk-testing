package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.SearchPage;

public class SearchTests extends BaseTest {

    @Test
    @DisplayName("Поиск по запросу")
    void shouldReturnSearchResults() {
        new LoginPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickLogin();

        new MainPage().search("Тестовый запрос");

        new SearchPage().checkInputVisible();
    }

    @Test
    @Disabled("Тест временно отключен")
    @DisplayName("Поиск с пустым запросом")
    void shouldHandleEmptySearch() {
        new LoginPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickLogin();

        new MainPage().search("");

        new SearchPage().checkInputVisible();
    }
}