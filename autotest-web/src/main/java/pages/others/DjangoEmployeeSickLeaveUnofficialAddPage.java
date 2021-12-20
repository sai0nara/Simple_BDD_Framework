package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/employeesickleaveunofficial/add
 */

@Name(value = "DjangoEmployeeSickLeaveUnofficialAddPage")
public class DjangoEmployeeSickLeaveUnofficialAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Бюллютень без больничного листа")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Бюллютень без больничного листа']");

    }

