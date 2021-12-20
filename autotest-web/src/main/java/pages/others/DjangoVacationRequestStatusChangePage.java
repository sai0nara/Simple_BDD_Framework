package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/vacationrequeststatus/change
 */

@Name(value = "DjangoVacationRequestStatusChangePage")
public class DjangoVacationRequestStatusChangePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Статус запроса на отпуск для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Статус запроса на отпуск для изменения']");

    }

