package pages.account_administrators;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.*;

/**
 * PageObject, описывающий страницу 'Добавить Администраторы аккаунта'
 * http://178.154.246.238:58082/admin/core/accountadmin/add/
 */
@Name(value = "DjangoAddAccountAdministrators")
public class DjangoAddAccountAdministrators extends WebPage {

    @Name("Добавить Администратор аккаунта")
    private SelenideElement title = $x("//div[@id = 'content']/h1");
}
