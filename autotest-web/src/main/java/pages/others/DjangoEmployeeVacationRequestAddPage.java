package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы ./admin/core/employeevacationrequest/add
//Предлагаю добавлять URL как однозначный идентификатор ко всем создаваемым PageObject

@Name(value = "DjangoEmployeeVacationRequestAddPage")
public class DjangoEmployeeVacationRequestAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Запрос на отпуск")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Запрос на отпуск']");

    }

