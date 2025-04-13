package tests;


import org.junit.jupiter.api.*;
import pages.FriendsPage;
import pages.LoginPage;
import pages.MainPage;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
            friendsPage.checkPossibleFriendsTabVisible();

            String tabText = friendsPage.getPossibleFriendsTabText();

            assertAll("Проверки вкладки",
                    () -> assertTrue(tabText.contains("Возможные друзья"),
                            "Ожидали текст 'Возможные друзья', но получили: " + tabText)
            );
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
