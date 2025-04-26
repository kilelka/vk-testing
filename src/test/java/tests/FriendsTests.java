package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import pages.FriendsPage;
import pages.LoginPage;
import pages.MainPage;

@DisplayName("Тесты для раздела 'Друзья'")
@Tag("friends")
public class FriendsTests extends BaseTest {

    private MainPage mainPage;
    private FriendsPage friendsPage;

    @BeforeEach
    void login() {
        new LoginPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickLogin();

        mainPage = new MainPage();
        friendsPage = new FriendsPage();
    }

    @Nested
    @DisplayName("Навигация")
    class NavigationTests {

        @Test
        @DisplayName("Переход в раздел 'Друзья'")
        @Timeout(20)
        void shouldNavigateToFriendsSection() {
            mainPage.clickFriends();
            friendsPage.checkFriendsPageBlockVisible();
        }
    }

    @Nested
    @DisplayName("Поиск")
    class SearchTests {

        @Test
        @DisplayName("Поиск друга по имени")
        @Timeout(40)
        void shouldSearchFriendByName() {
            mainPage.clickFriends();
            friendsPage.search("Иван Иванов");
            friendsPage.checkSearchResults();
        }
    }
}
