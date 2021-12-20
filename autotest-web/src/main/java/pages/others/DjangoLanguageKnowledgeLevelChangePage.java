package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/languageknowledgelevel/change
 */

@Name(value = "DjangoLanguageKnowledgeLevelChangePage")
public class DjangoLanguageKnowledgeLevelChangePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Уровень знания иностранного языка для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Уровень знания иностранного языка для изменения']");

    }

