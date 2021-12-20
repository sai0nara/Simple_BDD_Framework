package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/outsideorganisation/add
 */

@Name(value = "DjangoOutsideOrganisationAddPage")
public class DjangoOutsideOrganisationAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Название организации")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Название организации']");

    }

