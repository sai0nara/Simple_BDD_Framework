package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/position/change
 */

@Name(value = "DjangoPositionChangePage")
public class DjangoPositionChangePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Должность")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Должность для изменения']");

    }

