package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы ./admin/core/employeevacationrequest/change
//Предлагаю добавлять URL как однозначный идентификатор ко всем создаваемым PageObject

@Name(value = "DjangoAccountAdminChangePage")
public class DjangoEmployeeVacationRequestChangePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Запрос на отпуск для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Запрос на отпуск для изменения']");

    }

