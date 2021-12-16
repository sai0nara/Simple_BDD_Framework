package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы ./admin/core/accountadmin/
//Предлагаю добавлять URL как однозначный идентификатор ко всем создаваемым PageObject

@Name(value = "DjangoAccountAdminChangePage")
public class DjangoAccountAdminChangePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Администратор аккаунта для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Администратор аккаунта для изменения']");

    }

