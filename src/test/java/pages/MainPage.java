package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement friendsTab = $x("//*[@id='hook_Block_Navigation']/div/div/div[4]/a");
    private final SelenideElement searchInput = $x("//*[@id='toolbar_search']/toolbar-search/form/div/label/input");

    public void checkFriendsButton() {
        friendsTab.shouldBe(com.codeborne.selenide.Condition.visible);
    }

    public void clickFriends() {
        friendsTab.click();
    }

    public void search(String query) {
        searchInput.setValue(query);
        searchInput.pressEnter();
    }
}
