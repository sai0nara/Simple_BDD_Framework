package ts7;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.*;

public class AddEmployeePageTest extends WebHooks {

    private PageManager pageManager = new PageManager();
    private final WebSteps webSteps = new WebSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"hr", "Сотрудники", "Добавить сотрудник"}
        };
    }

    @Test(dataProvider = "data")
    @Description("7.31 страница Сотрудники, проверка блока 'Фактические отпуска'. Роль Hr")
    public void employeeHrSearchTest(String login, String employee, String addEmployee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webSteps.clickOnElement(addEmployee);
        webSteps.setPage("DjangoEmployeeChange");
        webSteps.clickOnElement("Фактические отпуска");
        webCheckSteps.checkFieldWithoutText("Заметка поле");
        webSteps.clickOnElement("Скрыть отпуска");
        webCheckSteps.checkElementNotVisible("Заметка");
    }

    @Test(dataProvider = "data")
    @Description("7.32 страница Сотрудники, проверка блока 'Больничные'. Роль Hr")
    public void employeeHrSickLeaveTest(String login, String employee, String addEmployee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webSteps.clickOnElement(addEmployee);
        webSteps.setPage("DjangoEmployeeChange");
        webSteps.clickOnElement("Больничные");
        webSteps.clickOnElement("Добавить больничный");
        webCheckSteps.checkFieldWithoutText("Номер больничного листа");
        webSteps.clickOnElement("Скрыть больничный");
        webCheckSteps.checkElementNotVisible("Номер больничного листа");
    }

    @Test(dataProvider = "data")
    @Description("7.33 страница Сотрудники, проверка блока 'Бюллетени без больничного листа'. Роль Hr")
    public void employeeHrBulletinWithoutLeaveTest(String login, String employee, String addEmployee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webSteps.clickOnElement(addEmployee);
        webSteps.setPage("DjangoEmployeeChange");
        webSteps.clickOnElement("Бюллетени без больничного листа");
        webSteps.clickOnElement("Добавить бюллетень");
        webCheckSteps.checkFieldWithoutText("Дата бюллетеня");
        webSteps.clickOnElement("Скрыть бюллетень");
        webCheckSteps.checkElementNotVisible("Дата бюллетеня");
    }

    @Test(dataProvider = "data")
    @Description("7.34 страница Сотрудники, проверка блока 'Семья'. Роль Hr")
    public void employeeHrFamilyTest(String login, String employee, String addEmployee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webSteps.clickOnElement(addEmployee);
        webSteps.setPage("DjangoEmployeeChange");
        webSteps.clickOnElement("Семья");
        webSteps.clickOnElement("Добавить семья");
        webCheckSteps.emptyDropDown("Родственная связь");
        webSteps.clickOnElement("Скрыть семья");
        webCheckSteps.checkElementNotVisible("Родственная связь");
    }
}
