package pages;

/**
 * /admin/
 */

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.*;

@Name(value = "DjangoAdministration")
public class DjangoAdministrationPage extends WebPage {

    //HEADER
    @Name("Заголовок таблицы")
    private SelenideElement tableHeader = $x("//div[@id='content']/h1");

    @Name("Первый элемент блока Мои действия")
    private SelenideElement blockMyActionsFirstElement = $x("//div[@id='recent-actions-module']//li//a");

    @Name("Изменить пароль")
    SelenideElement changePassword = $x("//a[@href='/admin/password_change/']");
    @Name("Выйти")
    SelenideElement logout = $x("//a[@href='/admin/logout/']");

    @Name("Администрирование Django")
    private SelenideElement headerPage = $x("//a[@href='/admin/']");

    @Name("Инфоблок")
    private SelenideElement tableHeader = $x("//div[@id='content']/h1");

    //MAIN
    @Name("Сотрудники")
    private SelenideElement employee = $x("//tr[@class='model-employee']/th/a");
    @Name("Добавить поле Сотрудники")
    private SelenideElement addEmployee = $x("//tr[@class='model-employee']//a[@class='addlink']");
    @Name("Изменить поле Сотрудники")
    private SelenideElement changeEmployee = $x("//tr[@class='model-employee']//a[@class='changelink']");

    @Name("Администраторы аккаунта")
    private SelenideElement accountAdmin = $x("//tr[@class='model-accountadmin']/th/a");
    @Name("Добавить поле Администраторы аккаунта")
    private SelenideElement addAccountAdmin = $x("//tr[@class='model-accountadmin']//a[@class='addlink']");
    @Name("Изменить поле Администраторы аккаунта")
    private SelenideElement changeAccountAdmin = $x("//tr[@class='model-accountadmin']//a[@class='changelink']");
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
    private SelenideElement vacationRequest = $x("//tr[@class='model-employeevacationrequest']/th/a");
    @Name("Добавить поле Запросы на отпуск")
    private SelenideElement addVacationRequest = $x("//tr[@class='model-employeevacationrequest']//a[@class='addlink']");
    @Name("Изменить поле Запросы на отпуск")
    private SelenideElement changeVacationRequest = $x("//tr[@class='model-employeevacationrequest']//a[@class='changelink']");

    private SelenideElement employeeVacationRequest = $x("//tr[@class='model-employeevacationrequest']//a[text()='Запросы на отпуск']");
    @Name("Запросы на отпуск_Добавить")
    private SelenideElement employeeVacationRequestAdd = $x("//tr[@class='model-employeevacationrequest']//a[@class='addlink']");
    @Name("Запросы на отпуск_Изменить")
    private SelenideElement employeeVacationRequestChange = $x("//tr[@class='model-employeevacationrequest']//a[@class='changelink']");

    @Name("Фактические отпуска")
    private SelenideElement actualVacation = $x("//tr[@class='model-employeeactualvacation']/th/a");
    @Name("Добавить поле Фактические отпуска")
    private SelenideElement addActualVacation = $x("//tr[@class='model-employeeactualvacation']//a[@class='addlink']");
    @Name("Изменить поле Фактические отпуска")
    private SelenideElement changeActualVacation = $x("//tr[@class='model-employeeactualvacation']//a[@class='changelink']");

    private SelenideElement employeeActualVacation= $x("//tr[@class='model-employeeactualvacation']//a[text()='Фактические отпуска']");
    @Name("Фактические отпуска_Добавить")
    private SelenideElement employeeActualVacationAdd= $x("//tr[@class='model-employeeactualvacation']//a[@class='addlink']");
    @Name("Фактические отпуска_Изменить")
    private SelenideElement employeeActualVacationChange= $x("//tr[@class='model-employeeactualvacation']//a[@class='changelink']");

    @Name("Больничные")
    private SelenideElement sickLeaveOfficial = $x("//tr[@class='model-employeesickleaveofficial']/th/a");
    @Name("Добавить поле Больничные")
    private SelenideElement addSickLeaveOfficial = $x("//tr[@class='model-employeesickleaveofficial']//a[@class='addlink']");
    @Name("Изменить поле Больничные")
    private SelenideElement changeSickLeaveOfficial = $x("//tr[@class='model-employeesickleaveofficial']//a[@class='changelink']");

