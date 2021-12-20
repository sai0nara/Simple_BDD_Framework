package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/education/
 */

@Name(value = "DjangoEducationPage")
public class DjangoEducationPage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Образование для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Образование для изменения']");

    }

