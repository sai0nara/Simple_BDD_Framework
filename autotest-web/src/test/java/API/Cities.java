package API;

import io.qameta.allure.Description;
import io.restassured.path.json.JsonPath;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;
import steps.ApiSteps;
import steps.WebSteps;

import static io.restassured.RestAssured.given;


public class Cities {


    private static WebSteps webSteps = new WebSteps();
    private static ApiSteps apiSteps = new ApiSteps();

    private static String baseUrl=webSteps.loadProperties().getProperty("base.url");
    private static String username=webSteps.loadProperties().getProperty("username");
    private static String password=webSteps.loadProperties().getProperty("password");

    @Test()
    @Description("cities GET")
    public static void citiesGet() {

        JsonPath listOfCities = given()
                .log()
                .all()
                .baseUri(baseUrl)
                .contentType("application/json")
                .header("Authorization", apiSteps.getAuthToken(username,password))
                .when()
                .get("/api/employees/")
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .jsonPath();

    }

    @Test()
    @Description("cities POST")
    public static void citiesPost() {


        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Франциско");
        requestBody.put("id", "111");

        JsonPath listOfCities = given()
                .log()
                .all()
                .baseUri(baseUrl)
                .contentType("application/json")
                .header("Authorization", apiSteps.getAuthToken(username,password))
                .body(requestBody)
                .when()
                .post("/api/cities/")
                .then()
                .log()
                .body()
                .statusCode(201)
                .extract()
                .jsonPath();

    }

    @Test()
    @Description("cities GET id")
    public static void citiesGetId() {

        JsonPath listOfCities = given()
                .log()
                .all()
                .baseUri(baseUrl)
                .contentType("application/json")
                .header("Authorization", apiSteps.getAuthToken(username,password))
                .when()
                .get("/api/cities/46")
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .jsonPath();

    }

    @Test()
    @Description("cities PATCH id")
    public void citiesPatchId() {

        JSONObject requestBodyNew = new JSONObject();
        requestBodyNew.put("name", "Лос-Анджелес");

        JsonPath ListOfCities = given()
                .log()
                .all()
                .baseUri(baseUrl)
                .contentType("application/json")
                .header("Authorization", apiSteps.getAuthToken(username,password))
                .body(requestBodyNew)
                .when()
                .post("/api/cities/")
                .then()
                .log()
                .body()
                .statusCode(201)
                .extract()
                .jsonPath();

        JSONObject requestBodyUpdate = new JSONObject();
        requestBodyUpdate.put("name", "Чикаго");

        JsonPath changeCity = given()
                .log()
                .all()
                .pathParam("id", ListOfCities.get("id"))
                .baseUri(baseUrl)
                .contentType("application/json")
                .header("Authorization", apiSteps.getAuthToken(username,password))
                .body(requestBodyUpdate)
                .when()
                .patch("/api/cities/{id}/")
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .jsonPath();

    }

    @Test()
    @Description("cities DELETE id")
    public void citiesDeleteId() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Атланта");

        JsonPath createCity = given()
                .log()
                .all()
                .baseUri(baseUrl)
                .contentType("application/json")
                .header("Authorization", apiSteps.getAuthToken(username,password))
                .body(requestBody)
                .when()
                .post("/api/cities/")
                .then()
                .log()
                .all()
                .statusCode(201)
                .extract()
                .jsonPath();

        JsonPath deleteCity = given()
                .log()
                .all()
                .pathParam("id", createCity.get("id"))
                .baseUri(baseUrl)
                .contentType("application/json")
                .header("Authorization", apiSteps.getAuthToken(username,password))
                .when()
                .delete("/api/cities/{id}/")
                .then()
                .log()
                .all()
                .statusCode(204)
                .extract()
                .jsonPath();

        JsonPath checkCityExists = given()
                .log()
                .all()
                .pathParam("id", createCity.get("id"))
                .baseUri(baseUrl)
                .contentType("application/json")
                .header("Authorization", apiSteps.getAuthToken(username,password))
                .when()
                .get("api/cities/{id}/")
                .then()
                .log()
                .all()
                .statusCode(404)
                .extract()
                .jsonPath();
    }

    @Test()
    @Description("projects POST")
    public static void projectsPost() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Франциско");
        requestBody.put("id", "111");

        JsonPath listOfCities = given()
                .log()
                .all()
                .baseUri(baseUrl)
                .contentType("application/json")
                .header("Authorization", apiSteps.getAuthToken(username,password))
                .body(requestBody)
                .when()
                .post("/api/cities/")
                .then()
                .log()
                .body()
                .statusCode(201)
                .extract()
                .jsonPath();

    }

}
