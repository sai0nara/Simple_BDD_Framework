package steps;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lanit.at.api.testcontext.ContextHolder;
import ru.lanit.at.web.pagecontext.PageManager;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    private PageManager pageManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiSteps.class);

    public ApiSteps(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    private static String baseUrl=WebSteps.loadProperties().getProperty("base.url");
    private static String username=WebSteps.loadProperties().getProperty("username");
    private static String password=WebSteps.loadProperties().getProperty("password");

    /**
     * Метод для получения токена.
     *
     * @param username - имя пользователя
     * @param password - пароль
     */
    public static void getToken(String username, String password) {
        JSONObject innerBody = new JSONObject();
        innerBody.put("username", username);
        innerBody.put("password", password);
        JsonPath tokenJson = given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(innerBody)
                .when()
                .post("api/otp_token/")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath();
        ContextHolder.put("TOTP", tokenJson.get("otp_token").toString());
//        LOGGER.info("Токен для авторизации - {}", ContextHolder.getValue("TOTP").toString());
    }

    /**
     * Метод для получения auth токена
     *
     * @param username - имя пользователя
     * @param password - пароль
     * @return строковое представление токена
     */
    public static String getAuthToken(String username, String password) {

        JSONObject requestParams = new JSONObject();
        requestParams.put("username", username);
        requestParams.put("password", password);
        JsonPath authTokenJson = given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(requestParams)
                .when()
                .post("api/login/")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath();
        ContextHolder.put("LoginKey", authTokenJson.get("token").toString());
        return "Token " + ContextHolder.getValue("LoginKey").toString();
    }

    /*TODO  Повторяющийся кусок кода-
            ==========================================================
            .baseUri(baseUrl)
            .contentType("application/json")
            .header("Authorization", getAuthToken(username, password))
            ==========================================================
            надо бы вынести в отдельный метод*/

    /**
     * GET for API tests
     * INPUT: endpoint, id, expected HTTP answer code
     * RETURN: all entry of database if "id" is empty string or an entry as JSON
     *
     */
    @Step("Реализация API-метода GET")
    public static void simpleApiGet(String endpoint, String id, Integer httpAnswerCode) {

        JsonPath jsonPath = given()
                .log()
                .all()
                .baseUri(baseUrl)
                .contentType("application/json")
                .header("Authorization", getAuthToken(username, password))
                .when()
                .get(endpoint+id)
                .then()
                .log()
                .all()
                .statusCode(httpAnswerCode)
                .extract()
                .jsonPath();
    }

    /**
     * POST for API tests
     * INPUT endpoint,expected HTTP answer code, request body for POST as JSON object
     */
    @Step("Реализация API-метода POST")
    public static void simpleApiPost(String endpoint, Integer httpAnswerCode,JSONObject requestBody) {

        JsonPath jsonPath = given()
                .log()
                .all()
                .baseUri(baseUrl)
                .contentType("application/json")
                .header("Authorization", getAuthToken(username, password))
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .log()
                .all()
                .statusCode(httpAnswerCode)
                .extract()
                .jsonPath();

        ContextHolder.put("posted_data", jsonPath.get("id").toString());

    }

    /**
     * PATCH for API tests
     * INPUT: endpoint, id entry to path, expected HTTP answer code, request body for POST as JSON object
     * RETURN:
     */

    @Step("Реализация API-метода PATCH")
    public static void simpleApiPatch(String endpoint, String id, Integer httpAnswerCode, JSONObject requestBody) {

        JsonPath changeAccount = given()
                .log()
                .all()
                .baseUri(baseUrl)
                .contentType("application/json")
                .header("Authorization", getAuthToken(username, password))
                .body(requestBody)
                .when()
                .patch(endpoint+id)
                .then()
                .log()
                .all()
                .statusCode(httpAnswerCode)
                .extract()
                .jsonPath();

    }

    @Step("Реализация API-метода DELETE")
    public static void simpleApiDelete(String endpoint, String id, Integer httpAnswerCode) {

                JsonPath deleteAccount = given()
                .log()
                .all()
                .baseUri(baseUrl)
                .contentType("application/json")
                .header("Authorization", getAuthToken(username, password))
                .when()
                .delete(endpoint+id)
                .then()
                .log()
                .all()
                .statusCode(httpAnswerCode)
                .extract()
                .jsonPath();
    }


    }
