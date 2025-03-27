package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class OkTests {

    @BeforeEach
    void setUp() {
        open("https://ok.ru/");
    }

    // Открытие главной страницы
    @Test
    void openMainPageTest() {
        String currentUrl = WebDriverRunner.url();
        assertEquals("https://ok.ru/", currentUrl, "URL не соответствует ожидаемому!");
    }

    // Авторизация
    @Test
    void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .enterCredentials("логин", "пароль")
                .clickLogin();

        MainPage mainPage = new MainPage();
        mainPage.checkFriendsButton();
    }

    // Переход в раздел "Друзья"
    @Test
    void goToFriendsSection() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .enterCredentials("логин", "пароль")
                .clickLogin();

        MainPage mainPage = new MainPage();
        mainPage.clickFriends();

        // Проверка, что мы находимся в разделе "Друзья"
        assertTrue($("h3").getText().contains("Возможно, вы знаете этих людей"), "Мы не в разделе 'Друзья'!");
    }

    // Поиск по сайту
    @Test
    void searchTest() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .enterCredentials("логин", "пароль")
                .clickLogin();

        MainPage mainPage = new MainPage();
        mainPage.search("Тестовый запрос");

        // Проверка, что результаты поиска отобразились
        assertTrue($x("//*[@id='hook_Block_SearchMRB']/portal-search/div[2]").isDisplayed(), "Результаты поиска не отображаются!");    }

    @AfterEach
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
