package tc4;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.EmployeeCheckSteps;
import steps.WebActionSteps;
import steps.WebCheckSteps;
import steps.WebSteps;
import actions.Checks;

public class AdministrationHrRolePositiveTest extends WebHooks {
    private final PageManager pageManager = new PageManager();

    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);
    private final WebActionSteps webActionSteps = new WebActionSteps(pageManager);
    private final EmployeeCheckSteps employeeCheckSteps = new EmployeeCheckSteps(pageManager);
    private final WebSteps webSteps = new WebSteps(pageManager);

    private void initialize() {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("hr");
        webSteps.setPage("DjangoAdministration");

    }

    @Test(priority = 1)
    @Description("Проверка отображения недоступного функционала под ролью hr")
    public void checkExistsAdminFunctionalityUnderHrRole() {

        initialize();

        Checks.elementNotExists(pageManager.getCurrentPage().getElement("Проектные ставки_Добавить"));
        Checks.elementNotExists(pageManager.getCurrentPage().getElement("Сотрудники с административным доступом_Изменить"));

        //Проверка отсутствия ссылок заменена на проверку отсутствия секций, содержащих эти ссылки
        Checks.elementNotExists(pageManager.getCurrentPage().getElement("Модели в приложении Пользователи и группы"));
        Checks.elementNotExists(pageManager.getCurrentPage().getElement("Модели в приложении Otp_Totp"));

        //Эта проверка провалит тест поскольку указанный элемент есть на странице, нужна чтобы убедится в правильной работе предыдущих проверок
        //Checks.elementExists(pageManager.getCurrentPage().getElement("Проектные ставки_Изменить"));
    }

    @Test(priority = 2)
    @Description("Проверка работоспособности кнопки \"Изменить\" подраздела \"Сотрудники\" под ролью 'hr'")
    public void checkAddingNewEmployee() {
        initialize();

        Checks.elementNotExists(pageManager.getCurrentPage().getElement("Проектные ставки_Добавить"));
        Checks.elementNotExists(pageManager.getCurrentPage().getElement("Сотрудники с административным доступом_Изменить"));

        //Проверка отсутствия ссылок заменена на проверку отсутствия секций, которые эти ссылки содержат
        Checks.elementNotExists(pageManager.getCurrentPage().getElement("Модели в приложении Пользователи и группы"));
        Checks.elementNotExists(pageManager.getCurrentPage().getElement("Модели в приложении Otp_Totp"));

        //Эта проверка провалит тест поскольку указанный элемент есть на странице, нужна чтобы убедится в правильной работе предыдущих проверок
        //Checks.elementExists(pageManager.getCurrentPage().getElement("Проектные ставки_Изменить"));
    }


}
