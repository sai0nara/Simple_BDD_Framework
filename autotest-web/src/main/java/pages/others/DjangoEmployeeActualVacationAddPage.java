package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/employeeactualvacation/add
 */

@Name(value = "DjangoEmployeeActualVacationAddPage")
public class DjangoEmployeeActualVacationAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Фактический отпуск")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Фактический отпуск']");

    }

