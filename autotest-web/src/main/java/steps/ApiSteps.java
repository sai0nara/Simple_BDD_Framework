package steps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
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
    private static JsonPath jsonPath = null;

    public ApiSteps(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    public static void authorization() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://178.154.246.238:58082/api")
                .addHeader("Authorization", getAuthToken("admin", "asdf"))
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
                .baseUri("http://178.154.246.238:58082/")
                .contentType("application/json")
                .body(innerBody)
                .when()
                .post("api/otp_token/")
                .then().log().all()
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
                .baseUri("http://178.154.246.238:58082/api/")
                .contentType("application/json")
                .body(requestParams)
                .when()
                .post("login/")
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath();
        ContextHolder.put("LoginKey", authTokenJson.get("token").toString());
        return "Token " + ContextHolder.getValue("LoginKey").toString();
    }

    /**
     * Метод для получения списка сотрудников
     */
    @Step("получение списка сотрудников")
    public void getListOfEmployees () {

        JsonPath listOfEmployees = given()
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .when()
                .get("/employees/")
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath();
    }

    private void getPattern(String endPoint) {
                authorization();
                given()
                .when()
                .get(endPoint)
                .then().log().all()
                .statusCode(200);
    }
    private void getByIdPattern(String endPoint, String name) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);

        authorization();
        jsonPath = given()
                .body(requestBody)
                .when()
                .post(endPoint)
                .then().log().all()
                .statusCode(201)
                .extract()
                .jsonPath();
        System.out.println("СИСТЕМ АУТ ПРИНТЛН" + jsonPath.get("id"));

        authorization();
        given()
                .when()
                .pathParam("id", jsonPath.get("id"))
                .get("/" + endPoint+"/{id}/")
                .then().log().all()
                .statusCode(200);
    }
    private void postPattern(String endPoint, String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);

        authorization();
        jsonPath = given()
                .body(requestBody)
                .when()
                .post(endPoint)
                .then().log().all()
                .statusCode(201)
                .extract()
                .jsonPath();
    }

    private static void patchPattern(String endPoint, String oldName, String newName) {
        authorization();
        given()
                .when()
                .pathParam("id", jsonPath.get("id"))
                .patch("/" + endPoint+"/{id}/")
                .then().log().all()
                .statusCode(200);
    }

    private void deletePattern(String endPoint, String name) {
        authorization();
        given()
                .when()
                .delete("/" + endPoint+"/{id}/")
                .then().log().all()
                .statusCode(204);
    }

    public void get(String endPoint) {
        getPattern(endPoint);
    }

    public void getById(String endPoint, String name) {
        getByIdPattern(endPoint, name);
    }

    public void post(String endPoint, String name) {
        postPattern(endPoint, name);
    }

    public void patch(String endPoint, String oldName, String newName) {
        patchPattern(endPoint, oldName, newName);
    }

    public void delete(String endPoint, String name) {
        deletePattern(endPoint, name);
    }

    /**
     * Вложенный JSON
     */
    public void postForKeySkillTypes(String endPoint, String name) {

        if (name.equals("")) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }

        JSONObject requestBody = new JSONObject();
        JSONObject requestBodyWrap = new JSONObject();
        requestBodyWrap.put("name", name);
        requestBody.put("name", name);
        requestBody.put("key_skills", new JSONObject[]{requestBodyWrap});

        JsonPath createAcc = given()
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .body(requestBody)
                .when()
                .post(endPoint)
                .then().log().all()
                .statusCode(201)
                .extract()
                .jsonPath();
        ContextHolder.put("newAccID", createAcc.get("id").toString());
        JsonPath checkAccount = given()
                .pathParam("id", createAcc.get("id"))
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .when()
                .get("/" + endPoint+"/{id}/")
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath();

        JsonPath deleteAccount = given()
                .pathParam("id", createAcc.get("id"))
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .when()
                .delete("/" + endPoint+"/{id}/")
                .then().log().all()
                .statusCode(204)
                .extract()
                .jsonPath();
    }

    public void patchForKeySkillTypes(String endPoint, String name, String newName) {

        JSONObject requestBody = new JSONObject();
        JSONObject requestBodyWrap = new JSONObject();
        requestBodyWrap.put("name", name);
        requestBody.put("name", name);
        requestBody.put("key_skills", new JSONObject[]{requestBodyWrap});

        JsonPath createAcc = given()
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .body(requestBody)
                .when()
                .post(endPoint)
                .then().log().all()
                .statusCode(201)
                .extract()
                .jsonPath();

        JSONObject reqBody = new JSONObject();
        JSONObject reqBodyWrap = new JSONObject();
        reqBodyWrap.put("name", newName);
        reqBody.put("name", newName);
        reqBody.put("key_skills", new JSONObject[]{reqBodyWrap});

        JsonPath changeAccount = given()
                .pathParam("id", createAcc.get("id"))
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .body(reqBody)
                .when()
                .patch("/" + endPoint+"/{id}/")
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath();

        JsonPath deleteAccount = given()
                .pathParam("id", createAcc.get("id"))
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .when()
                .delete("/" + endPoint+"/{id}/")
                .then().log().all()
                .statusCode(204)
                .extract()
                .jsonPath();
    }

    public void deleteForKeySkillTypes(String endPoint, String name) {

        JSONObject requestBody = new JSONObject();
        JSONObject requestBodyWrap = new JSONObject();
        requestBodyWrap.put("name", name);
        requestBody.put("name", name);
        requestBody.put("key_skills", new JSONObject[]{requestBodyWrap});

        JsonPath createAcc = given()
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .body(requestBody)
                .when()
                .post(endPoint)
                .then().log().all()
                .statusCode(201)
                .extract()
                .jsonPath();

        JsonPath deleteAccount = given()
                .pathParam("id", createAcc.get("id"))
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .when()
                .delete("/" + endPoint+"/{id}/")
                .then().log().all()
                .statusCode(204)
                .extract()
                .jsonPath();

        JsonPath checkAccount = given()
                .pathParam("id", createAcc.get("id"))
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .when()
                .get("/" + endPoint+"/{id}/")
                .then().log().all()
                .statusCode(404)
                .extract()
                .jsonPath();
    }
}