    private SelenideElement employeeSickLeaveOfficial = $x("//tr[@class='model-employeesickleaveofficial']//a[text()='Больничные']");
    @Name("Больничные_Добавить")
    private SelenideElement employeeSickLeaveOfficialAdd = $x("//tr[@class='model-employeesickleaveofficial']//a[@class='addlink']");
    @Name("Больничные_Изменить")
    private SelenideElement employeeSickLeaveOfficialChange = $x("//tr[@class='model-employeesickleaveofficial']//a[@class='changelink']");

    @Name("Бюллютени без больничного листа")
    private SelenideElement sickLeaveUnofficial = $x("//tr[@class='model-employeesickleaveunofficial']/th/a");
    @Name("Добавить поле Бюллютени без больничного листа")
    private SelenideElement addSickLeaveUnofficial = $x("//tr[@class='model-employeesickleaveunofficial']//a[@class='addlink']");
    @Name("Изменить поле Бюллютени без больничного листа")
    private SelenideElement changeSickLeaveUnofficial = $x("//tr[@class='model-employeesickleaveunofficial']//a[@class='changelink']");

    @Name("Проектные ставки")
    private SelenideElement projectSalaryRate = $x("//tr[@class='model-employeeprojectsalaryrate']/th/a");
    @Name("Добавить поле Проектные ставки")
    private SelenideElement addProjectSalaryRate = $x("//tr[@class='model-employeeprojectsalaryrate']//a[@class='addlink']");
    @Name("Изменить поле Проектные ставки")
    private SelenideElement changeProjectSalaryRate = $x("//tr[@class='model-employeeprojectsalaryrate']//a[@class='changelink']");
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
    private SelenideElement account = $x("//tr[@class='model-account']/th/a");
    @Name("Добавить поле Аккаунты")
    private SelenideElement addAccount = $x("//tr[@class='model-account']//a[@class='addlink']");
    @Name("Изменить поле Аккаунты")
    private SelenideElement changeAccount = $x("//tr[@class='model-account']//a[@class='changelink']");

    private SelenideElement account = $x("//tr[@class='model-account']//a[text()='Аккаунты']");
    @Name("Аккаунты_Добавить")
    private SelenideElement accountAdd = $x("//tr[@class='model-account']//a[@class='addlink']");
    @Name("Аккаунты_Изменить")
    private SelenideElement accountChange = $x("//tr[@class='model-account']//a[@class='changelink']");

    @Name("Проекты")
    private SelenideElement project = $x("//tr[@class='model-project']/th/a");
    @Name("Добавить поле Проекты")
    private SelenideElement addProject = $x("//tr[@class='model-project']//a[@class='addlink']");
    @Name("Изменить поле Проекты")
    private SelenideElement changeProject = $x("//tr[@class='model-project']//a[@class='changelink']");
    private SelenideElement project = $x("//tr[@class='model-project']//a[text()='Проекты']");
    @Name("Проекты_Добавить")
    private SelenideElement projectAdd = $x("//tr[@class='model-project']//a[@class='addlink']");
    @Name("Проекты_Изменить")
    private SelenideElement projectChange = $x("//tr[@class='model-project']//a[@class='changelink']");

    //STRUCTURE
    @Name("Департаменты")
    private SelenideElement department = $x("//tr[@class='model-department']/th/a");
    @Name("Добавить поле Департаменты")
    private SelenideElement addDepartment = $x("//tr[@class='mmodel-department']//a[@class='addlink']");
    @Name("Изменить поле Департаменты")
    private SelenideElement changeDepartment = $x("//tr[@class='model-department']//a[@class='changelink']");

    private SelenideElement department = $x("//tr[@class='model-department']//a[text()='Департаменты']");
    @Name("Департаменты_Добавить")
    private SelenideElement departmentAdd = $x("//tr[@class='model-department']//a[@class='addlink']");
    @Name("Департаменты_Изменить")
    private SelenideElement departmentChange = $x("//tr[@class='model-department']//a[@class='changelink']");

    @Name("Должности")
    private SelenideElement position = $x("//tr[@class='model-position']/th/a");
    @Name("Добавить поле Должности")
    private SelenideElement addPosition = $x("//tr[@class='model-position']//a[@class='addlink']");
    @Name("Изменить поле Должности")
    private SelenideElement changePosition = $x("//tr[@class='model-position']//a[@class='changelink']");

