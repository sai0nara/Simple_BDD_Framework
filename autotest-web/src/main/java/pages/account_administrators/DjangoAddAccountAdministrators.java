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
    @Name("Сохранить и продолжить редактирование")
    private SelenideElement saveContinueEditing = $x("//input[@name = '_continue']");
    @Name("Пожалуйста, исправьте ошибки ниже.")
    private SelenideElement pleaseFixErrors = $x("//p[@class = 'errornote']");

    @Name("Инфоблок сотрудник")
    private SelenideElement employeeInfo = $x("//label[@for = 'id_employee']/../../ul");
    @Name("Инфоблок аккаунт")
    private SelenideElement accountInfo = $x("//label[@for = 'id_account_name']/../../ul");
    @Name("Инфоблок дата начала")
    private SelenideElement startDateInfo = $x("//label[@for = 'id_start_date']/../../ul");
    @Name("Инфоблок дата окончания")
    private SelenideElement endDateInfo = $x("//input[@id = 'id_end_date']/../../ul");


    @Name("Дата начала")
    private SelenideElement startDate = $x("//input[@id = 'id_start_date']");
    @Name("Дата окончания")
    private SelenideElement endDate = $x("//input[@id = 'id_end_date']");
}
