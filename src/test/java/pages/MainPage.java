package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private static final By FRIENDS_TAB = By.cssSelector(".nav-side a[href*='friends']");
    private static final By SEARCH_INPUT = By.cssSelector("input[placeholder*='Искать на сайте']");
    private static final By TOOLBAR = By.id("topPanel");

    public void checkFriendsButton() {
        $(FRIENDS_TAB).shouldBe(visible.because("Кнопка перехода в друзья должна быть видна"));
    }

    public void clickFriends() {
        $(FRIENDS_TAB).click();
    }

    public void search(String query) {
        $(SEARCH_INPUT).setValue(query).pressEnter();
    }

    public void checkToolbarVisible() {
        $(TOOLBAR).shouldBe(visible.because("Тулбар должен быть виден на главной странице"));
    }
}
