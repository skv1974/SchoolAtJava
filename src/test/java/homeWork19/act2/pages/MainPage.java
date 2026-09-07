package homeWork19.act2.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import static com.codeborne.selenide.Selenide.*;

/**
 * Page Object для главной страницы
 */
@Data
public class MainPage {

    public static final String URL = "https://the-internet.herokuapp.com/";

    private SelenideElement linkFormAuthentication;

    public MainPage() {

    }

    public void open() {
        Selenide.open(URL);
    }

    public void goToFormAuthentication() {
        linkFormAuthentication = $x( "//a[contains(text(), 'Form Authentication')]" );
        linkFormAuthentication.click();
    }

}
