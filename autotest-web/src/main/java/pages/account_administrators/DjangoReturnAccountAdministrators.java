package pages.account_administrators;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * PageObject, описывающий страницу 'Восстановить экземпляр (Администраторы Аккаунта)'
 * http://178.154.246.238:58082/admin/core/accountadmin/recover/1444
 */
@Name("DjangoRestoreAccountAdministrators")
public class DjangoReturnAccountAdministrators {

    @Name("Сохранить")
    private SelenideElement save = $x("//input[@name='_save']");

    @Name("Вернуть")
    private SelenideElement returnContent = $x("//div[@id='content']/h1");

    @Name("поле Фамилии")
    private SelenideElement surname = $x("//input[@name='surname']");

    @Name("Инфоблок")
    private SelenideElement infoblock = $("#employee_form > p");
}
