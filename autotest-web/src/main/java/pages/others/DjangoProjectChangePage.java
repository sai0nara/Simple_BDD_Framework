package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/project/change
 */

@Name(value = "DjangoProjectChangePage")
public class DjangoProjectChangePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Проект для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Проект для изменения']");

    }

