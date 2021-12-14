package ts4_2;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

public class EmployeeAdminTest extends WebHooks {

    private PageManager pageManager = new PageManager();
    private final WebSteps webSteps = new WebSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);

//    @DataProvider
//    public Object[][] data() {
//        return new Object[][]{
//                {"admin", "Сотрудники", "Заголовок таблицы", "Выберите Сотрудник для изменения"},
//                {"hr", "Добавить поле Сотрудники", "Заголовок таблицы", "Добавить Сотрудник"},
//                {"public", "Сотрудники", "Заголовок таблицы", "Выберите Сотрудник для просмотра"}
//        };
//    }

    private void initialize() {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("admin");
        webSteps.setPage("DjangoAdministration");
    }

    @Test
    @Description("4.1 Проверка работоспособности ссылки 'Сотрудники с административным доступом' под ролью 'admin'")
    public void adminAccessTest() {
        initialize();
        webCheckSteps.checkAppearElement("Сотрудники с административным доступом");
        webSteps.clickOnElement("Сотрудники с административным доступом");
        webSteps.setPage("DjangoAdminAccess");
        webCheckSteps.matchText("Инфоблок", "Выберите Сотрудник с административным доступом для изменения");
    }
}
