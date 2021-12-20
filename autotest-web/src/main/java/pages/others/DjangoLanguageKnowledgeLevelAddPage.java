package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/languageknowledgelevel/add
 */

@Name(value = "DjangoLanguageKnowledgeLevelAddPage")
public class DjangoLanguageKnowledgeLevelAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Уровень знания иностранного языка")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Уровень знания иностранного языка']");

    }

