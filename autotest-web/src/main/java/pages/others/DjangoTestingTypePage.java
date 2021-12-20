package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/testingtype/
 */

@Name(value = "DjangoTestingTypePage")
public class DjangoTestingTypePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Тип тестирования для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Тип тестирования для изменения']");

    }

