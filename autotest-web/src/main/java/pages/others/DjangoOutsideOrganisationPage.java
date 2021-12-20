package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/outsideorganisation/
 */

@Name(value = "DjangoOutsideOrganisationPage")
public class DjangoOutsideOrganisationPage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Название организации для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Название организации для изменения']");

    }

