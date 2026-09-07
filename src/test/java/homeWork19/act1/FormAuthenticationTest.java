package homeWork19.act1;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * ACT 1: Тесты как их писали наши родители
 */
public class FormAuthenticationTest {

    @Test
    public void testFormAuthenticationScenario1() {
        // 1. Открыть страницу
        open("https://the-internet.herokuapp.com/");

        // 2. Кликнуть по ссылке с текстом Form Authentication
        $x( "//a[contains(text(), 'Form Authentication')]" ).click();

        // 3. Проверить что заголовок страницы содержит текст Login Page
        $x( "//h2" ).shouldHave( text( "Login Page" ) );

        // 4. Установить в Username значение tomsmith
        $x( "//input[@type='text']" ).setValue( "tomsmith" );

        // 5. Установить в поле Password значение SuperSecretPassword!
        $x( "//input[@type='password']" ).setValue( "SuperSecretPassword!" );

        // 6. Нажать кнопку Login
        $x( "//button[@type='submit']" ).click();

        // 7. Найти сообщение результата логина и проверить, что оно содержит текст You logged into a secure area!
        $x( "//h4[@class = 'subheader']" ).shouldHave( text( "Welcome to the Secure Area. When you are done click logout below." ) );

        // 8. Проверить что на экране присутствует кнопка Logout
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
        $x( "//h2" ).shouldHave( text( "Login Page" ) );

        // 4. Установить в Username значение admin
        $x( "//input[@type='text']" ).setValue( "admin" );

        // 5. Установить в поле Password значение 1234
        $x( "//input[@type='password']" ).setValue( "1234" );

        // 6. Нажать кнопку Login
        $x( "//button[@type='submit']" ).click();

        // 7. Найти сообщение результата логина и проверить, что оно содержит текст Your username is invalid!
        $x( "//div[@id = 'flash-messages']/div ").shouldHave( text( "Your username is invalid!" ) );
    }
}
