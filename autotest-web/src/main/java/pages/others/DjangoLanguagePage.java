package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/language/
 */

@Name(value = "DjangoLanguagePage")
public class DjangoLanguagePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Иностранный язык для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Иностранный язык для изменения']");

    }

