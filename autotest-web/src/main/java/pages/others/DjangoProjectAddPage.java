package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/project/add
 */

@Name(value = "DjangoProjectAddPage")
public class DjangoProjectAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Проект")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Проект']");

    }

