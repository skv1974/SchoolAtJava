package homeWork18.act1;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * ACT 1: Тесты как их писали наши родители
 * Весь код слитно в одном тесте, никаких паттернов, чистый Селенид
 *
 * ВАЖНО: $() возвращает один элемент, $$() возвращает коллекцию!
 *
 * Лока́торы:
 * - CSS: $("div.class") - для одного элемента
 * - CSS: $$("div.class") - для коллекции
 * - XPath: $$x("//div[@class]") - для XPath (или $$("//div[@class]"))
 *
 * Примечание: $() используется для уникальных элементов (один на странице),
 * $$() используется для множественных элементов, когда нужно выбрать один
 */
public class FormAuthenticationTest {

    @Test
    public void testFormAuthenticationScenario1() {
        // 1. Открыть страницу
        open("https://the-internet.herokuapp.com/");

        // 2. Кликнуть по ссылке с текстом Form Authentication
        // Используем $$x() для XPath - ссылок может быть несколько
        $x( "//a[contains(text(), 'Form Authentication')]" ).click();

        // 3. Проверить что заголовок страницы содержит текст Login Page
        // Используем $() так как h1 обычно один
        $x( "//h2" ).shouldHave( text( "Login Page" ) );

        // 4. Установить в Username значение tomsmith
        // Используем $() так как input[type='text'] обычно один
        $x( "//input[@type='text']" ).setValue( "tomsmith" );

        // 5. Установить в поле Password значение SuperSecretPassword!
        // Используем $() так как input[type='password'] обычно один
        $x( "//input[@type='password']" ).setValue( "SuperSecretPassword!" );

        // 6. Нажать кнопку Login
        // Используем $() так как button[type='submit'] обычно одна
        $x( "//button[@type='submit']" ).click();

        // 7. Найти сообщение результата логина и проверить, что оно содержит текст You logged into a secure area!
        // Используем $() с уникальным XPath
        $x( "//h4[@class = 'subheader']" ).shouldHave( text( "Welcome to the Secure Area. When you are done click logout below." ) );

        // 8. Проверить что на экране присутствует кнопка Logout
        // Используем $() так как ссылка logout обычно одна
        $x( "//a[contains(@href, 'logout')]" ).shouldBe( visible );

        // 9. Нажать на кнопку Logout
        $x( "//a[contains(@href, 'logout')]" ).click();

        // 10. Проверить что страница на которую произошел переход - имеет заголовок с текстом Login Page
        $x( "//h1" ).shouldHave( text( "Login Page" ) );
    }

    @Test
    public void testFormAuthenticationScenario2() {
        // 1. Открыть страницу
        open("https://the-internet.herokuapp.com/");

        // 2. Кликнуть по ссылке с текстом Form Authentication
        $x( "//a[contains(text(), 'Form Authentication')]" ).click();

        // 3. Проверить что внизу страницы есть ссылка с текстом Elemental Selenium
        // Используем $() с уникальным XPath
        $x( "//h2" ).shouldHave( text( "Login Page" ) );

        // 4. Установить в Username значение admin
        $x( "//input[@type='text']" ).setValue( "admin" );

        // 5. Установить в поле Password значение 1234
        $x( "//input[@type='password']" ).setValue( "1234" );

        // 6. Нажать кнопку Login
        $x( "//button[@type='submit']" ).click();

        // 7. Найти сообщение результата логина и проверить, что оно содержит текст Your username is invalid!
        // Используем $() с уникальным XPath
        $x( "//div[@id = 'flash-messages']/div ").shouldHave( text( "Your username is invalid!" ) );
    }
}
