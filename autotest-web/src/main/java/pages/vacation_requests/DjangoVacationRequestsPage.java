package pages.vacation_requests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

/**
 * PageObject, описывающий страницу 'Запросы на отпуск'
 * http://178.154.246.238:58082/admin/core/employeevacationrequest/
 */
@Name(value = "DjangoVacationRequestsPage")
public class DjangoVacationRequestsPage extends WebPage {

    @Name("Выполнить")
    private SelenideElement executeButton = $x("//button[@type='submit']");
    @Name("Действие")
    private SelenideElement action = $x("//select[@name='action']");
    @Name("Выпадающий список: Действие")
    private ElementsCollection dropDownAction = $$x("//select[@name='action']/option");
    @Name("Таблица чек-бокс")
    private ElementsCollection tableCheckboxes = $$x("//input[@class='action-select']");
    @Name("Выбрано 1 из")
    private SelenideElement howMuchSearch = $x("//span[@class='action-counter']");
}
