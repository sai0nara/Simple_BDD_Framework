package ts10;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.*;

public class EmployeePageKeyFieldsNegativeTest extends WebHooks {

    private PageManager pageManager = new PageManager();
    private final AuthorizationSteps authorizationSteps = new AuthorizationSteps(pageManager);
    private final WebActionSteps webActionSteps = new WebActionSteps(pageManager);
    private final EmployeeCheckSteps employeeCheckSteps = new EmployeeCheckSteps(pageManager);
    private final EmployeeSteps employeeSteps = new EmployeeSteps(pageManager);

    @DataProvider
    public Object[][] dataErrorMessage() {
        return new Object[][]{
                {"hr", "Сотрудники", "Дата приема на работу", "123qweфыв!", "Сохранить и продолжить редактирование", "Сообщение об ошибке в заголовке", "Пожалуйста, исправьте ошибку ниже.", "Введите правильную дату.", "Сообщение об ошибке Дата приема на работу"},
                {"hr", "Сотрудники", "Телефон", "123qweфыв!", "Сохранить и продолжить редактирование", "Сообщение об ошибке в заголовке", "Пожалуйста, исправьте ошибку ниже.", "Введите корректный номер телефона (пример: +79123456789).", "Сообщение об ошибке Телефон"},
                {"hr", "Сотрудники", "Email", "123qweфыв!", "Сохранить и продолжить редактирование", "Сообщение об ошибке в заголовке", "Пожалуйста, исправьте ошибку ниже.", "Введите корректный адрес электронной почты.", "Сообщение об ошибке Email"}
        };
    }

    @Test
    @Description("10.1 страница Сотрудники, проверить, как отрабатывает система при не заполнении ключевых полей. Роль Hr")
    public void employeeHrEmptyFieldSaveTest() {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin("hr");
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton("Сотрудники");
        authorizationSteps.setPage("DjangoEmployee");
        employeeSteps.clickRandom("ФИО");
        authorizationSteps.setPage("DjangoEmployeeChange");
        employeeSteps.clearFieldsEmployee("Фамилия", "Имя", "Отчество", "Пол", "Дата приема на работу", "День рождения", "Телефон", "Гражданство", "Email");
        webActionSteps.clickOnButton("Сохранить и продолжить редактирование");
        employeeCheckSteps.matchText("Сообщение об ошибке в заголовке", "Пожалуйста, исправьте ошибки ниже.");
        employeeCheckSteps.matchText("Сообщение об ошибке Имя", "Это поле обязательно.");
        employeeCheckSteps.matchText("Сообщение об ошибке Фамилия", "Это поле обязательно.");
        employeeCheckSteps.matchText("Сообщение об ошибке Пол", "Это поле обязательно.");
    }

    @Test
    @Description("10.2 страница Сотрудники, проверка поведения системы при загрузке файла не изображения. Роль Hr")
    public void employeeHrNoPictureFileTest() {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin("hr");
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton("Сотрудники");
        authorizationSteps.setPage("DjangoEmployee");
        employeeSteps.clickRandom("ФИО");
        authorizationSteps.setPage("DjangoEmployeeChange");
        webActionSteps.uploadFiles("Выберите фото", "test.txt");
        webActionSteps.clickOnButton("Сохранить и продолжить редактирование");
        employeeCheckSteps.matchText("Сообщение об ошибке в заголовке", "Пожалуйста, исправьте ошибку ниже.");
        employeeCheckSteps.matchText("Сообщение об ошибке Фото", "Загрузите корректное изображение. Загруженный файл не является изображением, либо является испорченным.");
    }

    @Test(dataProvider = "dataErrorMessage")
    @Description("10.3-10.5 страница Сотрудники, проверка поведения системы при загрузке файла не изображения. Роль Hr")
    public void employeeHrNoValidFielsdDatePhoneEmailTest(String login, String employee, String field, String text, String save, String message, String infoblock, String error, String messageBox) {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin(login);
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton(employee);
        authorizationSteps.setPage("DjangoEmployee");
        employeeSteps.clickRandom("ФИО");
        authorizationSteps.setPage("DjangoEmployeeChange");
        authorizationSteps.fillField(field, text);
        webActionSteps.clickOnButton(save);
        employeeCheckSteps.matchText(message, infoblock);
        employeeCheckSteps.matchText(messageBox, error);
    }

    @Test
    @Description("7.31 страница Сотрудники, проверка блока 'Фактические отпуска'. Роль Hr")
    public void employeeHrSearchTest() {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin("hr");
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton("Сотрудники");
        authorizationSteps.setPage("DjangoEmployee");
        webActionSteps.clickOnButton("Добавить сотрудник");
        authorizationSteps.setPage("DjangoEmployeeChange");
        webActionSteps.clickOnButton("Фактические отпуска");
        employeeCheckSteps.checkBlockedField("Заметка поле");
        webActionSteps.clickOnButton("Скрыть отпуска");
        employeeCheckSteps.checkElementNotVisible("Заметка");
    }
}
