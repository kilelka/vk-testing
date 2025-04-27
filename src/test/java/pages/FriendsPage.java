package pages;

import components.LoadableComponent;
import elements.InputField;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FriendsPage extends LoadableComponent<FriendsPage> {

    private static final By MY_FRIENDS_PAGE_BLOCK = By.xpath("//*[@id='hook_Block_MyFriendsNewPageMRB']");
    private static final By SEARCH_INPUT_FIELD = By.xpath(".//friend-search-input//input");
    private static final By USER_FRIENDS_MENU_CONTENT = By.id("hook_Block_UserFriendsMenu");

    private final InputField searchInput = new InputField($(SEARCH_INPUT_FIELD));

    @Override
    protected void isLoaded() {
        $(MY_FRIENDS_PAGE_BLOCK).shouldBe(visible.because("Блок 'Мои друзья' должен быть виден на странице друзей"));
    }

    public FriendsPage search(String query) {
        searchInput.setValue(query).pressEnter();
        return this;
    }

    public FriendsPage checkSearchResults() {
        $(USER_FRIENDS_MENU_CONTENT).shouldBe(visible.because("Контент меню друзей должен быть виден"));
        return this;
    }
}
