package steps.will_be_removed;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lanit.at.web.pagecontext.PageManager;

@Deprecated
public class WebActionSteps {

    private PageManager pageManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebActionSteps.class);

    public WebActionSteps(PageManager manager) {
        this.pageManager = manager;
    }

    @И("в выпадющем списке {string} выбрать элемент со значением {string}")
    public void listSelectElement(String elementName, String text){
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
                element.selectOptionContainingText(text);
        LOGGER.info("в выпадющем списке {} выбран элемент со значением {}", elementName, text);
    }

    @И("нажать на {string}")
    @И("кликнуть на элемент {string}")
    @И("нажать на кнопку {string}")
    public void clickOnButton(String elementName) {
        pageManager
                .getCurrentPage()
                .getElement(elementName)
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик на элемент '{}'", elementName);
    }

    @И("ввести в поле {string} значение {string}")
    public void fillTheField(String field, String value) {
        SelenideElement fieldElement = pageManager
                .getCurrentPage()
                .getElement(field);
        fieldElement
                .shouldBe(Condition.visible)
                .setValue(value);
        LOGGER.info("в поле '{}' введено значение '{}'", field, value);
    }

}
