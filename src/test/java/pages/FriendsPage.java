package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FriendsPage {

    private final By possibleFriendsTab = By.xpath("//*[@id='hook_Block_UserFriendsMenu']//nav//a[contains(text(), 'Возможные друзья')]");
    private final By searchInputField = By.xpath("//div[@id='hook_Block_UserFriendsMenu']//friend-search-input//label/input");
    private final By searchResultBlock = By.xpath("//div[@id='hook_Block_MyFriendsFriendSearchPagingB']");

    public void checkPossibleFriendsTabVisible() {
        $(possibleFriendsTab).shouldBe(visible);
    }

    public String getPossibleFriendsTabText() {
        return $(possibleFriendsTab).getText();
    }

    public void search(String query) {
        SelenideElement input = $(searchInputField);

        input.click();
        input.setValue(query);
        input.pressEnter();
    }

    public void checkSearchResults() {
        $(searchResultBlock).shouldBe(visible);
    }
}
