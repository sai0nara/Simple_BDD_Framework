package api;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import io.restassured.path.json.JsonPath;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lanit.at.api.testcontext.ContextHolder;
import ru.lanit.at.web.pagecontext.PageManager;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    private static String token = "";
    private PageManager pageManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiSteps.class);

    public ApiSteps(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    public static void getToken(String username,String password) {
        JSONObject innerBody = new JSONObject();
        innerBody.put("username", username);
        innerBody.put("password", password);
        JsonPath tokenJson = given()
                .baseUri("http://178.154.246.238:58082/")
                .contentType("application/json")
                .body(innerBody)
                .when()
                .post("api/otp_token/")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath();
        ContextHolder.put("TOTP", tokenJson.get("otp_token").toString());
        token = ContextHolder.getValue("TOTP").toString();
        LOGGER.info("Токен для авторизации - {}", ContextHolder.getValue("TOTP").toString());
    }

    @Тогда("ввести {string} для пользователя {string} с паролем {string}")
    public void fillFieldToken(String elementName, String login, String password) {
        getToken(login, password);
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        element.setValue(token);
        LOGGER.info("в поле '{}' введено значение '{}'", elementName, token);
    }

    public static void main(String[] args) {
        System.out.println(token);
        getToken("admin", "asdf");
        System.out.println(token);
    }
}
