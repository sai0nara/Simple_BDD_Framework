package actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lanit.at.web.pagecontext.PageManager;
import ru.lanit.at.web.properties.WebConfigurations;
import steps.WebCheckSteps;

import java.time.Duration;

public class AuthorizationChecks {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationChecks.class);
    private PageManager pageManager;

    public AuthorizationChecks(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    private static Integer getTimeoutSeconds(Integer timeout) {
        WebConfigurations cfg = ConfigFactory.create(WebConfigurations.class,
                System.getProperties(),
                System.getenv());
        return timeout == null ? cfg.webDriverTimeoutSeconds() : timeout;
    }

    @Пусть("поле ввода {string} отображается")
    public void checkAppearField(String elementName, Integer timeoutSeconds) {
        int timeout = getTimeoutSeconds(timeoutSeconds);
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        element.shouldBe(Condition.visible, Duration.ofSeconds(timeout));
    }

    @Пусть("чекбокс {string} отображается и не выбран")
    public void checkAppearCheckbox(String elementName, Integer timeoutSeconds) {
        int timeout = getTimeoutSeconds(timeoutSeconds);
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        element.shouldBe(Condition.visible, Duration.ofSeconds(timeout));
        element.shouldNotBe(Condition.selected);
    }

    @Пусть("кнопка {string} отображается")
    public void checkAppearButton(String elementName, Integer timeoutSeconds) {
        int timeout = getTimeoutSeconds(timeoutSeconds);
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        element.shouldBe(Condition.visible, Duration.ofSeconds(timeout));
    }

    @Если("на странице отсутствует текст {string}")
    public void currentTextIsNotExist(String errorText) {
        WebChecks.textAbsentOnPage(errorText);
    }

    @Если("на странице имеется элемент {string}")
    public void elementAppearOnThePage(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        WebChecks.elementVisibleOnPage(element, null);
        LOGGER.info("на странице '{}' имеется элемент '{}'", pageManager.getCurrentPage().name(), elementName);
    }
}
