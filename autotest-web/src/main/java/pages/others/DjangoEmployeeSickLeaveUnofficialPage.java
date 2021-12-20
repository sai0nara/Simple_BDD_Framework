package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/employeesickleaveunofficial/
 */

@Name(value = "DjangoEmployeeSickLeaveUnofficialPage")
public class DjangoEmployeeSickLeaveUnofficialPage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Бюллютень без больничного листа для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Бюллютень без больничного листа для изменения']");

    }

