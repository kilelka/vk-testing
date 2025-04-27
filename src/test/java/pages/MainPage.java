package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private static final By FRIENDS_TAB = By.cssSelector(".nav-side a[href*='friends']");
    private static final By SEARCH_INPUT = By.cssSelector("input[placeholder*='Искать на сайте']");
    private static final By TOOLBAR = By.id("topPanel");

    public MainPage load() {
        $(FRIENDS_TAB).shouldBe(visible.because("Кнопка перехода в друзья должна быть видна"));
        $(TOOLBAR).shouldBe(visible.because("Тулбар должен быть виден на главной странице"));
        return this;
    }

    public FriendsPage clickFriends() {
        $(FRIENDS_TAB).click();
        return new FriendsPage();
    }

    public MainPage search(String query) {
        $(SEARCH_INPUT).setValue(query).pressEnter();
        return this;
    }

    public MainPage checkToolbarVisible() {
        $(TOOLBAR).shouldBe(visible.because("Тулбар должен быть виден на главной странице"));
        return this;
    }

    public MainPage checkFriendsButton() {
        $(FRIENDS_TAB).shouldBe(visible.because("Кнопка перехода в друзья должна быть видна"));
        return this;
    }
}
