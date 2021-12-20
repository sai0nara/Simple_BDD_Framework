package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/administrator/add
 */

@Name(value = "DjangoAdministratorAddPage")
public class DjangoAdministratorAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Сотрудник с административным доступом")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Сотрудник с административным доступом']");

    }

