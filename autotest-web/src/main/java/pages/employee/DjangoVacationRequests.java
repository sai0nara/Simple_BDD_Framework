package pages.employee;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "DjangoVacationRequests")
public class DjangoVacationRequests extends WebPage {

    @Name("Добавить запрос на отпуск")
    private SelenideElement addVacationRequest = $x("//a[@href=\"/admin/core/employeevacationrequest/add/\"]");
}
