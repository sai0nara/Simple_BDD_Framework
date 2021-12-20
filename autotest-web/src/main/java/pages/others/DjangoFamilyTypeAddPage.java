package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/familytype/add
 */

@Name(value = "DjangoFamilyTypeAddPage")
public class DjangoFamilyTypeAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Тип родства")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Тип родства']");

    }

