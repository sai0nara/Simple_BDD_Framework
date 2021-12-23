package ts16;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

public class ChangingAdminOfAccountNegativeTest extends WebHooks {
    private final PageManager pageManager = new PageManager();
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);
    private final WebSteps webSteps = new WebSteps(pageManager);

    private void initialize() {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("hr");
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement("Администраторы аккаунта - ссылка");
        webSteps.setPage("Страница - Администраторы аккаунта");
        webSteps.clickRandom("Рандомный сотрудник из списка");
        webSteps.setPage("Страница - Изменить Администратор аккаунта");
    }

    @Test
    @Description("1.6.1. Роль HR. Проверка поведения системы при не заполнении ключевых полей.")
    public void checkSystemNonFillMainFields() {
        initialize();

        webSteps.selectElementInDropDown("Поле: Сотрудник", "---------");
        webSteps.selectElementInDropDown("Поле: Аккаунт", "---------");
        webSteps.clearField("Поле: Дата начала");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.checkAppearElement("Сообщение об ошибке: Пожалуйста, исправьте ошибки ниже");
        webCheckSteps.checkAppearElement("Сотрудник: Это поле обязательно");
        webCheckSteps.checkAppearElement("Аккаунт: Это поле обязательно");
        webCheckSteps.checkAppearElement("Дата начала: Это поле обязательно");
    }

    @DataProvider
    public Object[][] dataProviderNegativeTest() {
        return new Object[][] {
                {"Поле: Дата начала", "123qweфыв!", "Сохранить и продолжить редактирование",
                "Сообщение об ошибке: Пожалуйста, исправьте ошибки ниже", "Введите правильную дату: Дата начала"},
                {"Поле: Дата окончания", "123qweфыв!", "Сохранить и продолжить редактирование",
                "Сообщение об ошибке: Пожалуйста, исправьте ошибки ниже", "Введите правильную дату: Дата окончания"}
        };
    }

    @Test(dataProvider = "dataProviderNegativeTest")
    @Description("1.6.2 - 1.6.3. Роль HR. Проверка поведения системы при невалидном заполнении поля " +
            "Дата начала/Дата окончания.")
    public void checkSystemFillInvalidDateOfStartAndEnd(String f, String s,
                                                        String t, String four, String five) {
        initialize();

        webSteps.fillField(f, s);
        webSteps.clickOnElement(t);
        webCheckSteps.checkAppearElement(four);
        webCheckSteps.checkAppearElement(five);
    }
}