    @Name("Проектные роли")
    private SelenideElement projectRole = $x("//tr[@class='model-projectrole']/th/a");
    @Name("Добавить поле Проектные роли")
    private SelenideElement addProjectRole = $x("//tr[@class='model-projectrole']//a[@class='addlink']");
    @Name("Изменить поле Проектные роли")
    private SelenideElement changeProjectRole = $x("//tr[@class='model-projectrole']//a[@class='changelink']");

    @Name("Типы тестирования")
    private SelenideElement testingType = $x("//tr[@class='model-testingtype']/th/a");
    @Name("Добавить поле Типы тестирования")
    private SelenideElement addTestingType = $x("//tr[@class='model-testingtype']//a[@class='addlink']");
    @Name("Изменить поле Типы тестирования")
    private SelenideElement changeTestingType = $x("//tr[@class='model-testingtype']//a[@class='changelink']");
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
    private SelenideElement city = $x("//tr[@class='model-city']/th/a");
    @Name("Добавить поле Города")
    private SelenideElement addCity = $x("//tr[@class='model-city']//a[@class='addlink']");
    @Name("Изменить поле Города")
    private SelenideElement changeCity = $x("//tr[@class='model-city']//a[@class='changelink']");

    private SelenideElement city = $x("//tr[@class='model-city']//a[text()='Города']");
    @Name("Города_Добавить")
    private SelenideElement cityAdd = $x("//tr[@class='model-city']//a[@class='addlink']");
    @Name("Города_Изменить")
    private SelenideElement cityChange = $x("//tr[@class='model-city']//a[@class='changelink']");

    @Name("Гражданства")
    private SelenideElement citizenship = $x("//tr[@class='model-citizenship']/th/a");
    @Name("Добавить поле Гражданства")
    private SelenideElement addCitizenship = $x("//tr[@class='model-citizenship']//a[@class='addlink']");
    @Name("Изменить поле Гражданства")
    private SelenideElement changeCitizenship = $x("//tr[@class='model-citizenship']//a[@class='changelink']");

    private SelenideElement citizenship = $x("//tr[@class='model-citizenship']//a[text()='Гражданства']");
    @Name("Гражданство_Добавить")
    private SelenideElement citizenshipAdd = $x("//tr[@class='model-citizenship']//a[@class='addlink']");
    @Name("Гражданство_Изменить")
    private SelenideElement citizenshipChange = $x("//tr[@class='model-citizenship']//a[@class='changelink']");

    @Name("ВУЗы")
    private SelenideElement educationInstitution = $x("//tr[@class='model-educationinstitution']/th/a");
    @Name("Добавить поле ВУЗы")
    private SelenideElement addEducationInstitution = $x("//tr[@class='model-educationinstitution']//a[@class='addlink']");
    @Name("Изменить поле ВУЗы")
    private SelenideElement changeEducationInstitution = $x("//tr[@class='model-educationinstitution']//a[@class='changelink']");

    private SelenideElement educationInstitution = $x("//tr[@class='model-educationinstitution']//a[text()='ВУЗы']");
    @Name("ВУЗ_Добавить")
    private SelenideElement educationInstitutionAdd = $x("//tr[@class='model-educationinstitution']//a[@class='addlink']");
    @Name("ВУЗ_Изменить")
    private SelenideElement educationInstitutionChange = $x("//tr[@class='model-educationinstitution']//a[@class='changelink']");

    @Name("Достижения")
    private SelenideElement achievement = $x("//tr[@class='model-achievement']/th/a");
    @Name("Добавить поле Достижения")
    private SelenideElement addAchievement = $x("//tr[@class='model-achievement']//a[@class='addlink']");
    @Name("Изменить поле Достижения")
    private SelenideElement changeAchievement = $x("//tr[@class='model-achievement']//a[@class='changelink']");

    private SelenideElement achievement = $x("//tr[@class='model-achievement']//a[text()='Достижения']");
    @Name("Достижение_Добавить")
    private SelenideElement achievementAdd = $x("//tr[@class='model-achievement']//a[@class='addlink']");
    @Name("Достижение_Изменить")
    private SelenideElement achievementChange = $x("//tr[@class='model-achievement']//a[@class='changelink']");

