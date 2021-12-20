package ts4_3;

import hooks.WebHooks;
import io.qameta.allure.Description;
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
    public Object[][] pageElement1() {
        return new Object[][]{
                {"Добавить поле Сотрудники"},
                {"Изменить поле Сотрудники"},
                {"Сотрудники с административным доступом"},
                {"Группы"},
                {"Пользователи"},
                {"TOTP devices"}
        };
    }

    @DataProvider
    public Object[][] pageElement2() {
        return new Object[][]{
                {"Посмотреть поле Сотрудники", "DjangoEmployee", "Select Сотрудник to view"}//,
//                {" ", " "}
        };
    }

    public void initialize() {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("public");
        webSteps.setPage("DjangoAdministration");
    }

    @Test(dataProvider = "pageElement1")
    @Description("4.3.1 Проверка отсутствуют элемента {button} под ролью 'public'")
    public void publicAccessButtons (String button)
    {
        initialize();
        webCheckSteps.elementAbsentOnPage(button);
    }

    @Test(dataProvider = "pageElement2")
    @Description("4.3.2 Проверка работоспособности элемента {link} под ролью 'public'")
    public void publicAccessButtons (String pageLink, String pageObject, String headerText)
    {
        initialize();
        webCheckSteps.checkAppearElement(pageLink);
        webSteps.clickOnElement(pageLink);

        webSteps.setPage(pageObject);
        webCheckSteps.textAppearOnThePage(headerText);
    }
}