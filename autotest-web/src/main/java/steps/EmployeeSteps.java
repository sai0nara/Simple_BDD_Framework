package steps;

import actions.WebActions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lanit.at.web.pagecontext.PageManager;

public class EmployeeSteps {

    private PageManager pageManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeSteps.class);

    public EmployeeSteps(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    @И("на текущей странице в блоке {string} нажать на любую ссылку")
    public void clickRandom(String elementName) {
         ElementsCollection elements = pageManager
                .getCurrentPage()
                .getElementsCollection(elementName);
        elements.get(WebActions.getRandom(elements.size())).click();
        LOGGER.info("на странице '{}' имеется элемент '{}'", pageManager.getCurrentPage().name(), elementName);
    }

    @Затем("на текущей странице в блоке Общая информация очистить все поля: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void clearFieldsEmployee(String surname, String name, String patronymic, String gender, String joiningDate, String birthday, String phone, String citizenship, String email) throws InterruptedException {

        SelenideElement surnameField = pageManager
                .getCurrentPage()
                .getElement(surname);
        SelenideElement nameField = pageManager
                .getCurrentPage()
                .getElement(name);
        SelenideElement patronymicField = pageManager
                .getCurrentPage()
                .getElement(patronymic);
        SelenideElement genderDropdown = pageManager
                .getCurrentPage()
                .getElement(gender);
        SelenideElement joiningDateField = pageManager
                .getCurrentPage()
                .getElement(joiningDate);
        SelenideElement birthdayField = pageManager
                .getCurrentPage()
                .getElement(birthday);
        SelenideElement phoneField = pageManager
                .getCurrentPage()
                .getElement(phone);
        SelenideElement citizenshipDropdown = pageManager
                .getCurrentPage()
                .getElement(citizenship);
        SelenideElement emailField = pageManager
                .getCurrentPage()
                .getElement(email);
        surnameField.clear();
        nameField.clear();
        patronymicField.clear();
        genderDropdown.clear();
        joiningDateField.clear();
        birthdayField.clear();
        phoneField.clear();
        citizenshipDropdown.clear();
        emailField.clear();

        Thread.sleep(10000L);
        LOGGER.info("на странице '{}' имеются элементы '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}'", pageManager.getCurrentPage().name(), surname, name, patronymic, gender, joiningDate, birthday, phone, citizenship, email);
    }
}
