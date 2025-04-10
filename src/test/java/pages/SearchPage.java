package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class SearchPage {

    private final By searchInput = By.cssSelector("#hook_Block_SearchMRB portal-search label");

    public void checkInputVisible() {
        $(searchInput).shouldBe(visible);
    }
}
