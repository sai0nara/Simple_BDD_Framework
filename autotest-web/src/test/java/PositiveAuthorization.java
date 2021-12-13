import hooks.WebHooks;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

public class PositiveAuthorization extends WebHooks {

    private static PageManager pageManager = new PageManager();

    @DataProvider
    public Object[][] users() {
        return new Object[][] {
        {"DjangoAuthorization", "just_employee", "Сообщение об ошибке", "DjangoAdministration", "Выйти", "Войти снова"},
        {"DjangoAuthorization", "admin", "Сообщение об ошибке", "DjangoAdministration", "Выйти", "Войти снова"},
        {"DjangoAuthorization", "hr", "Сообщение об ошибке", "DjangoAdministration", "Выйти", "Войти снова"},
        {"DjangoAuthorization", "project1_admin", "Сообщение об ошибке", "DjangoAdministration", "Выйти", "Войти снова"}
        };
    }

    @Test(dataProvider = "users")
    public static void checkAuthorization(String pageOne, String user, String message,
                                      String pageTwo, String buttonOne, String buttonTwo) {
        WebSteps webSteps = new WebSteps(pageManager);
        WebCheckSteps webCheck = new WebCheckSteps(pageManager);

        webSteps.openUrl();
        webSteps.setPage(pageOne);
        webSteps.authWithLogin(user);
        webCheck.currentTextIsNotExist(message);
        webSteps.setPage(pageTwo);
        webCheck.textAppearOnThePage(user);
        webSteps.clickOnElement(buttonOne);
        webSteps.clickOnElement(buttonTwo);
    }

    @Test
    public static void publicAuthor() {
        WebSteps webSteps = new WebSteps(pageManager);
        WebCheckSteps webCheck = new WebCheckSteps(pageManager);

        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("public");
        webCheck.currentTextIsNotExist("Сообщение об ошибке");
        webSteps.setPage("DjangoAdministration");
        webCheck.textAppearOnThePage("employee995");
    }
}
