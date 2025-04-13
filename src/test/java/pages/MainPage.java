package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final By friendsTab = By.xpath("//a[contains(@class, 'nav-side') and contains(@href, 'friends')]");
    private final By searchInput = By.xpath("//input[@type='text' and contains(@placeholder, 'Искать на сайте')]");
    private By toolbar = By.id("topPanel");

    public void checkFriendsButton() {
        $(friendsTab).shouldBe(visible);
    }

    public void clickFriends() {
        $(friendsTab).click();
    }

    public void search(String query) {
        $(searchInput).setValue(query).pressEnter();
    }

    public void checkToolbarVisible() {
        $(toolbar).shouldBe(visible);
    }
}