    @Name("Должности в сторонних организациях")
    private SelenideElement outsideRole = $x("//tr[@class='model-outsiderole']/th/a");
    @Name("Добавить поле Должности в сторонних организациях")
    private SelenideElement addOutsideRole = $x("//tr[@class='model-outsiderole']//a[@class='addlink']");
    @Name("Изменить поле Должности в сторонних организациях")
    private SelenideElement changeOutsideRole = $x("//tr[@class='model-outsiderole']//a[@class='changelink']");

    private SelenideElement outsideRole = $x("//tr[@class='model-outsiderole']//a[text()='Должности в сторонних организациях']");
    @Name("Должность в сторонних организациях_Добавить")
    private SelenideElement outsideRoleAdd = $x("//tr[@class='model-outsiderole']//a[@class='addlink']");
    @Name("Должность в сторонних организациях_Изменить")
    private SelenideElement outsideRoleChange = $x("//tr[@class='model-outsiderole']//a[@class='changelink']");

    @Name("Иностранные языки")
    private SelenideElement language = $x("//tr[@class='model-language']/th/a");
    @Name("Добавить поле Иностранные языки")
    private SelenideElement addLanguage = $x("//tr[@class='model-language']//a[@class='addlink']");
    @Name("Изменить поле Иностранные языки")
    private SelenideElement changeLanguage = $x("//tr[@class='model-language']//a[@class='changelink']");

    private SelenideElement language = $x("//tr[@class='model-language']//a[text()='Иностранные языки']");
    @Name("Иностранный язык_Добавить")
    private SelenideElement languageAdd = $x("//tr[@class='model-language']//a[@class='addlink']");
    @Name("Иностранный язык_Изменить")
    private SelenideElement languageChange = $x("//tr[@class='model-language']//a[@class='changelink']");

    @Name("Названия организации")
    private SelenideElement organisation = $x("//tr[@class='model-organisation']/th/a");
    @Name("Добавить поле Названия организации")
    private SelenideElement addOrganisation = $x("//tr[@class='model-organisation']//a[@class='addlink']");
    @Name("Изменить поле Названия организации")
    private SelenideElement changeOrganisation = $x("//tr[@class='model-organisation']//a[@class='changelink']");

    private SelenideElement organisation = $x("//tr[@class='model-organisation']//a[text()='Названия организации']");
    @Name("Название организации_Добавить")
    private SelenideElement organisationAdd = $x("//tr[@class='model-organisation']//a[@class='addlink']");
    @Name("Название организации_Изменить")
    private SelenideElement organisationChange = $x("//tr[@class='model-organisation']//a[@class='changelink']");

    @Name("Образования")
    private SelenideElement education = $x("//tr[@class='model-education']/th/a");
    @Name("Добавить поле Образования")
    private SelenideElement addEducation = $x("//tr[@class='model-education']//a[@class='addlink']");
    @Name("Изменить поле Образования")
    private SelenideElement changeEducation = $x("//tr[@class='model-education']//a[@class='changelink']");

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
    private SelenideElement educationSpecialty = $x("//tr[@class='model-educationspecialty']/th/a");
    @Name("Добавить поле Специальности (ВУЗ)")
    private SelenideElement addEducationSpecialty = $x("//tr[@class='model-educationspecialty']//a[@class='addlink']");
    @Name("Изменить поле Специальности (ВУЗ)")
    private SelenideElement changeEducationSpecialty = $x("//tr[@class='model-educationspecialty']//a[@class='changelink']");

    private SelenideElement educationSpecialty = $x("//tr[@class='model-educationspecialty']//a[text()='Специальности (ВУЗ)']");
    @Name("Специальность_Добавить")
    private SelenideElement educationSpecialtyAdd = $x("//tr[@class='model-educationspecialty']//a[@class='addlink']");
    @Name("Специальность_Изменить")
    private SelenideElement educationSpecialtyChange = $x("//tr[@class='model-educationspecialty']//a[@class='changelink']");

    @Name("Сторонние организации")
    private SelenideElement outsideOrganisation = $x("//tr[@class='model-outsideorganisation']/th/a");
    @Name("Добавить поле Сторонние организации")
    private SelenideElement addOutsideOrganisation = $x("//tr[@class='model-outsideorganisation']//a[@class='addlink']");
    @Name("Изменить поле Сторонние организации")
    private SelenideElement changeOutsideOrganisation = $x("//tr[@class='model-outsideorganisation']//a[@class='changelink']");

