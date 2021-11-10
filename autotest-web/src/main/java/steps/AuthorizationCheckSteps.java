package steps;

import actions.Checks;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Если;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lanit.at.web.pagecontext.PageManager;

public class AuthorizationCheckSteps {

    private PageManager pageManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationCheckSteps.class);

    public AuthorizationCheckSteps(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    @Если("чекбокс {string} отображается и не выбран")
    public void checkAppearCheckbox(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        Checks.elementVisibleAndNoSelected(element);
        LOGGER.info("на странице '{}' имеется элемент '{}'", pageManager.getCurrentPage().name(), elementName);
    }

    @Если("поле ввода {string} отображается")
    @Если("поле {string} отображается")
    @Если("кнопка {string} отображается")
    public void checkAppearElement(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        Checks.elementVisible(element);
        LOGGER.info("на странице '{}' имеется элемент '{}'", pageManager.getCurrentPage().name(), elementName);
    }
}
