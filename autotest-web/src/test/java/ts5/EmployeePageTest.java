package ts5;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.*;

public class EmployeePageTest extends WebHooks {

    private PageManager pageManager = new PageManager();
    private final WebSteps webSteps = new WebSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"hr", "Сотрудники"}
        };
    }

    @Test(dataProvider = "data")
    @Description("5.6 страница Сотрудники, проверка работотоспособности кнопок пагинации. Роль Hr")
    public void employeeHrPaginationTest(String login, String employee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webSteps.getElementText("ФИО", 1);
        webSteps.clickOnElementWithText("Пагинация", "2");
        webCheckSteps.checkCurrentNumber("Пагинация текущая страница", "2");
        webCheckSteps.checkElementNoEquals(1, "ФИО");
    }

    @Test(dataProvider = "data")
    @Description("5.7 страница Сотрудники, проверка работотоспособности восстановления удаленных сотрудников. Роль Hr")
    public void employeeHrRestoreTest(String login, String employee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webSteps.getElementText("ФИО", 1);
        webSteps.clickOnElementWithText("Пагинация", "2");
        webCheckSteps.checkCurrentNumber("Пагинация текущая страница", "2");
        webCheckSteps.checkElementNoEquals(1, "ФИО");
    }

    @Test(dataProvider = "data")
    @Description("5.9 страница Сотрудники, проверка работотоспособности экспорта списка сотрудников через кнопку интерфейса. Роль Hr")
    public void employeeHrExportTest(String login, String employee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployeeChange");
        webCheckSteps.checkAppearElement("Экспорт");
        webSteps.clickOnElement("Экспорт");
        webSteps.setPage("DjangoExportEmployee");
        webCheckSteps.matchText("Инфоблок", "Экспорт");
        webCheckSteps.checkAppearElement("Формат");
        webCheckSteps.checkElementVisibleCollection("Чекбокс", "Договор");
        webCheckSteps.checkAppearElement("Отправить");
    }

    @Test(dataProvider = "data")
    @Description("5.10 страница Сотрудники, проверка работотоспособности кнопки добавления нового сотрудника. Роль Hr")
    public void employeeHrAddNewEmployeeTest(String login, String employee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployeeChange");
        webCheckSteps.checkAppearElement("Добавить сотрудник");
        webSteps.clickOnElement("Добавить сотрудник");
        webSteps.setPage("DjangoExportEmployee");
        webCheckSteps.matchText("Инфоблок", "Добавить Сотрудник");
    }

    @Test(dataProvider = "data")
    @Description("5.11 страница Сотрудники, проверка работотоспособности фильтров. Роль Hr")
    public void employeeHrFiltersTest(String login, String employee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployeeChange");
        webSteps.clickOnElementWithText("Категории фильтров", "Офис");
        webSteps.clickOnElementWithText("Фильтр", "Пенза");
        webCheckSteps.checkCurrentNumberCity("Текущий город", "Пенза");
    }
}
