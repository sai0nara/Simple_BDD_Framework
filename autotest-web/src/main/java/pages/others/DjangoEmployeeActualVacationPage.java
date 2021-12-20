package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/employeeactualvacation/
 */

@Name(value = "DjangoEmployeeActualVacationPage")
public class DjangoEmployeeActualVacationPage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Фактический отпуск для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Фактический отпуск для изменения']");

    }

