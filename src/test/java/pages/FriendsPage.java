package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FriendsPage {

    private final By possibleFriendsTab = By.xpath("//*[@id='hook_Block_UserFriendsMenu']//nav//a[contains(text(), 'Возможные друзья')]");

    public void checkPossibleFriendsTabVisible() {
        $(possibleFriendsTab).shouldBe(visible);
    }

    public String getPossibleFriendsTabText() {
        return $(possibleFriendsTab).getText();
    }
}
