package ts4_3;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.junit.Before;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;


public class AdministrationPageUnavailableFunctionalTest extends WebHooks {

    private PageManager pageManager = new PageManager();
    private final WebSteps webSteps = new WebSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);

    @DataProvider
    public Object[][] pageElement() {
        return new Object[][]{
                {"Добавить"},
                {"Изменить"},
                {"Сотрудники с административным доступом"},
                {"Группы"},
                {"Пользователи"},
                {"TOTP devices"}
        };
    }

    public void initialize() {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("public");
        webSteps.setPage("DjangoAdministration");
    }

    @Test(dataProvider = "pageElement")
    @Description("4.3.1 Проверка отсутствуют элемента {button} под ролью 'public'")
    public void publicAccessButtons (String button)
    {
        initialize();
        webCheckSteps.currentTextIsNotExist(button);
    }
}