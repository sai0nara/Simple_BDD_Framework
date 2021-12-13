package ts7;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.*;

public class AddingEmployeePositiveTest extends WebHooks {
    private final PageManager pageManager = new PageManager();

    private final AuthorizationSteps authorizationSteps = new AuthorizationSteps(pageManager);
    private final AuthorizationCheckSteps authorizationCheckSteps = new AuthorizationCheckSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);
    private final WebActionSteps webActionSteps = new WebActionSteps(pageManager);
    private final EmployeeCheckSteps employeeCheckSteps = new EmployeeCheckSteps(pageManager);

    private void initialize() {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin("hr");
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton("Сотрудники");
        authorizationSteps.setPage("DjangoEmployee");
        webActionSteps.clickOnButton("Добавить сотрудник");
        authorizationSteps.setPage("DjangoEmployeeChange");
    }

    @Test(priority = 1)
    @Description("Блок \"Общая информация\", проверка заполняемости ключевых полей")
    public void checkAddingNewEmployee() {
        initialize();

        webActionSteps.fillTheField("Фамилия", "Иванов");
        webActionSteps.fillTheField("Имя", "Иван");
        webActionSteps.fillTheField("Отчество", "Иванович");
        webActionSteps.listSelectElement("Пол", "Male");
        webActionSteps.clickOnButton("Сохранить");
        authorizationSteps.setPage("DjangoEmployee");
        employeeCheckSteps.matchText("Сообщение об успешном редактирование", "The Сотрудник “Иванов Иван” was added successfully.");
    }

    @Test(priority = 2)
    @Description("Блок \"Общая информация\", проверка работоспособности загрузки файла изображения")
    public void checkPerformanceUploadingFIleImage() {
        initialize();

        String nameOfImage = "test.jpg";
        webActionSteps.uploadFiles("Выберите фото", nameOfImage);
        webCheckSteps.checkNameOfUploadedImage("Проверка имени фото", nameOfImage);
    }

    @Test(priority = 3)
    @Description("Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата приема на работу\" через виджет \"Календарь\"")
    public void checkEmploymentDateByCalendar() {
        initialize();

        webActionSteps.clickOnButton("Выберите дату");
        webActionSteps.clickOnButton("Случайное число для выборки календаря - Дата приема на работу");
        webCheckSteps.checkFieldTextIsNotEmpty("Дата приема на работу");
    }

    @Test(priority = 4)
    @Description("Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата приема на работу\" через ввод с клавиатуры")
    public void checkEmploymentDateByKeyboard() {
        initialize();

        webActionSteps.clearField("Дата приема на работу");
        webActionSteps.fillTheField("Дата приема на работу", "18.11.2021");
    }

    @Test(priority = 5)
    @Description("Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата приема на работу\" через нажатие кнопки \"Сегодня\"")
    public void checkEmploymentDateByClickToday() {
        initialize();

        webActionSteps.clearField("Дата приема на работу");
        webActionSteps.clickOnButton("Сегодня рядом 'Дата приема на работу'");
        webCheckSteps.checkFieldTextIsNotEmpty("Дата приема на работу");
        webCheckSteps.checkFieldTextByDateToday("Дата приема на работу",
                webActionSteps.initializeTodayDate());
    }

    @Test(priority = 6)
    @Description("Блок \"Общая информация\", проверка заполняемости поля \"Телефон\"")
    public void checkTelephone() {
        initialize();

        webActionSteps.fillTheField("Телефон", "+79123456789");
    }


    @Test(priority = 7)
    @Description("Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата рождения\" через виджет \"Календарь\"")
    public void checkBirthdayByCalendar() {
        initialize();

        webActionSteps.clickOnButton("Выберите дату в поле 'День рождения'");
        webActionSteps.clickOnButton("Случайное число для выборки календаря - День рождения");
        webCheckSteps.checkFieldTextIsNotEmpty("День рождения");
    }

    @Test(priority = 8)
    @Description("Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата рождения\" через ввод с клавиатуры")
    public void checkBirthdayByKeyboard() {
        initialize();

        webActionSteps.clearField("День рождения");
        authorizationCheckSteps.matchText("День рождения", "");
        webActionSteps.fillTheField("День рождения", "18.11.2021");
    }

    @Test(priority = 9)
    @Description("Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата рождения\" через нажатие кнопки \"Сегодня\"")
    public void checkBirthdayByClickToday() {
        initialize();

        webActionSteps.clearField("День рождения");
        webActionSteps.clickOnButton("Сегодня рядом с полем 'День рождения'");
        webCheckSteps.checkFieldTextIsNotEmpty("День рождения");
        webCheckSteps.checkFieldTextByDateToday("День рождения",
                webActionSteps.initializeTodayDate());
    }

    @Test(priority = 10)
    @Description("Блок \"Общая информация\", проверка заполняемости поля \"Гражданство\"")
    public void checkCitizenship() {
        initialize();

        webCheckSteps.checkReadOnly("Изменить выбранный объект типа Гражданство", "<href>");
        webCheckSteps.checkReadOnly("Удалить выбранный объект типа Гражданство", "<href>");
        webActionSteps.listSelectRandElement("Гражданство");
        webCheckSteps.checkElementIsNotReadOnly("Изменить выбранный объект типа Гражданство", "<href>");
        webCheckSteps.checkElementIsNotReadOnly("Удалить выбранный объект типа Гражданство", "<href>");
    }
}
