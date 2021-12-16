package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.*;

@Name(value = "DjangoAdministration")
public class DjangoAdministrationPage extends WebPage {

    @Name("Заголовок таблицы")
    private SelenideElement tableHeader = $x("//div[@id='content']/h1");

    @Name("Изменить пароль")
    SelenideElement changePassword = $x("//a[@href='/admin/password_change/']");
    @Name("Выйти")
    SelenideElement logout = $x("//div[@id='user-tools']/a[@href='/admin/logout/']");
    @Name("Администрирование Django")
    private SelenideElement headerPage = $x("//a[@href='/admin/']");


    //MAIN
    @Name("Сотрудники")
    private SelenideElement employee = $x("//tr[@class='model-employee']/th/a");
    @Name("Добавить поле Сотрудники")
    private SelenideElement addEmployee = $x("//a[@href='/admin/core/employee/add/']");
    @Name("Изменить поле Сотрудники")
    private SelenideElement changeEmployee = $x("//a[@href='/admin/core/employee/' and @class='changelink']");

    @Name("Администраторы аккаунта")
    private SelenideElement accountadmin = $x("//tr[@class='model-accountadmin']//a[text()='Администраторы аккаунта']");
    @Name("Администраторы аккаунта_Добавить")
    private SelenideElement accountadminAdd = $x("//tr[@class='model-accountadmin']//a[@class='addlink']");
    @Name("Администраторы аккаунта_Изменить")
    private SelenideElement accountadminChange = $x("//tr[@class='model-accountadmin']//a[@class='changelink']");

    @Name("Запросы на отпуск")
    private SelenideElement employeeVacationRequest = $x("//tr[@class='model-employeevacationrequest']//a[text()='Запросы на отпуск']");
    @Name("Запросы на отпуск_Добавить")
    private SelenideElement employeeVacationRequestAdd = $x("//tr[@class='model-employeevacationrequest']//a[@class='addlink']");
    @Name("Запросы на отпуск_Изменить")
    private SelenideElement employeeVacationRequestChange = $x("//tr[@class='model-employeevacationrequest']//a[@class='changelink']");

    @Name("Фактические отпуска")
    private SelenideElement employeeActualVacation= $x("//tr[@class='model-employeeactualvacation']//a[text()='Фактические отпуска']");
    @Name("Фактические отпуска_Добавить")
    private SelenideElement employeeActualVacationAdd= $x("//tr[@class='model-employeeactualvacation']//a[@class='addlink']");
    @Name("Фактические отпуска_Изменить")
    private SelenideElement employeeActualVacationChange= $x("//tr[@class='model-employeeactualvacation']//a[@class='changelink']");

    @Name("Больничные")
    private SelenideElement employeeSickLeaveOfficial = $x("//tr[@class='model-employeesickleaveofficial']//a[text()='Больничные']");
    @Name("Больничные_Добавить")
    private SelenideElement employeeSickLeaveOfficialAdd = $x("//tr[@class='model-employeesickleaveofficial']//a[@class='addlink']");
    @Name("Больничные_Изменить")
    private SelenideElement employeeSickLeaveOfficialChange = $x("//tr[@class='model-employeesickleaveofficial']//a[@class='changelink']");

    @Name("Бюллютени без больничного листа")
    private SelenideElement employeeSickLeaveUnofficial = $x("//tr[@class='model-employeesickleaveunofficial']//a[text()='Бюллютени без больничного листа']");
    @Name("Бюллютени без больничного листа_Добавить")
    private SelenideElement employeeSickLeaveUnofficialAdd = $x("//tr[@class='model-employeesickleaveunofficial']//a[@class='addlink']");
    @Name("Бюллютени без больничного листа_Изменить")
    private SelenideElement employeeSickLeaveUnofficialChange = $x("//tr[@class='model-employeesickleaveunofficial']//a[@class='changelink']");

    @Name("Проектные ставки")
    private SelenideElement employeeProjectSalaryRate = $x("//a[text()='Проектные ставки']");
    @Name("Проектные ставки_Добавить")
    private SelenideElement employeeProjectSalaryRateAdd = $x("//tr[@class='model-employeeprojectsalaryrate']//a[@class='addlink']");
    @Name("Проектные ставки_Изменить")
    private SelenideElement employeeProjectSalaryRateChange = $x("//tr[@class='model-employeeprojectsalaryrate']//a[@class='changelink']");

    //ACCOUNTS
    @Name("Аккаунты")
    private SelenideElement account = $x("//a[text()='Аккаунты']");
    @Name("Проекты")
    private SelenideElement project = $x("//a[text()='Проекты']");

    //STRUCTURE
    @Name("Департаменты")
    private SelenideElement department = $x("//a[text()='Департаменты']");
    @Name("Должности")
    private SelenideElement position = $x("//a[text()='Должности']");
    @Name("Проектные роли")
    private SelenideElement projectRole = $x("//a[text()='Проектные роли']");
    @Name("Типы тестирования")
    private SelenideElement testingType = $x("//a[text()='Типы тестирования']");

    //DICTIONARY
    @Name("Города")
    private SelenideElement city = $x("//a[text()='Города']");
    @Name("Гражданства")
    private SelenideElement citizenship = $x("//a[text()='Гражданства']");
    @Name("ВУЗы")
    private SelenideElement educationInstitution = $x("//a[text()='ВУЗы']");
    @Name("Достижения")
    private SelenideElement achievement = $x("//a[text()='Достижения']");
    @Name("Должности в сторонних организациях")
    private SelenideElement outsideRole = $x("//a[text()='Должности в сторонних организациях']");
    @Name("Иностранные языки")
    private SelenideElement language = $x("//a[text()='Иностранные языки']");
    @Name("Названия организации")
    private SelenideElement organisation = $x("//a[text()='Названия организации']");
    @Name("Образования")
    private SelenideElement education = $x("//a[text()='Образования']");
    @Name("Показатели квалификации")
    private SelenideElement qualificationSkills = $x("//a[text()='Показатели квалификации']");
    @Name("Специальности (ВУЗ)")
    private SelenideElement educationSpecialty = $x("//a[text()='Специальности (ВУЗ)']");
    @Name("Сторонние организации")
    private SelenideElement outsideOrganisation = $x("//a[text()='Сторонние организации']");
    @Name("Типы навыков")
    private SelenideElement keySkillType = $x("//a[text()='Типы навыков']");
    @Name("Типы квалификации")
    private SelenideElement qualificationSkillType = $x("//a[text()='Типы квалификации']");
    @Name("Уровни знания иностранного языка")
    private SelenideElement languageKnowledgeLevel = $x("//a[text()='Уровни знания иностранного языка']");
    @Name("Статусы запроса на отпуск")
    private SelenideElement vacationRequestStatus = $x("//a[text()='Статусы запроса на отпуск']");
    @Name("Тип родства")
    private SelenideElement familyType = $x("//a[text()='Тип родства']");

    //ADMINISTRATIVE ACCESS
    @Name("Сотрудники с административным доступом")
    private SelenideElement administrator = $x("//a[text()='Сотрудники с административным доступом']");
    @Name("Сотрудники с административным доступом_Изменить")
    private SelenideElement administratorChange = $x("//tr[@class='model-administrator']//a[@class='changelink']");

    //Пользователи и группы
    @Name("Модели в приложении Пользователи и группы")
    private SelenideElement enployeesAndGroupes = $x("//tr[@class='model-group']");

    //Otp_Totp
    @Name("Модели в приложении Otp_Totp")
    private SelenideElement otpTotr = $x("//tr[@class='model-totpdevice']");





}
