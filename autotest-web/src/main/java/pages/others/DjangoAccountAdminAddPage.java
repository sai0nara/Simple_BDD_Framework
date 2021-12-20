package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

/**
 * ./admin/core/accountadmin/add
 */

@Name(value = "DjangoAccountAdminAddPage")
public class DjangoAccountAdminAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Администратор аккаунта")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Администратор аккаунта']");

    }

