package steps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
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

    private static final String baseUrl = WebSteps.loadProperties().getProperty("base.url");
    private static final String username = WebSteps.loadProperties().getProperty("username");
    private static final String password = WebSteps.loadProperties().getProperty("password");

    public static void authorization() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addHeader("Authorization", getAuthToken(username, password))
                .setContentType(ContentType.JSON)
                .build();
    }

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
        JsonPath authTokenJson = given().log().all()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(requestParams)
                .when()
                .post("api/login/")
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath();
        ContextHolder.put("LoginKey", authTokenJson.get("token").toString());
        return "Token " + ContextHolder.getValue("LoginKey").toString();
    }

    /**
     * GET for API tests
     * INPUT: endpoint, id, expected HTTP answer code
     * RETURN: all entry of database if "id" is empty string or an entry as JSON
     */
    @Step("Реализация API-метода GET")
    public static void simpleApiGet(String endpoint, Integer statusCode) {
        given()
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .statusCode(statusCode);
    }

    /**
     * GET for API tests
     * INPUT: endpoint, id, expected HTTP answer code
     * RETURN: all entry of database if "id" is empty string or an entry as JSON
     */
    @Step("GET-запрос на эндпоинт - {endpoint} с id = {id}, ожидается статус-код - {status-code}")
    public static void simpleApiGetById(String endpoint, String id, Integer statusCode) {
        given()
                .log().all()
                .when()
                .get(endpoint + id)
                .then()
                .log()
                .all()
                .statusCode(statusCode);
    }

    /**
     * POST for API tests
     * INPUT endpoint,expected HTTP answer code, request body for POST as JSON object
     */
    @Step("POST-запрос на эндпоинт - {endpoint} с id = {id}, ожидается статус-код - {status-code}")
    public static void simpleApiPost(String endpoint, Integer statusCode, JSONObject requestBody) {

        JsonPath jsonPath = given()
                .log().all()
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .statusCode(statusCode)
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
    public static void simpleApiPatch(String endpoint, String id, Integer statusCode, JSONObject requestBody) {

        given()
                .log().all()
                .body(requestBody)
                .when()
                .patch(endpoint + id)
                .then()
                .log()
                .all()
                .statusCode(statusCode);

    }

    @Step("Реализация API-метода DELETE")
    public static void simpleApiDelete(String endpoint, String id, Integer statusCode) {

        given()
                .log().all()
                .when()
                .delete(endpoint + id)
                .then()
                .log()
                .all()
                .statusCode(statusCode);
    }


}
