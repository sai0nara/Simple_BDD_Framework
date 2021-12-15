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

        webCheckSteps.checkElementIsNotExistsOnPage("Проектные ставки_Добавить");
        webCheckSteps.checkElementIsNotExistsOnPage("Сотрудники с административным доступом_Изменить");

        //Проверка отсутствия ссылок заменена на проверку отсутствия секций, содержащих эти ссылки
        webCheckSteps.checkElementIsNotExistsOnPage("Модели в приложении Пользователи и группы");
        webCheckSteps.checkElementIsNotExistsOnPage("Модели в приложении Otp_Totp");

        //Эта проверка провалит тест поскольку указанный элемент есть на странице, нужна чтобы убедится в правильной работе предыдущих проверок
        //webCheckSteps.checkElementIsExistsOnPage("Проектные ставки_Изменить");
    }

    @Test(priority = 2)
    @Description("Проверка работоспособности кнопки \"Изменить\" подраздела \"Сотрудники\" под ролью 'hr'")
    public void checkChangeEmployeesButton() {
        initialize();
        webSteps.clickOnElement("Изменить поле Сотрудники");
        webSteps.setPage("DjangoEmployee");
        webCheckSteps.checkElementIsExistsOnPage("Выберите Сотрудник для изменения");




    }


}
