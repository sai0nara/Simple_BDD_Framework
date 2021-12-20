package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/educationspecialty/
 */

@Name(value = "DjangoEducationSpecialtyPage")
public class DjangoEducationSpecialtyPage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Специальность для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Специальность для изменения']");

    }

