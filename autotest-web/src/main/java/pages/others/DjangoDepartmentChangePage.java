package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/department/change
 */

@Name(value = "DjangoDepartmentChangePage")
public class DjangoDepartmentChangePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Департамент для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Департамент для изменения']");

    }

