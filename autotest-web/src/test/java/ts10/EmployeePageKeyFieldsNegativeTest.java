package ts10;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

public class EmployeePageKeyFieldsNegativeTest extends WebHooks {

    private PageManager pageManager = new PageManager();
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);
    private final WebSteps webSteps = new WebSteps(pageManager);

    @DataProvider
    public Object[][] dataErrorMessage() {
        return new Object[][]{
                {"hr", "Сотрудники", "Дата приема на работу", "123qweфыв!", "Сохранить и продолжить редактирование", "Сообщение об ошибке в заголовке", "Пожалуйста, исправьте ошибку ниже.", "Введите правильную дату.", "Сообщение об ошибке Дата приема на работу"},
                {"hr", "Сотрудники", "Телефон", "123qweфыв!", "Сохранить и продолжить редактирование", "Сообщение об ошибке в заголовке", "Пожалуйста, исправьте ошибку ниже.", "Введите корректный номер телефона (пример: +79123456789).", "Сообщение об ошибке Телефон"},
                {"hr", "Сотрудники", "Email", "123qweфыв!", "Сохранить и продолжить редактирование", "Сообщение об ошибке в заголовке", "Пожалуйста, исправьте ошибку ниже.", "Введите корректный адрес электронной почты.", "Сообщение об ошибке Email"}
        };
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"hr", "Сотрудники"}
        };
    }

    @Test(dataProvider = "data")
    @Description("10.1 страница Сотрудники, проверить, как отрабатывает система при не заполнении ключевых полей. Роль Hr")
    public void employeeHrEmptyFieldSaveTest(String login, String employee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webSteps.clickRandom("ФИО");
        webSteps.setPage("DjangoEmployeeChange");
        webSteps.clearFieldsEmployee("Фамилия", "Имя", "Отчество", "Пол", "Дата приема на работу", "День рождения", "Телефон", "Гражданство", "Email");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.matchText("Сообщение об ошибке в заголовке", "Пожалуйста, исправьте ошибки ниже.");
        webCheckSteps.matchText("Сообщение об ошибке Имя", "Это поле обязательно.");
        webCheckSteps.matchText("Сообщение об ошибке Фамилия", "Это поле обязательно.");
        webCheckSteps.matchText("Сообщение об ошибке Пол", "Это поле обязательно.");
    }

    @Test(dataProvider = "data")
    @Description("10.2 страница Сотрудники, проверка поведения системы при загрузке файла не изображения. Роль Hr")
    public void employeeHrNoPictureFileTest(String login, String employee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webSteps.clickRandom("ФИО");
        webSteps.setPage("DjangoEmployeeChange");
        webSteps.uploadFiles("Выберите фото", "test.txt");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.matchText("Сообщение об ошибке в заголовке", "Пожалуйста, исправьте ошибку ниже.");
        webCheckSteps.matchText("Сообщение об ошибке Фото", "Загрузите корректное изображение. Загруженный файл не является изображением, либо является испорченным.");
    }

    @Test(dataProvider = "dataErrorMessage")
    @Description("10.3-10.5 страница Сотрудники, проверка поведения системы при загрузке файла не изображения. Роль Hr")
    public void employeeHrNoValidFielsdDatePhoneEmailTest(String login, String employee, String field, String text, String save, String message, String infoblock, String error, String messageBox) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webSteps.clickRandom("ФИО");
        webSteps.setPage("DjangoEmployeeChange");
        webSteps.fillField(field, text);
        webSteps.clickOnElement(save);
        webCheckSteps.matchText(message, infoblock);
        webCheckSteps.matchText(messageBox, error);
    }

    @Test(dataProvider = "data")
    @Description("10.6 страница Сотрудники, проверка блока 'Фактические отпуска'. Роль Hr")
    public void employeeHrSearchTest(String login, String employee) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement(employee);
        webSteps.setPage("DjangoEmployee");
        webSteps.clickOnElement("Добавить сотрудник");
        webSteps.setPage("DjangoEmployeeChange");
        webSteps.clickOnElement("Фактические отпуска");
        webCheckSteps.checkFieldWithoutText("Заметка поле");
        webSteps.clickOnElement("Скрыть отпуска");
        webCheckSteps.checkElementNotVisible("Заметка");
    }
}
