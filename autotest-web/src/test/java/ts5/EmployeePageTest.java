package ts5;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.*;

public class EmployeePageTest extends WebHooks {

    private PageManager pageManager = new PageManager();
    private final AuthorizationSteps authorizationSteps = new AuthorizationSteps(pageManager);
    private final WebActionSteps webActionSteps = new WebActionSteps(pageManager);
    private final EmployeeCheckSteps employeeCheckSteps = new EmployeeCheckSteps(pageManager);
    private final EmployeeSteps employeeSteps = new EmployeeSteps(pageManager);
    private final AuthorizationCheckSteps authorizationCheckSteps = new AuthorizationCheckSteps(pageManager);

    @Test
    @Description("5.6 страница Сотрудники, проверка работотоспособности кнопок пагинации. Роль Hr")
    public void employeeHrPaginationTest() {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin("hr");
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton("Сотрудники");
        authorizationSteps.setPage("DjangoEmployeeChange");
        employeeCheckSteps.getElementText("ФИО", 1);
        employeeSteps.clickOnElementWithText("Пагинация", "2");
        employeeCheckSteps.checkCurrentNumber("Пагинация текущая страница", "2");
        employeeCheckSteps.checkElementNoEquals(1, "ФИО");
    }

    @Test
    @Description("5.7 страница Сотрудники, проверка работотоспособности восстановления удаленных сотрудников. Роль Hr")
    public void employeeHrRestoreTest() {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin("hr");
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton("Сотрудники");
        authorizationSteps.setPage("DjangoEmployeeChange");
        employeeCheckSteps.getElementText("ФИО", 1);
        employeeSteps.clickOnElementWithText("Пагинация", "2");
        employeeCheckSteps.checkCurrentNumber("Пагинация текущая страница", "2");
        employeeCheckSteps.checkElementNoEquals(1, "ФИО");
    }

    @Test
    @Description("5.9 страница Сотрудники, проверка работотоспособности экспорта списка сотрудников через кнопку интерфейса. Роль Hr")
    public void employeeHrExportTest() {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin("hr");
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton("Сотрудники");
        authorizationSteps.setPage("DjangoEmployeeChange");
        authorizationCheckSteps.checkAppearElement("Экспорт");
        webActionSteps.clickOnButton("Экспорт");
        authorizationSteps.setPage("DjangoExportEmployee");
        employeeCheckSteps.matchText("Инфоблок", "Экспорт");
        employeeCheckSteps.curFieldsContainsThatElement("Формат");
        employeeCheckSteps.checkElementVisibleCollection("Чекбокс", "Договор");
        employeeCheckSteps.curFieldsContainsThatElement("Отправить");
    }

    @Test
    @Description("5.10 страница Сотрудники, проверка работотоспособности кнопки добавления нового сотрудника. Роль Hr")
    public void employeeHrAddNewEmployeeTest() {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin("hr");
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton("Сотрудники");
        authorizationSteps.setPage("DjangoEmployeeChange");
        authorizationCheckSteps.checkAppearElement("Добавить сотрудник");
        webActionSteps.clickOnButton("Добавить сотрудник");
        authorizationSteps.setPage("DjangoExportEmployee");
        employeeCheckSteps.matchText("Инфоблок", "Добавить Сотрудник");
    }

    @Test
    @Description("5.11 страница Сотрудники, проверка работотоспособности фильтров. Роль Hr")
    public void employeeHrFiltersTest() {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin("hr");
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton("Сотрудники");
        authorizationSteps.setPage("DjangoEmployeeChange");
        employeeSteps.clickOnElementWithText("Категории фильтров", "Офис");
        employeeSteps.clickOnElementWithText("Фильтр", "Пенза");
        employeeCheckSteps.checkCurrentNumberCity("Текущий город", "Пенза");
    }
}
