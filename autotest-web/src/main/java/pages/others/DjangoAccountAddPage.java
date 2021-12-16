package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы ./admin/core/account/add
//Предлагаю добавлять URL как однозначный идентификатор ко всем создаваемым PageObject

@Name(value = "DjangoAccountAddPage")
public class DjangoAccountAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Аккаунт")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Аккаунт']");

    }

