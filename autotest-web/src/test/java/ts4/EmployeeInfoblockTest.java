package ts4;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.AuthorizationSteps;
import steps.WebActionSteps;
import steps.WebCheckSteps;

public class EmployeeInfoblockTest extends WebHooks {

    private PageManager pageManager = new PageManager();

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"hr", "Сотрудники", "Заголовок таблицы", "Выберите Сотрудник для изменения"},
                {"hr", "Добавить поле Сотрудники", "Заголовок таблицы", "Добавить Сотрудник"},
                {"public", "Сотрудники", "Заголовок таблицы", "Выберите Сотрудник для просмотра"}
        };
    }

    @Test(dataProvider = "data")
    @Description("4.1-4.3 Проверка текста в инфоблоке, после нажатия на кнопку 'Сотрудники'. Роль Hr")
    public void employeeHrPublicInfoblockTest(String login, String link, String header, String text) {
        AuthorizationSteps authorizationSteps = new AuthorizationSteps(pageManager);
        WebActionSteps webActionSteps = new WebActionSteps(pageManager);
        WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);

        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin(login);
        authorizationSteps.clickSignInButton("войти");
        authorizationSteps.setPage("DjangoAdministration");
        webActionSteps.clickOnButton(link);
        authorizationSteps.setPage("DjangoEmployeeChange");
        webCheckSteps.matchText(header, text);
    }
}
