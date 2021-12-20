package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/employeesickleaveofficial/
 */

@Name(value = "DjangoEmployeeSickLeaveOfficialPage")
public class DjangoEmployeeSickLeaveOfficialPage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Больничный для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Больничный для изменения']");

    }