    private SelenideElement outsideOrganisation = $x("//tr[@class='model-outsideorganisation']//a[text()='Сторонние организации']");
    @Name("Сторонние организации_Добавить")
    private SelenideElement outsideOrganisationAdd = $x("//tr[@class='model-outsideorganisation']//a[@class='addlink']");
    @Name("Сторонние организации_Изменить")
    private SelenideElement outsideOrganisationChange = $x("//tr[@class='model-outsideorganisation']//a[@class='changelink']");

    @Name("Типы навыков")
    private SelenideElement keySkillType = $x("//tr[@class='model-keyskilltype']/th/a");
    @Name("Добавить поле Типы навыков")
    private SelenideElement addKeySkillType = $x("//tr[@class='model-keyskilltype']//a[@class='addlink']");
    @Name("Изменить поле Типы навыков")
    private SelenideElement changeKeySkillType = $x("//tr[@class='model-keyskilltype']//a[@class='changelink']");

    private SelenideElement keySkillType = $x("//tr[@class='model-keyskilltype']//a[text()='Типы навыков']");
    @Name("Тип навыков_Добавить")
    private SelenideElement keySkillTypeAdd = $x("//tr[@class='model-keyskilltype']//a[@class='addlink']");
    @Name("Тип навыков_Изменить")
    private SelenideElement keySkillTypeChange = $x("//tr[@class='model-keyskilltype']//a[@class='changelink']");

    @Name("Типы квалификации")
    private SelenideElement qualificationSkillType = $x("//tr[@class='model-qualificationskilltype']/th/a");
    @Name("Добавить поле Типы квалификации")
    private SelenideElement addQualificationSkillType = $x("//tr[@class='model-qualificationskilltype']//a[@class='addlink']");
    @Name("Изменить поле Типы квалификации")
    private SelenideElement changeQualificationSkillType = $x("//tr[@class='model-qualificationskilltype']//a[@class='changelink']");

    @Name("Показатели квалификации")
    private SelenideElement qualificationSkills = $x("//tr[@class='model-qualificationskills']/th/a");
    @Name("Добавить поле Показатели квалификации")
    private SelenideElement addQualificationSkills = $x("//tr[@class='model-qualificationskills']//a[@class='addlink']");
    @Name("Изменить поле Показатели квалификации")
    private SelenideElement changeQualificationSkills = $x("//tr[@class='model-qualificationskills']//a[@class='changelink']");

    private SelenideElement qualificationSkillType = $x("//tr[@class='model-qualificationskilltype']//a[text()='Типы квалификаций']");
    @Name("Тип квалификации_Добавить")
    private SelenideElement qualificationSkillTypeAdd = $x("//tr[@class='model-qualificationskilltype']//a[@class='addlink']");
    @Name("Тип квалификации_Изменить")
    private SelenideElement qualificationSkillTypeChange = $x("//tr[@class='model-qualificationskilltype']//a[@class='changelink']");

    @Name("Уровни знания иностранного языка")
    private SelenideElement languageKnowledgeLevel = $x("//tr[@class='model-languageknowledgelevel']/th/a");
    @Name("Добавить поле Уровни знания иностранного языка")
    private SelenideElement addLanguageKnowledgeLevel = $x("//tr[@class='model-languageknowledgelevel']//a[@class='addlink']");
    @Name("Изменить поле Уровни знания иностранного языка")
    private SelenideElement changeLanguageKnowledgeLevel = $x("//tr[@class='model-languageknowledgelevel']//a[@class='changelink']");

    private SelenideElement languageKnowledgeLevel = $x("//tr[@class='model-languageknowledgelevel']//a[text()='Уровни знания иностранного языка']");
    @Name("Уровень знания иностранного языка_Добавить")
    private SelenideElement languageKnowledgeLevelAdd = $x("//tr[@class='model-languageknowledgelevel']//a[@class='addlink']");
    @Name("Уровень знания иностранного языка_Изменить")
    private SelenideElement languageKnowledgeLevelChange = $x("//tr[@class='model-languageknowledgelevel']//a[@class='changelink']");

