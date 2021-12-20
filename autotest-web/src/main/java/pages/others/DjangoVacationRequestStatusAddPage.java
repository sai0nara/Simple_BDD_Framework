package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/vacationrequeststatus/add
 */

@Name(value = "DjangoVacationRequestStatusAddPage")
public class DjangoVacationRequestStatusAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Статус запроса на отпуск")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Статус запроса на отпуск']");

    }

