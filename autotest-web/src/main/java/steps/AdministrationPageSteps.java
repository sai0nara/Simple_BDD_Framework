package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Затем;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lanit.at.web.pagecontext.PageManager;

public class AdministrationPageSteps {

    private PageManager pageManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebActionSteps.class);

    public AdministrationPageSteps(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    @Затем("нажать на ссылку с текстом {string}")
    public void clickOnTheLink(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("нажать на ссылку с текстом '{}'", elementName);
    }
}
