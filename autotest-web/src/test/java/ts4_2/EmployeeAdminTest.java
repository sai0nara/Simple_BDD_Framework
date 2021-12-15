package ts4_2;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

public class EmployeeAdminTest extends WebHooks {

    private PageManager pageManager = new PageManager();
    private final WebSteps webSteps = new WebSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);

    @DataProvider
    public Object[][] dataAdminAccess() {
        return new Object[][]{
                {"Сотрудники с административным доступом", "DjangoAdminAccess", "Выберите Сотрудник с административным доступом для изменения"},
                {"Добавить поле Сотрудники", "DjangoAdminAccessAddEmployee", "Добавить Сотрудник с административным доступом"},
//                {"public", "Сотрудники", "Заголовок таблицы", "Выберите Сотрудник для просмотра"}
        };
    }

    private void initialize() {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("admin");
        webSteps.setPage("DjangoAdministration");
    }

    @Test(dataProvider = "dataAdminAccess")
    @Description("4.1-4.2 Проверка работоспособности ссылки 'Сотрудники с административным доступом' и кнопки 'Добавить' под ролью 'admin'")
    public void adminAccessTest(String button, String page, String infotext) {
        initialize();
        webCheckSteps.checkAppearElement(button);
        webSteps.clickOnElement(button);
        webSteps.setPage(page);
        webCheckSteps.matchText("Инфоблок", infotext);
    }

    @Test
    @Description("4.3 Проверка работоспособности кнопки 'Добавить' подраздела 'Сотрудники с административным доступом' под ролью 'admin'")
    public void adminAccessAddButtonTest() {
        initialize();
        webCheckSteps.checkAppearElement("Добавить поле Сотрудники");
        webSteps.clickOnElement("Добавить поле Сотрудники");
        webSteps.setPage("DjangoAdminAccessAddEmployee");
        webCheckSteps.matchText("Инфоблок", "Добавить Сотрудник с административным доступом");
    }
}
