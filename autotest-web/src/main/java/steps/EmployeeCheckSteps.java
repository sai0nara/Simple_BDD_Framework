package steps;

import actions.Checks;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.lanit.at.web.pagecontext.PageManager;

public class EmployeeCheckSteps {

    private PageManager pageManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeCheckSteps.class);

    public EmployeeCheckSteps(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    @Если("на текущей странице {string} с текстом {string} присутствует")
    @И("поле {string} инфоблок с текстом {string} присутствует")
    public void matchText(String elementName, String text) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        Checks.elementTextEqualsExpectedText(element, text);
        LOGGER.info("на странице '{}' имеется элемент '{}'", pageManager.getCurrentPage().name(), elementName);
    }

    @Если("в блоке {string} количество записей равно {int}")
    public void matchRecordsNumber(String elementName, int number) {
        ElementsCollection elements = pageManager
                .getCurrentPage()
                .getElementsCollection(elementName);
        Assert.assertEquals(elements.size(), number);
        LOGGER.info("на странице '{}' в блоке '{}' количество записей '{}'", pageManager.getCurrentPage().name(), elementName, number);
    }

    private String getElementText(String elementName, int index) {
        ElementsCollection elements = pageManager
                .getCurrentPage()
                .getElementsCollection(elementName);
        return elements.get(index).getText();
    }

    @Если("при нажатии на кнопку {string} в блоке 'Таблица' в столбце {string}, {int} элемент не изменился")
    public void matchFirstElement(String buttonName, String elementName, int index) {
        String firstResult = getElementText(elementName, index);
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(buttonName);
        element.click();
        String secondResult = getElementText(elementName, index);

        Assert.assertEquals(firstResult, secondResult);
        LOGGER.info("на странице '{}' в блоке '{}' запись '{}' осталась '{}'", pageManager.getCurrentPage().name(), elementName, firstResult, secondResult);
    }

    @Если("в {string} активный номер {string}")
    public void checkCurrentNumber(String elementName, String number) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        Checks.elementTextEqualsExpectedText(element, number);
        LOGGER.info("на странице '{}' в блоке '{}' текущий номер '{}'", pageManager.getCurrentPage().name(), elementName, number);
    }
}
