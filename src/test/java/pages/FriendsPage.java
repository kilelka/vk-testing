package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FriendsPage {

    private static final By MY_FRIENDS_PAGE_BLOCK = By.id("hook_Block_MyFriendsNewPageMRB");
    private static final By SEARCH_INPUT_FIELD = By.xpath(".//friend-search-input//input");
    private static final By USER_FRIENDS_MENU_CONTENT = By.id("hook_Block_UserFriendsMenu");

    public void checkFriendsPageBlockVisible() {
        $(MY_FRIENDS_PAGE_BLOCK).shouldBe(visible.because("Блок 'Мои друзья' должен быть виден на странице друзей"));
    }

    public void search(String query) {
        SelenideElement input = $(SEARCH_INPUT_FIELD);
        input.shouldBe(visible.because("Поле поиска друзей должно быть видно")).setValue(query).pressEnter();
    }

    public void checkSearchResults() {
        $(USER_FRIENDS_MENU_CONTENT).shouldBe(visible.because("Контент меню друзей должен быть виден"));
    }
}
