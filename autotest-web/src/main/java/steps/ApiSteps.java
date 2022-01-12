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
     * Метод для получения списка аккаунтов
     */
    @Step("полученик списка аккаунтов")
    public void getListOfAccs() {

        JsonPath listOfAccounts = given()
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .when()
                .get("/accounts/")
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath();
    }

    /**
     * Метод для создания аккаунта
     *
     * @param name - имя аккаунта
     */
    @Step("создание аккаунта")
    public void createAccount(String name) {

        if (name.equals("")) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);

        JsonPath createAcc = given()
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .body(requestBody)
                .when()
                .post("/accounts/")
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
                .get("/accounts/{id}/")
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath();
    }

    @Step("изменение созданного аккаунта")
    public void changeAcc(String name, String newName) {

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);

        JsonPath createAcc = given()
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .body(requestBody)
                .when()
                .post("/accounts/")
                .then().log().all()
                .statusCode(201)
                .extract()
                .jsonPath();

        JSONObject reqBody = new JSONObject();
        requestBody.put("name", newName);

        JsonPath changeAccount = given()
                .pathParam("id", createAcc.get("id"))
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .body(reqBody)
                .when()
                .patch("/accounts/{id}/")
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath();
    }

    @Step("удаление созданного аккаунта")
    public void deleteAcc(String name) {

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);

        JsonPath createAcc = given()
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .body(requestBody)
                .when()
                .post("/accounts/")
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
                .delete("/accounts/{id}/")
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
                .get("/accounts/{id}/")
                .then().log().all()
                .statusCode(404)
                .extract()
                .jsonPath();
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

    public void get(String endPoint) {

        JsonPath listOfAccounts = given()
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .when()
                .get(endPoint)
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath();
    }

    public void post(String endPoint, String name) {

        if (name.equals("")) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);

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

    public void patch(String endPoint, String name, String newName) {

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);

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
        requestBody.put("name", newName);

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

    public void delete(String endPoint, String name) {

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);

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

    /**
     * FOR TWO
     */
    public void postForTwo(String endPoint, String name, String description) {

        if (name.equals("")) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("description", description);

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

    public void patchForTwo(String endPoint, String name, String newName, String description, String newDescription) {

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("description", description);

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
        requestBody.put("name", newName);
        requestBody.put("description", newDescription);

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

    public void deleteForTwo(String endPoint, String name, String description) {

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("description", description);

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

    /**
     * Вложенный JSON
     */
    public void postWrap(String endPoint, String name) {

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

    public void patchWrap(String endPoint, String name, String newName) {

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

    public void deleteWrap(String endPoint, String name) {

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