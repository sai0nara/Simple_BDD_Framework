package ts7;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.*;

public class AddEmployeePageTest extends WebHooks {

    private PageManager pageManager = new PageManager();
    private final AuthorizationSteps authorizationSteps = new AuthorizationSteps(pageManager);
    private final WebActionSteps webActionSteps = new WebActionSteps(pageManager);
    private final EmployeeCheckSteps employeeCheckSteps = new EmployeeCheckSteps(pageManager);

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"hr", "Сотрудники", "Добавить сотрудник"}
        };
    }

    @Test(dataProvider = "data")
    @Description("7.31 страница Сотрудники, проверка блока 'Фактические отпуска'. Роль Hr")
    public void employeeHrSearchTest(String login, String employee, String addEmployee) {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin(login);
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton(employee);
        authorizationSteps.setPage("DjangoEmployee");
        webActionSteps.clickOnButton(addEmployee);
        authorizationSteps.setPage("DjangoEmployeeChange");
        webActionSteps.clickOnButton("Фактические отпуска");
        employeeCheckSteps.checkBlockedField("Заметка поле");
        webActionSteps.clickOnButton("Скрыть отпуска");
        employeeCheckSteps.checkElementNotVisible("Заметка");
    }

    @Test(dataProvider = "data")
    @Description("7.32 страница Сотрудники, проверка блока 'Больничные'. Роль Hr")
    public void employeeHrSickLeaveTest(String login, String employee, String addEmployee) {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin(login);
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton(employee);
        authorizationSteps.setPage("DjangoEmployee");
        webActionSteps.clickOnButton(addEmployee);
        authorizationSteps.setPage("DjangoEmployeeChange");
        webActionSteps.clickOnButton("Больничные");
        webActionSteps.clickOnButton("Добавить больничный");
        employeeCheckSteps.checkFieldWithoutText("Номер больничного листа");
        webActionSteps.clickOnButton("Скрыть больничный");
        employeeCheckSteps.checkElementNotVisible("Номер больничного листа");
    }

    @Test(dataProvider = "data")
    @Description("7.33 страница Сотрудники, проверка блока 'Бюллетени без больничного листа'. Роль Hr")
    public void employeeHrBulletinWithoutLeaveTest(String login, String employee, String addEmployee) {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin(login);
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton(employee);
        authorizationSteps.setPage("DjangoEmployee");
        webActionSteps.clickOnButton(addEmployee);
        authorizationSteps.setPage("DjangoEmployeeChange");
        webActionSteps.clickOnButton("Бюллетени без больничного листа");
        webActionSteps.clickOnButton("Добавить бюллетень");
        employeeCheckSteps.checkFieldWithoutText("Дата бюллетеня");
        webActionSteps.clickOnButton("Скрыть бюллетень");
        employeeCheckSteps.checkElementNotVisible("Дата бюллетеня");
    }

    @Test(dataProvider = "data")
    @Description("7.34 страница Сотрудники, проверка блока 'Семья'. Роль Hr")
    public void employeeHrFamilyTest(String login, String employee, String addEmployee) {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin(login);
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton(employee);
        authorizationSteps.setPage("DjangoEmployee");
        webActionSteps.clickOnButton(addEmployee);
        authorizationSteps.setPage("DjangoEmployeeChange");
        webActionSteps.clickOnButton("Семья");
        webActionSteps.clickOnButton("Добавить семья");
        employeeCheckSteps.emptyDropDown("Родственная связь");
        webActionSteps.clickOnButton("Скрыть семья");
        employeeCheckSteps.checkElementNotVisible("Родственная связь");
    }
}
