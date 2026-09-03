package homeWork18.act2.tests;

import homeWork18.act2.pages.LoginPage;
import homeWork18.act2.pages.MainPage;
import org.junit.jupiter.api.Test;

/**
 * ACT 2: Рефакторинг с использованием PageObject pattern
 */
public class FormAuthenticationTest {

    private final MainPage mainPage = new MainPage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void testFormAuthenticationScenario1() {
        // 1. Открыть страницу
        mainPage.open();

        // 2. Кликнуть по ссылке с текстом Form Authentication
        mainPage.goToFormAuthentication();

        // 3. Проверить что заголовок страницы содержит текст Login Page
        loginPage.shouldHaveLoginPageTitle();

        // 4. Установить в Username значение tomsmith
        loginPage.fillUsername("tomsmith");

        // 5. Установить в поле Password значение SuperSecretPassword!
        loginPage.fillPassword("SuperSecretPassword!");

        // 6. Нажать кнопку Login
        loginPage.login();

        // 7. Найти сообщение результата логина и проверить, что оно содержит текст You logged into a secure area!
        loginPage.shouldHaveResultMessage("Welcome to the Secure Area. When you are done click logout below.");

        // 8. Проверить что на экране присутствует кнопка Logout
        loginPage.shouldHaveLogoutButton();

        // 9. Нажать на кнопку Logout
        loginPage.clickLogout();

        // 10. Проверить что страница на которую произошел переход - имеет заголовок с текстом Login Page
        loginPage.shouldHaveLoginPageTitle();
    }

    @Test
    public void testFormAuthenticationScenario2() {
        // 1. Открыть страницу
        mainPage.open();

        // 2. Кликнуть по ссылке с текстом Form Authentication
        mainPage.goToFormAuthentication();

        // 3. Проверить что заголовок страницы содержит текст Login Page
        loginPage.shouldHaveLoginPageTitle();

        // 4. Установить в Username значение admin
        loginPage.fillUsername("admin");

        // 5. Установить в поле Password значение 1234
        loginPage.fillPassword("1234");

        // 6. Нажать кнопку Login
        loginPage.login();

        // 7. Найти сообщение результата логина и проверить, что оно содержит текст Your username is invalid!
        loginPage.shouldHaveErrorResultMessage("Your username is invalid!");
    }
}
