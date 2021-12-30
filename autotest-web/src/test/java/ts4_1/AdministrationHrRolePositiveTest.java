package ts4_1;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.api.testcontext.ContextHolder;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;


public class AdministrationHrRolePositiveTest extends WebHooks {
    private final PageManager pageManager = new PageManager();

    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);
    private final WebSteps webSteps = new WebSteps(pageManager);

    private void initialize() {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("hr");
        webSteps.setPage("DjangoAdministration");
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                /*4.1.2*/ {"Изменить поле Сотрудники","DjangoEmployee","Выберите Сотрудник для изменения" },
                /*4.1.3*/ {"Администраторы аккаунта", "DjangoAccountAdminPage", "Выберите Администратор аккаунта для изменения"},
                /*4.1.4*/ {"Администраторы аккаунта_Добавить", "DjangoAccountAdminAddPage", "Добавить Администратор аккаунта"},
                /*4.1.5*/ {"Администраторы аккаунта_Изменить", "DjangoAccountAdminChangePage", "Выберите Администратор аккаунта для изменения"},
                /*4.1.6*/ {"Запросы на отпуск", "DjangoEmployeeVacationRequestPage", "Выберите Запрос на отпуск для изменения"},
                /*4.1.7*/ {"Запросы на отпуск_Добавить", "DjangoEmployeeVacationRequestAddPage", "Добавить Запрос на отпуск"},
                /*4.1.8*/ {"Запросы на отпуск_Изменить", "DjangoEmployeeVacationRequestChangePage", "Выберите Запрос на отпуск для изменения"},
                /*4.1.9*/ {"Фактические отпуска", "DjangoEmployeeActualVacationPage", "Выберите Фактический отпуск для изменения"},
                /*4.1.10*/ {"Фактические отпуска_Добавить", "DjangoEmployeeActualVacationAddPage", "Добавить Фактический отпуск"},
                /*4.1.11*/ {"Фактические отпуска_Изменить", "DjangoEmployeeActualVacationChangePage", "Выберите Фактический отпуск для изменения"},
                /*4.1.12*/ {"Больничные", "DjangoEmployeeSickLeaveOfficialPage", "Выберите Больничный для изменения"},
                /*4.1.13*/ {"Больничные_Добавить", "DjangoEmployeeSickLeaveOfficialAddPage", "Добавить Больничный"},
                /*4.1.14*/ {"Больничные_Изменить", "DjangoEmployeeSickLeaveOfficialChangePage", "Выберите Больничный для изменения"},
                /*4.1.15*/ {"Бюллютени без больничного листа", "DjangoEmployeeSickLeaveUnofficialPage", "Выберите Бюллютень без больничного листа для изменения"},
                /*4.1.16*/ {"Бюллютени без больничного листа_Добавить", "DjangoEmployeeSickLeaveUnofficialAddPage", "Добавить Бюллютень без больничного листа"},
                /*4.1.17*/ {"Бюллютени без больничного листа_Изменить", "DjangoEmployeeSickLeaveUnofficialChangePage", "Выберите Бюллютень без больничного листа для изменения"},
                /*4.1.18*/ {"Проектные ставки", "DjangoEmployeeProjectSalaryRatePage", "Выберите Проектная ставка для изменения"},
                /*4.1.19*/ {"Проектные ставки_Изменить", "DjangoEmployeeProjectSalaryRatePage", "Выберите Проектная ставка для изменения"},
                /*4.1.20*/ {"Аккаунты", "DjangoAccountPage", "Выберите Аккаунт для изменения"},
                /*4.1.21*/ {"Аккаунты_Добавить", "DjangoAccountAddPage", "Добавить Аккаунт"},
                /*4.1.22*/ {"Аккаунты_Изменить", "DjangoAccountChangePage", "Выберите Аккаунт для изменения"},
                /*4.1.23*/ {"Проекты", "DjangoProjectPage", "Выберите Проект для изменения"},
                /*4.1.24*/ {"Проекты_Добавить", "DjangoProjectAddPage", "Добавить Проект"},
                /*4.1.25*/ {"Проекты_Изменить", "DjangoProjectChangePage", "Выберите Проект для изменения"},
                /*4.1.26*/ {"Департаменты","DjangoDepartmentPage" ,"Выберите Департамент для изменения" },
                /*4.1.27*/ {"Департаменты_Добавить","DjangoDepartmentAddPage" , "Добавить Департамент"},
                /*4.1.28*/ {"Департаменты_Изменить","DjangoDepartmentChangePage" ,"Выберите Департамент для изменения" },
                /*4.1.29*/ {"Должности","DjangoPositionPage", "Выберите Должность для изменения"},
                /*4.1.30*/ {"Должности_Добавить", "DjangoPositionAddPage", "Добавить Должность"},
                /*4.1.31*/ {"Должности_Изменить", "DjangoPositionChangePage", "Выберите Должность для изменения"},
                /*4.1.32*/ {"Проектные роли","DjangoProjectRolePage","Выберите Проектная роль для изменения"},
                /*4.1.33*/ {"Проектные роли_Добавить","DjangoProjectRoleAddPage","Добавить Проектная роль"},
                /*4.1.34*/ {"Проектные роли_Изменить","DjangoProjectRoleChangePage","Выберите Проектная роль для изменения"},
                /*4.1.35*/ {"Типы тестирования","DjangoTestingTypePage" ,"Выберите Тип тестирования для изменения"},
                /*4.1.36*/ {"Типы тестирования_Добавить","DjangoTestingTypeAddPage" ,"Добавить Тип тестирования"},
                /*4.1.37*/ {"Типы тестирования_Изменить","DjangoTestingTypeChangePage" ,"Выберите Тип тестирования для изменения"},
                /*4.1.38*/ {"Города","DjangoCityPage","Выберите Город для изменения"},
                /*4.1.39*/ {"Города_Добавить","DjangoCityAddPage","Добавить Город"},
                /*4.1.40*/ {"Города_Изменить","DjangoCityChangePage","Выберите Город для изменения"},
                /*4.1.41*/ {"Гражданства","DjangoCitizenshipPage","Выберите Гражданство для изменения"},
                /*4.1.42*/ {"Гражданство_Добавить","DjangoCitizenshipAddPage","Добавить Гражданство"},
                /*4.1.43*/ {"Гражданство_Изменить","DjangoCitizenshipChangePage","Выберите Гражданство для изменения"},
                /*4.1.44*/ {"ВУЗы","DjangoEducationInstitutionPage","Выберите ВУЗ для изменения"},
                /*4.1.45*/ {"ВУЗ_Добавить","DjangoEducationInstitutionAddPage","Добавить ВУЗ"},
                /*4.1.46*/ {"ВУЗ_Изменить","DjangoEducationInstitutionChangePage","Выберите ВУЗ для изменения"},
                /*4.1.47*/ {"Достижения","DjangoAchievementPage","Выберите Достижение для изменения"},
                /*4.1.48*/ {"Достижение_Добавить","DjangoAchievementAddPage","Добавить Достижение"},
                /*4.1.49*/ {"Достижение_Изменить","DjangoAchievementChangePage","Выберите Достижение для изменения"},
                /*4.1.50*/ {"Должности в сторонних организациях","DjangoOutsideRolePage","Выберите Проектная роль для изменения"},
                /*4.1.51*/ {"Должность в сторонних организациях_Добавить","DjangoOutsideRoleAddPage","Добавить Проектная роль"},
                /*4.1.52*/ {"Должность в сторонних организациях_Изменить","DjangoOutsideRoleChangePage","Выберите Проектная роль для изменения"},
                /*4.1.53*/ {"Иностранные языки","DjangoLanguagePage","Выберите Иностранный язык для изменения"},
                /*4.1.54*/ {"Иностранный язык_Добавить","DjangoLanguageAddPage","Добавить Иностранный язык"},
                /*4.1.55*/ {"Иностранный язык_Изменить","DjangoLanguageChangePage","Выберите Иностранный язык для изменения"},
                /*4.1.56*/ {"Названия организации","DjangoOrganisationPage","Выберите Название организации для изменения"},
                /*4.1.57*/ {"Название организации_Добавить","DjangoOrganisationAddPage","Добавить Название организации"},
                /*4.1.58*/ {"Название организации_Изменить","DjangoOrganisationChangePage","Выберите Название организации для изменения"},
                /*4.1.59*/ {"Образования","DjangoEducationPage","Выберите Образование для изменения"},
                /*4.1.60*/ {"Образование_Добавить","DjangoEducationAddPage","Добавить Образование"},
                /*4.1.61*/ {"Образование_Изменить","DjangoEducationChangePage","Выберите Образование для изменения"},
                /*4.1.62*/ {"Показатели квалификации","DjangoQualificationSkillsPage","Выберите Показатель квалификации для изменения"},
                /*4.1.63*/ {"Показатель квалификации_Добавить","DjangoQualificationSkillsAddPage","Добавить Показатель квалификации"},
                /*4.1.64*/ {"Показатель квалификации_Изменить","DjangoQualificationSkillsChangePage","Выберите Показатель квалификации для изменения"},
                /*4.1.65*/ {"Специальности (ВУЗ)","DjangoEducationSpecialtyPage","Выберите Специальность для изменения"},
                /*4.1.66*/ {"Специальность_Добавить","DjangoEducationSpecialtyAddPage","Добавить Специальность"},
                /*4.1.67*/ {"Специальность_Изменить","DjangoEducationSpecialtyChangePage","Выберите Специальность для изменения"},
                /*4.1.68*/ {"Сторонние организации","DjangoOutsideOrganisationPage","Выберите Название организации для изменения"},
                /*4.1.69*/ {"Сторонние организации_Добавить","DjangoOutsideOrganisationAddPage","Добавить Название организации"},
                /*4.1.70*/ {"Сторонние организации_Изменить","DjangoOutsideOrganisationChangePage","Выберите Название организации для изменения"},
                /*4.1.71*/ {"Типы навыков","DjangoKeySkillTypePage","Выберите Тип навыков для изменения"},
                /*4.1.72*/ {"Тип навыков_Добавить","DjangoKeySkillTypeAddPage","Добавить Тип навыков"},
                /*4.1.73*/ {"Тип навыков_Изменить","DjangoKeySkillTypeChangePage","Выберите Тип навыков для изменения"},
                /*4.1.74*/ {"Типы квалификации","DjangoQualificationSkillTypePage","Выберите Тип квалификации для изменения"},
                /*4.1.75*/ {"Тип квалификации_Добавить","DjangoQualificationSkillTypeAddPage","Добавить Тип квалификации"},
                /*4.1.76*/ {"Тип квалификации_Изменить","DjangoQualificationSkillTypeChangePage","Выберите Тип квалификации для изменения"},
                /*4.1.77*/ {"Уровни знания иностранного языка","DjangoLanguageKnowledgeLevelPage","Выберите Уровень знания иностранного языка для изменения"},
                /*4.1.78*/ {"Уровень знания иностранного языка_Добавить","DjangoLanguageKnowledgeLevelAddPage","Добавить Уровень знания иностранного языка"},
                /*4.1.79*/ {"Уровень знания иностранного языка_Изменить","DjangoLanguageKnowledgeLevelChangePage","Выберите Уровень знания иностранного языка для изменения"},
                /*4.1.80*/ {"Статусы запроса на отпуск","DjangoVacationRequestStatusPage","Выберите Статус запроса на отпуск для изменения"},
                /*4.1.81*/ {"Статус запроса на отпуск_Добавить","DjangoVacationRequestStatusAddPage","Добавить Статус запроса на отпуск"},
                /*4.1.82*/ {"Статус запроса на отпуск_Изменить","DjangoVacationRequestStatusChangePage","Выберите Статус запроса на отпуск для изменения"},
                /*4.1.83*/ {"Тип родства","DjangoFamilyTypePage","Выберите Тип родства для изменения"},
                /*4.1.84*/ {"Тип родства_Добавить","DjangoFamilyTypeAddPage","Добавить Тип родства"},
                /*4.1.85*/ {"Тип родства_Изменить","DjangoFamilyTypeChangePage","Выберите Тип родства для изменения"},
                /*4.1.86*/ {"Сотрудники с административным доступом_Добавить","DjangoAdministratorAddPage","Добавить Сотрудник с административным доступом"},
        };
    }

    @Test()
    @Description("Тест 4.1.1 Проверка отображения недоступного функционала под ролью hr")
    public void checkExistsAdminFunctionalityUnderHrRole() {

        initialize();

        webCheckSteps.checkElementIsNotExistsOnPage("Проектные ставки_Добавить");
        webCheckSteps.checkElementIsNotExistsOnPage("Сотрудники с административным доступом_Изменить");

        //Проверка отсутствия ссылок заменена на проверку отсутствия секций, содержащих эти ссылки
        webCheckSteps.checkElementIsNotExistsOnPage("Модели в приложении Пользователи и группы");
        webCheckSteps.checkElementIsNotExistsOnPage("Модели в приложении Otp_Totp");

        //Эта проверка провалит тест поскольку указанный элемент есть на странице, нужна чтобы убедится в правильной работе предыдущих проверок
        //webCheckSteps.checkElementIsExistsOnPage("Проектные ставки_Изменить");
    }

    @Test(dataProvider = "data")
    @Description("Тесты 4.1.2-4.1.86, роль hr")
    public void checkHrRole(String link, String page, String checkedText) {
        initialize();
        webSteps.clickOnElement(link);
        webSteps.setPage(page);
        webCheckSteps.checkElementIsExistsOnPage(checkedText);
    }

    @Test()
    @Description("Тест 4.1.87 Проверка отображения недоступного функционала под ролью hr")
    public void checkMyLastActionsDisplayUnderHrRole() {
        String checkedText="";

        initialize();
        webSteps.clickOnElement("Сотрудники");
        webSteps.setPage("DjangoEmployee");
        webSteps.clickOnElement("Добавить сотрудник");
        webSteps.setPage("DjangoEmployeeAddPage");

        //Заполняем Имя Фамилию и пол, случайными значениями
        webSteps.fillFieldRandomString("Фамилия");
        webSteps.fillFieldRandomString("Имя");
        webSteps.listSelectRandElement("Пол");

        webSteps.clickOnElement("Сохранить");
        webSteps.setPage("DjangoEmployeeChange");
        webCheckSteps.checkElementIsExistsOnPage("Сообщение об успешном редактировании");
        webSteps.clickOnElement( "Администрирование Django");
        webSteps.setPage("DjangoAdministration");

        checkedText=ContextHolder.getValue("Фамилия")+" "+ContextHolder.getValue("Имя");

        webCheckSteps.matchText("Первый элемент блока Мои действия",checkedText);





    }


}
