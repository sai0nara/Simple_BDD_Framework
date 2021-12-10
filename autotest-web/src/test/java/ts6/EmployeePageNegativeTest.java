package ts6;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.*;

public class EmployeePageNegativeTest extends WebHooks {

    private PageManager pageManager = new PageManager();
    private final AuthorizationSteps authorizationSteps = new AuthorizationSteps(pageManager);
    private final WebActionSteps webActionSteps = new WebActionSteps(pageManager);
    private final EmployeeCheckSteps employeeCheckSteps = new EmployeeCheckSteps(pageManager);
    private final EmployeeSteps employeeSteps = new EmployeeSteps(pageManager);
    private final AuthorizationCheckSteps authorizationCheckSteps = new AuthorizationCheckSteps(pageManager);

    @DataProvider
    public Object[][] dataActionField() {
        return new Object[][]{
                {"hr", "Сотрудники", "Действие", "Выполнить", "Предупреждение в заголовке", "Чтобы произвести действия над объектами, необходимо их выбрать. Объекты не были изменены."},
                {"hr", "Сотрудники", "Таблица чек-бокс", "Выполнить", "Предупреждение в заголовке", "Действие не выбрано."}
        };
    }

    @Test
    @Description("6.1 страница Сотрудники, проверить, ввод в поле 'Поиск' значения ‘<qweфыв!>’. Роль Hr")
    public void employeeHrSearchTest() {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin("hr");
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton("Сотрудники");
        authorizationSteps.setPage("DjangoEmployeeChange");
        authorizationCheckSteps.checkAppearElement("Поиск");
        authorizationSteps.fillField("Поиск", "qweфыв!");
        webActionSteps.clickOnButton("Найти");
        employeeCheckSteps.matchRecordsNumber("ФИО", 0);
    }

    @Test
    @Description("6.2 страница Сотрудники, проверка поведения системы при нажатии на кнопку 'Поиск' с незаполненным в полем поиска. Роль Hr")
    public void employeeHrEmptySearchTest() {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin("hr");
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton("Сотрудники");
        authorizationSteps.setPage("DjangoEmployeeChange");
        employeeCheckSteps.getElementText("ФИО", 1);
        employeeCheckSteps.checkElementEquals("Выполнить", "ФИО", 1);
    }

    @Test
    @Description("6.3 страница Сотрудники, проверка поведения системы при нажатии на 'Выполнить' без выбора сотрудников и незаполненном поле 'Действие'. Роль Hr")
    public void employeeHrEmptyActionEmptyFieldTest() {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin("hr");
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton("Сотрудники");
        authorizationSteps.setPage("DjangoEmployeeChange");
        authorizationCheckSteps.checkAppearElement("Выполнить");
        webActionSteps.clickOnButton("Выполнить");
        employeeCheckSteps.matchText("Предупреждение в заголовке", "Чтобы произвести действия над объектами, необходимо их выбрать. Объекты не были изменены.");
    }

    @Test(dataProvider = "dataActionField")
    @Description("6.4-6.5 страница Сотрудники, проверка поведения системы при нажатии на кнопку 'Выполнить' без выбора сотрудников и заполненном поле 'Действие' и при нажатии на кнопку 'Выполнить' при выбранных сотрудниках и не заполненном поле 'Действие'. Роль Hr")
    public void employeeHrEmptyActionFieldTest(String login, String employee, String element, String action, String fieldName, String text) {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin(login);
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton(employee);
        authorizationSteps.setPage("DjangoEmployeeChange");
        employeeSteps.clickRandom(element);
        authorizationCheckSteps.checkAppearElement(action);
        webActionSteps.clickOnButton(action);
        employeeCheckSteps.matchText(fieldName, text);
    }

    @Test
    @Description("6.6 страница Сотрудники, проверка поведения системы при экспорте списка сотрудников через опцию выпадающего списка при не выбранном формате экспортируемого файла. Роль Hr")
    public void employeeHrEmptyActionFieldExportTest() {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin("hr");
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton("Сотрудники");
        authorizationSteps.setPage("DjangoEmployeeChange");
        employeeSteps.clickRandom("Таблица чек-бокс");
        employeeSteps.selectElementWithText("Действие меню", "Экспортировать выбранные Сотрудники");
        authorizationCheckSteps.checkAppearElement("Выполнить");
        webActionSteps.clickOnButton("Выполнить");
        employeeCheckSteps.matchText("Предупреждение в заголовке", "Необходимо выбрать формат экспорта");
    }
}
