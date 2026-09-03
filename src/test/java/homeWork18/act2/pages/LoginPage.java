package homeWork18.act2.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Page Object для страницы логина
 */
@Data
public class LoginPage {

    private SelenideElement usernameField;
    private SelenideElement passwordField;
    private SelenideElement loginButton;
    private SelenideElement resultMessage;
    private SelenideElement logoutButton;
    private SelenideElement titleLoginPage;

    public LoginPage() {

    }

    public void fillUsername(String username) {
        usernameField = $x( "//input[@type='text']" );
        usernameField.setValue( username );
    }

    public void fillPassword(String password) {
        passwordField = $x( "//input[@type='password']" );
        passwordField.setValue( password );
    }

    public void login() {
        loginButton = $x( "//button[@type='submit']" );
        loginButton.click();
    }

    public LoginPage shouldHaveResultMessage(String expectedText) {
        resultMessage = $x( "//h4[@class = 'subheader']" ).shouldHave( text( expectedText ) );
        resultMessage.shouldBe( visible );
        resultMessage.shouldHave( text( expectedText ) );
        return this;
    }

    public LoginPage shouldHaveErrorResultMessage(String expectedText) {
        resultMessage = $x( "//div[@id = 'flash-messages']/div ").shouldHave( text( expectedText ) );
        resultMessage.shouldBe( visible );
        resultMessage.shouldHave( text( expectedText ) );
        return this;
    }

    public LoginPage shouldHaveLogoutButton() {
        logoutButton = $$x( "//a[contains(@href, 'logout')]" ).first();
        logoutButton.shouldBe( visible );
        return this;
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public MainPage shouldHaveLoginPageTitle() {
        // Используем $() так как h1 обычно один
        $x( "//h2" ).shouldHave( text( "Login Page" ) );
        return new MainPage();
    }
}
