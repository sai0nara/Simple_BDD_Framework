package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/language/add
 */

@Name(value = "DjangoLanguageAddPage")
public class DjangoLanguageAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Иностранный язык")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Иностранный язык']");

    }

