package homeWork18.act2.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Builder;
import lombok.Data;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Page Object для главной страницы
 *
 * Лока́торы:
 * - CSS: $("div.class") - для одного элемента
 * - CSS: $$("div.class") - для коллекции
 * - XPath: $$x("//div[@class]") - для XPath (или $$("//div[@class]"))
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
        // Используем $$x() для XPath - ссылок может быть несколько
        linkFormAuthentication = $x( "//a[contains(text(), 'Form Authentication')]" );
        linkFormAuthentication.click();
    }

}
