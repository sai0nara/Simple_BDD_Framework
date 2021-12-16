package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы ./admin/core/employeeactualvacation/change
//Предлагаю добавлять URL как однозначный идентификатор ко всем создаваемым PageObject

@Name(value = "DjangoEmployeeActualVacationChangePage")
public class DjangoEmployeeActualVacationChangePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Фактический отпуск для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Фактический отпуск для изменения']");

    }

