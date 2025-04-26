package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class SearchPage {

    private static final By SEARCH_INPUT = By.cssSelector("portal-search label input");
    public void checkInputVisible() {
        $(SEARCH_INPUT).shouldBe(visible.because("Поле поиска должно быть видно на странице поиска"));
    }
}
