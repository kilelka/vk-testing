package tests;

import org.junit.jupiter.api.Test;
import pages.FriendsPage;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FriendsTests extends BaseTest {

    @Test
    void shouldNavigateToFriendsSection() {
        new LoginPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickLogin();

        MainPage mainPage = new MainPage();
        mainPage.clickFriends();

        FriendsPage friendsPage = new FriendsPage();
        friendsPage.checkPossibleFriendsTabVisible();

        String tabText = friendsPage.getPossibleFriendsTabText();
        assertTrue(tabText.contains("Возможные друзья"),
                "Ожидали текст 'Возможные друзья', но получили: " + tabText);
    }
}
