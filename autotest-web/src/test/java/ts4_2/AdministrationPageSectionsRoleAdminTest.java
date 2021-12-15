package ts4_2;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

public class AdministrationPageSectionsRoleAdminTest extends WebHooks {

    private PageManager pageManager = new PageManager();
    private final WebSteps webSteps = new WebSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"Сотрудники с административным доступом", "DjangoAdminAccess", "Выберите Сотрудник с административным доступом для изменения"},
                {"Добавить поле Сотрудники", "DjangoAdminAccessAddEmployee", "Добавить Сотрудник с административным доступом"},
                {"Изменить поле Сотрудники", "DjangoAdminAccessChangeEmployee", "Выберите Сотрудник с административным доступом для изменения"},
                {"Группы", "DjangoGroup", "Выберите группа для изменения"},
                {"Добавить поле Группы", "DjangoAddGroup", "Добавить группа"},
                {"Изменить поле Группы", "DjangoChangeGroup", "Выберите группа для изменения"},
                {"Пользователи", "DjangoUser", "Выберите пользователь для изменения"},
                {"Добавить поле Пользователи", "DjangoAddUser", "Добавить пользователь"},
                {"Изменить поле Пользователи", "DjangoChangeUser", "Выберите пользователь для изменения"},
                {"OTP_TOTP", "DjangoTotp", "Выберите TOTP device для изменения"},
                {"Добавить поле OTP_TOTP", "DjangoAddTotp", "Добавить TOTP device"},
                {"Изменить поле OTP_TOTP", "DjangoChangeTotp", "Выберите TOTP device для изменения"}
        };
    }

    private void initialize() {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("admin");
        webSteps.setPage("DjangoAdministration");
    }

    @Test(dataProvider = "data")
//    @Description("4.1-4.12 Проверка работоспособности ссылки 'Сотрудники с административным доступом', кнопок 'Добавить' и 'Изменить'" +
//            "4.4-4.6 Проверка работоспособности ссылки 'Группы', кнопок 'Добавить' и 'Изменить'" +
//            "4.7-4.9 Проверка работоспособности ссылки 'Пользователи', кнопок 'Добавить' и 'Изменить'" +
//            "4.10-4.12 Проверка работоспособности ссылки 'OTP_TOTP', кнопок 'Добавить' и 'Изменить'" +
//            "под ролью 'admin'")
    @Description("4.1-4.12 Проверка работоспособности элемента {button}. под ролью 'admin'")
    public void administrationAccessUserGroupTotpTest(String button, String page, String infotext) {
        initialize();
        webCheckSteps.checkAppearElement(button);
        webSteps.clickOnElement(button);
        webSteps.setPage(page);
        webCheckSteps.matchText("Инфоблок", infotext);
    }
}
