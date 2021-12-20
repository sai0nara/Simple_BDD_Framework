package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

/**
 * ./admin/core/account/add
 */



@Name(value = "DjangoAccountAddPage")
public class DjangoAccountAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Аккаунт")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Аккаунт']");

    }