    @Name("Статусы запроса на отпуск")
    private SelenideElement vacationRequestStatus = $x("//tr[@class='model-vacationrequeststatus']/th/a");
    @Name("Добавить поле Статусы запроса на отпуск")
    private SelenideElement addVacationRequestStatus = $x("//tr[@class='model-vacationrequeststatus']//a[@class='addlink']");
    @Name("Изменить поле Статусы запроса на отпуск")
    private SelenideElement changeVacationRequestStatus = $x("//tr[@class='model-vacationrequeststatus']//a[@class='changelink']");

    private SelenideElement vacationRequestStatus = $x("//tr[@class='model-vacationrequeststatus']//a[text()='Статусы запроса на отпуск']");
    @Name("Статус запроса на отпуск_Добавить")
    private SelenideElement vacationRequestStatusAdd = $x("//tr[@class='model-vacationrequeststatus']//a[@class='addlink']");
    @Name("Статус запроса на отпуск_Изменить")
    private SelenideElement vacationRequestStatusChange = $x("//tr[@class='model-vacationrequeststatus']//a[@class='changelink']");

    @Name("Тип родства")
    private SelenideElement familyType = $x("//tr[@class='model-familytype']/th/a");
    @Name("Добавить поле Тип родства")
    private SelenideElement addFamilyType = $x("//tr[@class='model-familytype']//a[@class='addlink']");
    @Name("Изменить поле Тип родства")
    private SelenideElement changeFamilyType = $x("//tr[@class='model-familytype']//a[@class='changelink']");
    private SelenideElement familyType = $x("//tr[@class='model-familytype']//a[text()='Тип родства']");
    @Name("Тип родства_Добавить")
    private SelenideElement familyTypeAdd = $x("//tr[@class='model-familytype']//a[@class='addlink']");
    @Name("Тип родства_Изменить")
    private SelenideElement familyTypeChange = $x("//tr[@class='model-familytype']//a[@class='changelink']");

    //ADMINISTRATIVE ACCESS
    @Name("Сотрудники с административным доступом")
    private SelenideElement adminEmployee = $x("//tr[@class='model-administrator']/th/a");
    @Name("Добавить поле Сотрудники с административным доступом")
    private SelenideElement addAdminEmployee = $x("//tr[@class='model-administrator']//a[@class='addlink']");
    @Name("Изменить поле Сотрудники с административным доступом")
    private SelenideElement changeAdminEmployee = $x("//tr[@class='model-administrator']//a[@class='changelink']");

    //USERS AND GROUP
    @Name("Группы")
    private SelenideElement group = $x("//tr[@class='model-group']/th/a");
    @Name("Добавить поле Группы")
    private SelenideElement addGroup = $x("//tr[@class='model-group']//a[@class='addlink']");
    @Name("Изменить поле Группы")
    private SelenideElement changeGroup = $x("//tr[@class='model-group']//a[@class='changelink']");
    private SelenideElement administrator = $x("//a[text()='Сотрудники с административным доступом']");
    @Name("Сотрудники с административным доступом_Добавить")
    private SelenideElement administratorAdd = $x("//tr[@class='model-administrator']//a[@class='addlink']");
    @Name("Сотрудники с административным доступом_Изменить")
    private SelenideElement administratorChange = $x("//tr[@class='model-administrator']//a[@class='changelink']");

    @Name("Пользователи")
    private SelenideElement user = $x("//tr[@class='model-user']/th/a");
    @Name("Добавить поле Пользователи")
    private SelenideElement addUser = $x("//tr[@class='model-user']//a[@class='addlink']");
    @Name("Изменить поле Пользователи")
    private SelenideElement changeUser = $x("//tr[@class='model-user']//a[@class='changelink']");

    //OTP_TOTP
    @Name("TOTP devices")
    private SelenideElement totp = $x("//tr[@class='model-totpdevice']/th/a");
    @Name("Добавить поле TOTP devices")
    private SelenideElement addTotp = $x("//tr[@class='model-totpdevice']//a[@class='addlink']");
    @Name("Изменить поле TOTP devices")
    private SelenideElement changeTotp = $x("//tr[@class='model-totpdevice']//a[@class='changelink']");

    @Name("Войти снова")
    SelenideElement loginAgain = $x("//div[@id='content']/p/a[@href='/admin/']");

    @Name("Администрирование Django")
    private SelenideElement headerPage = $x("//a[@href='/admin/']");
}
