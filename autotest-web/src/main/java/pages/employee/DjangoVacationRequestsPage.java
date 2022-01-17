package pages.employee;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;
/**
 * PageObject, описывающий страницу 'Запросы на отпуск'
 * http://178.154.246.238:58082/admin/core/employeevacationrequest/
 */
@Name(value = "DjangoVacationRequests")
public class DjangoVacationRequestsPage extends WebPage {

    @Name("Добавить запрос на отпуск")
    private SelenideElement addVacationRequest = $x("//a[@href=\"/admin/core/employeevacationrequest/add/\"]");
}
