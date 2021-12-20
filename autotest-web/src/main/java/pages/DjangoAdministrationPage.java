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
    @Name("Войти снова")
    SelenideElement loginAgain = $x("//div[@id=\"content\"]/p[2]/a");

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
    private SelenideElement employeeProjectSalaryRate = $x("//tr[@class='model-employeeprojectsalaryrate']//a[text()='Проектные ставки']");
    @Name("Проектные ставки_Добавить")
    private SelenideElement employeeProjectSalaryRateAdd = $x("//tr[@class='model-employeeprojectsalaryrate']//a[@class='addlink']");
    @Name("Проектные ставки_Изменить")
    private SelenideElement employeeProjectSalaryRateChange = $x("//tr[@class='model-employeeprojectsalaryrate']//a[@class='changelink']");

    //ACCOUNTS
    @Name("Аккаунты")
    private SelenideElement account = $x("//tr[@class='model-account']//a[text()='Аккаунты']");
    @Name("Аккаунты_Добавить")
    private SelenideElement accountAdd = $x("//tr[@class='model-account']//a[@class='addlink']");
    @Name("Аккаунты_Изменить")
    private SelenideElement accountChange = $x("//tr[@class='model-account']//a[@class='changelink']");

    @Name("Проекты")
    private SelenideElement project = $x("//tr[@class='model-project']//a[text()='Проекты']");
    @Name("Проекты_Добавить")
    private SelenideElement projectAdd = $x("//tr[@class='model-project']//a[@class='addlink']");
    @Name("Проекты_Изменить")
    private SelenideElement projectChange = $x("//tr[@class='model-project']//a[@class='changelink']");

    //STRUCTURE
    @Name("Департаменты")
    private SelenideElement department = $x("//tr[@class='model-department']//a[text()='Департаменты']");
    @Name("Департаменты_Добавить")
    private SelenideElement departmentAdd = $x("//tr[@class='model-department']//a[@class='addlink']");
    @Name("Департаменты_Изменить")
    private SelenideElement departmentChange = $x("//tr[@class='model-department']//a[@class='changelink']");

    @Name("Должности")
    private SelenideElement position = $x("//tr[@class='model-position']//a[text()='Должности']");
    @Name("Должности_Добавить")
    private SelenideElement positionAdd = $x("//tr[@class='model-position']//a[@class='addlink']");
    @Name("Должности_Изменить")
    private SelenideElement positionChange = $x("//tr[@class='model-position']//a[@class='changelink']");

    @Name("Проектные роли") //
    private SelenideElement projectRole = $x("//tr[@class='model-projectrole']//a[text()='Проектные роли']");
    @Name("Проектные роли_Добавить")
    private SelenideElement projectRoleAdd = $x("//tr[@class='model-projectrole']//a[@class='addlink']");
    @Name("Проектные роли_Изменить")
    private SelenideElement projectRoleChange = $x("//tr[@class='model-projectrole']//a[@class='changelink']");

    @Name("Типы тестирования") //
    private SelenideElement testingType = $x("//tr[@class='model-testingtype']//a[text()='Типы тестирования']");
    @Name("Типы тестирования_Добавить")
    private SelenideElement testingTypeAdd = $x("//tr[@class='model-testingtype']//a[@class='addlink']");
    @Name("Типы тестирования_Изменить")
    private SelenideElement testingTypeChange = $x("//tr[@class='model-testingtype']//a[@class='changelink']");


    //DICTIONARY
    @Name("Города")
    private SelenideElement city = $x("//tr[@class='model-city']//a[text()='Города']");
    @Name("Города_Добавить")
    private SelenideElement cityAdd = $x("//tr[@class='model-city']//a[@class='addlink']");
    @Name("Города_Изменить")
    private SelenideElement cityChange = $x("//tr[@class='model-city']//a[@class='changelink']");

    @Name("Гражданства")
    private SelenideElement citizenship = $x("//tr[@class='model-citizenship']//a[text()='Гражданства']");
    @Name("Гражданство_Добавить")
    private SelenideElement citizenshipAdd = $x("//tr[@class='model-citizenship']//a[@class='addlink']");
    @Name("Гражданство_Изменить")
    private SelenideElement citizenshipChange = $x("//tr[@class='model-citizenship']//a[@class='changelink']");

    @Name("ВУЗы")
    private SelenideElement educationInstitution = $x("//tr[@class='model-educationinstitution']//a[text()='ВУЗы']");
    @Name("ВУЗ_Добавить")
    private SelenideElement educationInstitutionAdd = $x("//tr[@class='model-educationinstitution']//a[@class='addlink']");
    @Name("ВУЗ_Изменить")
    private SelenideElement educationInstitutionChange = $x("//tr[@class='model-educationinstitution']//a[@class='changelink']");

    @Name("Достижения")
    private SelenideElement achievement = $x("//tr[@class='model-achievement']//a[text()='Достижения']");
    @Name("Достижение_Добавить")
    private SelenideElement achievementAdd = $x("//tr[@class='model-achievement']//a[@class='addlink']");
    @Name("Достижение_Изменить")
    private SelenideElement achievementChange = $x("//tr[@class='model-achievement']//a[@class='changelink']");

    @Name("Должности в сторонних организациях")
    private SelenideElement outsideRole = $x("//tr[@class='model-outsiderole']//a[text()='Должности в сторонних организациях']");
    @Name("Должность в сторонних организациях_Добавить")
    private SelenideElement outsideRoleAdd = $x("//tr[@class='model-outsiderole']//a[@class='addlink']");
    @Name("Должность в сторонних организациях_Изменить")
    private SelenideElement outsideRoleChange = $x("//tr[@class='model-outsiderole']//a[@class='changelink']");

    @Name("Иностранные языки")
    private SelenideElement language = $x("//tr[@class='model-language']//a[text()='Иностранные языки']");
    @Name("Иностранный язык_Добавить")
    private SelenideElement languageAdd = $x("//tr[@class='model-language']//a[@class='addlink']");
    @Name("Иностранный язык_Изменить")
    private SelenideElement languageChange = $x("//tr[@class='model-language']//a[@class='changelink']");

    @Name("Названия организации")
    private SelenideElement organisation = $x("//tr[@class='model-organisation']//a[text()='Названия организации']");
    @Name("Название организации_Добавить")
    private SelenideElement organisationAdd = $x("//tr[@class='model-organisation']//a[@class='addlink']");
    @Name("Название организации_Изменить")
    private SelenideElement organisationChange = $x("//tr[@class='model-organisation']//a[@class='changelink']");

    @Name("Образования")
    private SelenideElement education = $x("//tr[@class='model-education']//a[text()='Образования']");
    @Name("Образование_Добавить")
    private SelenideElement educationAdd = $x("//tr[@class='model-education']//a[@class='addlink']");
    @Name("Образование_Изменить")
    private SelenideElement educationChange = $x("//tr[@class='model-education']//a[@class='changelink']");

    @Name("Показатели квалификации")
    private SelenideElement qualificationSkills = $x("//tr[@class='model-qualificationskills']//a[text()='Показатели квалификации']");
    @Name("Показатель квалификации_Добавить")
    private SelenideElement qualificationSkillsAdd = $x("//tr[@class='model-qualificationskills']//a[@class='addlink']");
    @Name("Показатель квалификации_Изменить")
    private SelenideElement qualificationSkillsChange = $x("//tr[@class='model-qualificationskills']//a[@class='changelink']");

    @Name("Специальности (ВУЗ)")
    private SelenideElement educationSpecialty = $x("//tr[@class='model-educationspecialty']//a[text()='Специальности (ВУЗ)']");
    @Name("Специальность_Добавить")
    private SelenideElement educationSpecialtyAdd = $x("//tr[@class='model-educationspecialty']//a[@class='addlink']");
    @Name("Специальность_Изменить")
    private SelenideElement educationSpecialtyChange = $x("//tr[@class='model-educationspecialty']//a[@class='changelink']");

    @Name("Сторонние организации")
    private SelenideElement outsideOrganisation = $x("//tr[@class='model-outsideorganisation']//a[text()='Сторонние организации']");
    @Name("Сторонние организации_Добавить")
    private SelenideElement outsideOrganisationAdd = $x("//tr[@class='model-outsideorganisation']//a[@class='addlink']");
    @Name("Сторонние организации_Изменить")
    private SelenideElement outsideOrganisationChange = $x("//tr[@class='model-outsideorganisation']//a[@class='changelink']");

    @Name("Типы навыков")
    private SelenideElement keySkillType = $x("//tr[@class='model-keyskilltype']//a[text()='Типы навыков']");
    @Name("Тип навыков_Добавить")
    private SelenideElement keySkillTypeAdd = $x("//tr[@class='model-keyskilltype']//a[@class='addlink']");
    @Name("Тип навыков_Изменить")
    private SelenideElement keySkillTypeChange = $x("//tr[@class='model-keyskilltype']//a[@class='changelink']");

    @Name("Типы квалификации")
    private SelenideElement qualificationSkillType = $x("//tr[@class='model-qualificationskilltype']//a[text()='Типы квалификаций']");
    @Name("Тип квалификации_Добавить")
    private SelenideElement qualificationSkillTypeAdd = $x("//tr[@class='model-qualificationskilltype']//a[@class='addlink']");
    @Name("Тип квалификации_Изменить")
    private SelenideElement qualificationSkillTypeChange = $x("//tr[@class='model-qualificationskilltype']//a[@class='changelink']");

    @Name("Уровни знания иностранного языка")
    private SelenideElement languageKnowledgeLevel = $x("//tr[@class='model-languageknowledgelevel']//a[text()='Уровни знания иностранного языка']");
    @Name("Уровень знания иностранного языка_Добавить")
    private SelenideElement languageKnowledgeLevelAdd = $x("//tr[@class='model-languageknowledgelevel']//a[@class='addlink']");
    @Name("Уровень знания иностранного языка_Изменить")
    private SelenideElement languageKnowledgeLevelChange = $x("//tr[@class='model-languageknowledgelevel']//a[@class='changelink']");

    @Name("Статусы запроса на отпуск")
    private SelenideElement vacationRequestStatus = $x("//tr[@class='model-vacationrequeststatus']//a[text()='Статусы запроса на отпуск']");
    @Name("Статус запроса на отпуск_Добавить")
    private SelenideElement vacationRequestStatusAdd = $x("//tr[@class='model-vacationrequeststatus']//a[@class='addlink']");
    @Name("Статус запроса на отпуск_Изменить")
    private SelenideElement vacationRequestStatusChange = $x("//tr[@class='model-vacationrequeststatus']//a[@class='changelink']");

    @Name("Тип родства")
    private SelenideElement familyType = $x("//tr[@class='model-familytype']//a[text()='Тип родства']");
    @Name("Тип родства_Добавить")
    private SelenideElement familyTypeAdd = $x("//tr[@class='model-familytype']//a[@class='addlink']");
    @Name("Тип родства_Изменить")
    private SelenideElement familyTypeChange = $x("//tr[@class='model-familytype']//a[@class='changelink']");

    //ADMINISTRATIVE ACCESS
    @Name("Сотрудники с административным доступом")
    private SelenideElement administrator = $x("//a[text()='Сотрудники с административным доступом']");
    @Name("Сотрудники с административным доступом_Добавить")
    private SelenideElement administratorAdd = $x("//tr[@class='model-administrator']//a[@class='addlink']");
    @Name("Сотрудники с административным доступом_Изменить")
    private SelenideElement administratorChange = $x("//tr[@class='model-administrator']//a[@class='changelink']");


    @Name("Администрирование Django")
    private SelenideElement headerPage = $x("//a[@href='/admin/']");
}
