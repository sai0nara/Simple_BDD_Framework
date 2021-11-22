package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.ru.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.lanit.at.api.testcontext.ContextHolder;
import ru.lanit.at.web.pagecontext.Environment;
import ru.lanit.at.web.pagecontext.PageManager;
import ru.lanit.at.web.pagecontext.WebPage;

import java.util.UUID;

public class AuthorizationSteps {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorizationSteps.class);
    private static String currentToken = "";
    private final PageManager pageManager;

    public AuthorizationSteps(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    @Дано("открыть {string}")
    public void openUrl(String url) {
        Selenide.open(url);
        WebDriver driver = Environment.getDriver();
        if (driver == null) {
            WebDriver currentThreadWebDriver = WebDriverRunner.getWebDriver();
            Environment.setThreadDriver(currentThreadWebDriver);
        }
        LOG.info("init webdriver for thread: {}", Thread.currentThread().getId());
    }

    @Тогда("нажать на чекбокс {string}")
    public void clickOnCheckbox(String elementName) {
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        element.click();
        LOG.info("клик на элемент по тексту '{}'", elementName);
    }

    @Тогда("заполнить поле {string} значением {string}")
    public void fillField(String elementName, String value) {
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        element.setValue(value);
        LOG.info("в поле '{}' введено значение '{}'", elementName, value);
    }

    @И("заполнить поле {string} случайной строкой")
    public void fillFieldRandomString(String field) {
        String randomString = "EXAMPLE_" + UUID.randomUUID().toString();
        fillField(field,randomString );
        ContextHolder.put(field, randomString);
    }

    @И("сравнить значение поля {string} и содержимое ContextHolder")
    public void checkField(String fieldName) {
        String expectedValue = ContextHolder.getValue(fieldName).toString();
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(fieldName);
        String actualValue = element.getValue();
        Assert.assertEquals(actualValue, expectedValue);
       LOG.info("Содержимое поля - {}", actualValue);
    }

    @Тогда("нажать на {string}")
    public void clickSignInButton(String elementName) {
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        element.click();
        LOG.info("клик на элемент по тексту '{}'", elementName);
    }

    @Тогда("инициализация страницы {string}")
    @И("переход на страницу {string}")
    public void setPage(String pageName) {
        WebPage page = Environment.getPage(pageName);
        pageManager.setCurrentPage(page);
    }

    @Тогда("ввести {string} для пользователя {string} с паролем {string}")
    public void fillFieldToken(String elementName, String login, String password) {
        ApiSteps.getToken(login, password);
        String token = ApiSteps.getCurrentToken();
        if (token.equals(currentToken)) {
            fillFieldToken(elementName, login, password);
        } else {
            SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
            element.setValue(token);
            currentToken = token;
            LOG.info("в поле '{}' введено значение '{}'", elementName, token);
        }
    }
}
