package ts7;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.*;

public class AddingEmployeePositiveTest extends WebHooks {
    private final PageManager pageManager = new PageManager();

    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);
    private final WebSteps webSteps = new WebSteps(pageManager);

    private void initialize() {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("hr");
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement("Сотрудники");
        webSteps.setPage("DjangoEmployee");
        webSteps.clickOnElement("Добавить сотрудник");
        webSteps.setPage("DjangoEmployeeChange");
    }

    @Test
    @Description("7.1. Блок \"Общая информация\", проверка заполняемости ключевых полей")
    public void checkAddingNewEmployee() {
        initialize();

        webSteps.fillField("Фамилия", "Иванов");
        webSteps.fillField("Имя", "Иван");
        webSteps.fillField("Отчество", "Иванович");
        webSteps.selectElementInDropDown("Пол", "Male");
        webSteps.clickOnElement("Сохранить");
        webSteps.setPage("DjangoEmployee");
        webCheckSteps.matchText("Сообщение об успешном редактирование", "The Сотрудник “Иванов Иван” was added successfully.");
    }

    @Test
    @Description("7.2. Блок \"Общая информация\", проверка работоспособности загрузки файла изображения")
    public void checkPerformanceUploadingFIleImage() {
        initialize();

        String nameOfImage = "test.jpg";
        webSteps.uploadFiles("Выберите фото", nameOfImage);
        webCheckSteps.checkNameOfUploadedImage("Выберите фото", nameOfImage);
    }

    @Test
    @Description("7.3. Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата приема на работу\" через виджет \"Календарь\"")
    public void checkEmploymentDateByCalendar() {
        initialize();

        webSteps.clickOnElement("Выберите дату");
        webSteps.clickOnElement("Случайное число для выборки календаря - Дата приема на работу");
        webCheckSteps.checkFieldTextIsNotEmpty("Дата приема на работу");
    }

    @Test
    @Description("7.4. Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата приема на работу\" через ввод с клавиатуры")
    public void checkEmploymentDateByKeyboard() {
        initialize();

        webSteps.clearField("Дата приема на работу");
        webSteps.fillField("Дата приема на работу", "18.11.2021");
        webCheckSteps.matchTextByValue("Дата приема на работу", "18.11.2021");
    }

    @Test
    @Description("7.5. Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата приема на работу\" через нажатие кнопки \"Сегодня\"")
    public void checkEmploymentDateByClickToday() {
        initialize();

        webSteps.clearField("Дата приема на работу");
        webSteps.clickOnElement("Сегодня рядом 'Дата приема на работу'");
        webCheckSteps.checkFieldTextIsNotEmpty("Дата приема на работу");
        webCheckSteps.checkFieldTextByDateToday("Дата приема на работу",
                webSteps.initializeTodayDate());
    }

    @Test
    @Description("7.6. Блок \"Общая информация\", проверка заполняемости поля \"Телефон\"")
    public void checkTelephone() {
        initialize();

        webSteps.fillField("Телефон", "+79123456789");
        webCheckSteps.matchTextByValue("Телефон", "+79123456789");
    }


    @Test
    @Description("7.7. Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата рождения\" через виджет \"Календарь\"")
    public void checkBirthdayByCalendar() {
        initialize();

        webSteps.clickOnElement("Выберите дату в поле 'День рождения'");
        webSteps.clickOnElement("Случайное число для выборки календаря - День рождения");
        webCheckSteps.checkFieldTextIsNotEmpty("День рождения");
    }

    @Test
    @Description("7.8. Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата рождения\" через ввод с клавиатуры")
    public void checkBirthdayByKeyboard() {
        initialize();

        webSteps.clearField("День рождения");
        webCheckSteps.matchText("День рождения", "");
        webSteps.fillField("День рождения", "18.11.2021");
    }

    @Test
    @Description("7.9. Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата рождения\" через нажатие кнопки \"Сегодня\"")
    public void checkBirthdayByClickToday() {
        initialize();

        webSteps.clearField("День рождения");
        webSteps.clickOnElement("Сегодня рядом с полем 'День рождения'");
        webCheckSteps.checkFieldTextIsNotEmpty("День рождения");
        webCheckSteps.checkFieldTextByDateToday("День рождения",
                webSteps.initializeTodayDate());
    }

    @Test
    @Description("7.10. Блок \"Общая информация\", проверка заполняемости поля \"Гражданство\"")
    public void checkCitizenship() {
        initialize();

        webCheckSteps.checkReadOnly("Изменить выбранный объект типа Гражданство", "<href>");
        webCheckSteps.checkReadOnly("Удалить выбранный объект типа Гражданство", "<href>");
        webSteps.listSelectRandElement("Гражданство");
        webCheckSteps.checkElementIsRead("Изменить выбранный объект типа Гражданство");
        webCheckSteps.checkElementIsRead("Удалить выбранный объект типа Гражданство");
    }

    @Test
    @Description("7.16. Блок \"Навыки\", проверка заполняемости")
    public void checkFillingOfSkills() {
        initialize();

        webSteps.clickOnElement("Показать Навыки");
        webSteps.activeCheckbox("Список навыков", "Языки программирования: Golang");
        webSteps.activeCheckbox("Список навыков", "Языки программирования: PHP");
        webSteps.activeCheckbox("Список навыков", "Фреймворки АТ: TestNG");
        webSteps.clickOnElement("Скрыть Навыки");
        webCheckSteps.elementAbsentOnPage("Языки программирования: C# 5.0");
    }

    // TODO: 20.12.2021 (7.17) Ожидаем появления кнопки
    //    Проверка работоспособности кнопки
    //    "Добавить ещё один объект типа" --- Отложить до появления кнопки
    /*@Test
    @Description("EMPTY TEST (expect developer's button) " +
            "7.17. Блок \"Квалификация\", проверка работоспособности кнопки")
    public void checkButtonOfQualification() {
        initialize();

        webSteps.clickOnElement("Показать Навыки");
        webSteps.clickOnElement(Future xpath of the button(+ Добавить еще один объект типа));
    }*/

    @Test
    @Description("7.18. Блок \"Сертификаты\", проверка заполняемости")
    public void checkFillingOfCertificates() {
        initialize();

        webSteps.clickOnElement("Показать Сертификаты");
        webSteps.fillFieldRandomString("Сертификаты:");
        webSteps.fillFieldRandomString("Курсы");
        webSteps.clickOnElement("Скрыть Сертификаты");
        webCheckSteps.elementAbsentOnPage("Сертификаты:");
    }

    @Test
    @Description("7.19. блок \"Статус сотрудника\", проверка заполняемости")
    public void checkFillingOfStatusOfEmployee() {
        initialize();

        webSteps.clickOnElement("Показать Статус сотрудника");
        webSteps.activeCheckbox("Список статусов сотрудников", "В декретном отпуске");
        webSteps.activeCheckbox("Список статусов сотрудников", "Внешний совместитель");
        webSteps.clickOnElement("Скрыть Статус сотрудника");
        webCheckSteps.elementAbsentOnPage("Работает");
    }

    @Test
    @Description("7.20. Блок \"ОБРАЗОВАНИЯ\", проверка заполняемости")
    public void checkFillingOfEducation() {
        initialize();

        webSteps.clickOnElement("Показать ОБРАЗОВАНИЯ");
        webSteps.clickOnElement("Добавить еще один Образование");
        webCheckSteps.checkReadOnly("Изменить выбранный объект типа ВУЗ", "<href>");
        webSteps.listSelectRandElement("ВУЗ");
        webCheckSteps.checkElementIsNotReadOnly("Изменить выбранный объект типа ВУЗ", "<href>");
        webSteps.listSelectRandElement("УРОВЕНЬ ОБРАЗОВАНИЯ");
        webCheckSteps.checkElementIsNotReadOnly("Изменить выбранный объект типа УРОВЕНЬ ОБРАЗОВАНИЯ",
                "<href>");
        webSteps.listSelectRandElement("СПЕЦИАЛЬНОСТЬ");
        webCheckSteps.checkElementIsNotReadOnly("Изменить выбранный объект типа СПЕЦИАЛЬНОСТЬ", "<href>");
        webSteps.fillField("ДАТА НАЧАЛА", "01.01.2001");
        webSteps.fillField("ДАТА ОКОНЧАНИЯ", "01.01.2021");
        webSteps.clickOnElement("Скрыть ОБРАЗОВАНИЯ");
        webCheckSteps.elementAbsentOnPage("ВУЗ");
    }
}