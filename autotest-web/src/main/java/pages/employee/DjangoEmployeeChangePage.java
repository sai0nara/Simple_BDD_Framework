package pages.employee;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.DjangoPagesHeader;
import ru.lanit.at.web.annotations.Name;

import static com.codeborne.selenide.Selenide.*;

@Name(value = "DjangoEmployeeChange")
public class DjangoEmployeeChangePage extends DjangoPagesHeader {

    @Name("Имя")
    private SelenideElement firstName = $("#id_name");
    @Name("Фамилия")
    private SelenideElement lastName = $("#id_surname");
    @Name("Отчество")
    private SelenideElement patronymic = $("#id_patronymic");
    @Name("Пол")
    private SelenideElement dropdownGender = $("#id_gender");
    @Name("Выберите фото")
    private SelenideElement photo = $("#id_photo");
    @Name("Дата приема на работу")
    private SelenideElement joiningDate = $("#id_joining_date");
    @Name("День рождения")
    private SelenideElement birthday = $("#id_birth");
    @Name("Телефон")
    private SelenideElement phone = $("#id_phone");
    @Name("Гражданство")
    private SelenideElement dropdownCitizenship = $("#id_citizenship");
    @Name("Email")
    private SelenideElement email = $("#id_internal_email");

    @Name("Сообщение об ошибке в заголовке")
    private SelenideElement headerError = $(".errornote");
    @Name("Сообщение об ошибке Имя")
    private SelenideElement errorFirstName = $x("//div[contains(@class, 'field-name')]/ul/li");
    @Name("Сообщение об ошибке Фамилия")
    private SelenideElement errorSurname = $x("//div[contains(@class, 'field-surname')]/ul/li");
    @Name("Сообщение об ошибке Пол")
    private SelenideElement errorGender = $x("//div[contains(@class, 'field-gender')]/ul/li");
    @Name("Сообщение об ошибке Дата приема на работу")
    private SelenideElement errorJoiningDate = $x("//div[contains(@class, 'field-joining_date')]/ul/li");
    @Name("Сообщение об ошибке Телефон")
    private SelenideElement errorPhone = $x("//div[contains(@class, 'field-phone')]/ul/li");
    @Name("Сообщение об ошибке Email")
    private SelenideElement errorEmail = $x("//div[contains(@class, 'field-internal_email')]/ul/li");

    @Name("История")
    private SelenideElement history = $x("//a[@class='historylink' and text()='История']");
    @Name("Summary")
    private SelenideElement summary = $x("//a[@class='historylink' and text()='Summary']");

    @Name("Удалено")
    private SelenideElement delete = $(".deletelink");
    @Name("Сохранить и добавать другой объект")
    private SelenideElement saveAndAddAnother = $x("//input[@name='_addanother']");
    @Name("Сохранить и продолжить редактирование")
    private SelenideElement saveAndContinue = $x("//input[@name='_continue']");
    @Name("Сохранить")
    private SelenideElement save = $x("//input[@name='_save']");

    @Name("Name")
    private SelenideElement nameOfHeader = $x("//li[@class='success']/a");

    @Name("Города")
    private SelenideElement cities = $x("//a[@id='fieldsetcollapser11']");
    @Name("Список городов")
    private SelenideElement listOfcities = $x("//select[@name='employeecity_set-0-city']");
    @Name("Дата изменения")
    private SelenideElement dateOfChange = $x("//th[@class='column-change_date required'][1]");
    @Name("Сегодня")
    private ElementsCollection todayCity = $$x("//span[@class='datetimeshortcuts']/a[text()='Сегодня']");

    @Name("Фактические отпуска")
    private SelenideElement actualVacationsShow = $("#employeeactualvacation_set-group fieldset h2 a");
    @Name("Заметка")
    private SelenideElement addActualVacations = $x("//h2[contains(text(), 'Фактические отпуска')]/following-sibling::table//tbody");
    @Name("Скрыть отпуска")
    private SelenideElement hideActualVacations = $x("//h2[contains(text(), 'Фактические отпуска')]/a");

    @Name("Больничные")
    private SelenideElement sickLeaveShow = $("#employeesickleaveofficial_set-group fieldset h2 a");
    @Name("Добавить больничный")
    private SelenideElement addSickLeave = $("#employeesickleaveofficial_set-empty ~ tr td a");
    @Name("Номер больничного листа")
    private SelenideElement numberSickLeave = $(".empty-form .field-notes_number");
    @Name("Скрыть больничный")
    private SelenideElement hideSickLeave = $x("//h2[contains(text(), 'Больничные')]/a");

    @Name("Бюллетени без больничного листа")
    private SelenideElement bulletinWithoutLeaveShow = $("#employeesickleaveunofficial_set-group fieldset h2 a");
    @Name("Добавить бюллетень")
    private SelenideElement addBulletinWithoutLeave = $("#employeesickleaveunofficial_set-empty ~ tr td a");
    @Name("Дата бюллетеня")
    private SelenideElement dateBulletinWithoutLeave = $(".empty-form .field-notes_number");
    @Name("Скрыть бюллетень")
    private SelenideElement hideBulletinWithoutLeave = $x("//h2[contains(text(), 'Семья')]/a");

    @Name("Семья")
    private SelenideElement familyShow = $("#Family-group fieldset h2 a");
    @Name("Добавить семья")
    private SelenideElement addFamily = $("#Family-empty ~ tr td a");
    @Name("Родственная связь")
    private SelenideElement kinship = $(".dynamic-Family select[id*='relationship']");
    @Name("Скрыть семья")
    private SelenideElement hideFamily = $x("//h2[contains(text(), 'Бюллютени без больничного листа')]/a");
}

