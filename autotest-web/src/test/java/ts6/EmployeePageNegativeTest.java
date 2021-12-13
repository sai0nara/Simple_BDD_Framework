package ts6;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.*;

public class EmployeePageNegativeTest extends WebHooks {

    private PageManager pageManager = new PageManager();
    private final WebSteps webSteps = new WebSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);

    @DataProvider
    public Object[][] dataActionField() {
        return new Object[][]{
                {"hr", "Сотрудники", "Действие", "Выполнить", "Предупреждение в заголовке", "Чтобы произвести действия над объектами, необходимо их выбрать. Объекты не были изменены."},
                {"hr", "Сотрудники", "Таблица чек-бокс", "Выполнить", "Предупреждение в заголовке", "Действие не выбрано."}
        };
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"hr", "Сотрудники"}
        };
    }

    @Test(dataProvider = "data")
    @Description("6.1 страница Сотрудники, проверить, ввод в поле 'Поиск' значения ‘<qweфыв!>’. Роль Hr")
    public void employeeHrSearchTest(String login, String employee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webCheckSteps.checkAppearElement("Поиск");
        webSteps.fillField("Поиск", "qweфыв!");
        webSteps.clickOnElement("Найти");
        webCheckSteps.matchRecordsNumber("ФИО", 0);
    }

    @Test(dataProvider = "data")
    @Description("6.2 страница Сотрудники, проверка поведения системы при нажатии на кнопку 'Поиск' с незаполненным в полем поиска. Роль Hr")
    public void employeeHrEmptySearchTest(String login, String employee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webSteps.getElementText("ФИО", 1);
        webCheckSteps.checkElementEquals("Выполнить", "ФИО", 1);
    }

    @Test(dataProvider = "data")
    @Description("6.3 страница Сотрудники, проверка поведения системы при нажатии на 'Выполнить' без выбора сотрудников и незаполненном поле 'Действие'. Роль Hr")
    public void employeeHrEmptyActionEmptyFieldTest(String login, String employee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webCheckSteps.checkAppearElement("Выполнить");
        webSteps.clickOnElement("Выполнить");
        webCheckSteps.matchText("Предупреждение в заголовке", "Чтобы произвести действия над объектами, необходимо их выбрать. Объекты не были изменены.");
    }

    @Test(dataProvider = "dataActionField")
    @Description("6.4-6.5 страница Сотрудники, проверка поведения системы при нажатии на кнопку 'Выполнить' без выбора сотрудников и заполненном поле 'Действие' и при нажатии на кнопку 'Выполнить' при выбранных сотрудниках и не заполненном поле 'Действие'. Роль Hr")
    public void employeeHrEmptyActionFieldTest(String login, String employee, String element, String action, String fieldName, String text) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webSteps.clickRandom(element);
        webCheckSteps.checkAppearElement(action);
        webSteps.clickOnElement(action);
        webCheckSteps.matchText(fieldName, text);
    }

    @Test(dataProvider = "data")
    @Description("6.6 страница Сотрудники, проверка поведения системы при экспорте списка сотрудников через опцию выпадающего списка при не выбранном формате экспортируемого файла. Роль Hr")
    public void employeeHrEmptyActionFieldExportTest(String login, String employee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webSteps.clickRandom("Таблица чек-бокс");
        webSteps.selectElementWithText("Действие меню", "Экспортировать выбранные Сотрудники");
        webCheckSteps.checkAppearElement("Выполнить");
        webSteps.clickOnElement("Выполнить");
        webCheckSteps.matchText("Предупреждение в заголовке", "Необходимо выбрать формат экспорта");
    }
}
