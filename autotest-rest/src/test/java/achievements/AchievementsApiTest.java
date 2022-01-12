package achievements;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.minidev.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.lanit.at.api.testcontext.ContextHolder;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class AchievementsApiTest {
//    @BeforeTest
//    public void prepare() throws IOException {
//        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my.properties"));
//
//        RestAssured.requestSpecification = new RequestSpecBuilder()
//                .setBaseUri("http://178.154.246.238:58082/api/")
//                .addHeader("api_key", System.getProperty("api.key"))
//                .setAccept(ContentType.JSON)
//                .setContentType(ContentType.JSON)
//                .log(LogDetail.ALL)
//                .build();
//
//        RestAssured.filters(new ResponseLoggingFilter());
//    }

//    public static void getToken(String username, String password) {
//        JSONObject innerBody = new JSONObject();
//        innerBody.put("username", username);
//        innerBody.put("password", password);
//        JsonPath tokenJson = given()
//                .baseUri("http://178.154.246.238:58082/")
//                .contentType("application/json")
//                .body(innerBody)
//                .when()
//                .post("api/otp_token/")
//                .then()
//                .statusCode(200)
//                .extract()
//                .jsonPath();
//        ContextHolder.put("TOTP", tokenJson.get("otp_token").toString());
////        LOGGER.info("Токен для авторизации - {}", ContextHolder.getValue("TOTP").toString());
//    }

    @Test
    public static String getAuthToken() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("username", "admin");
        requestParams.put("password", "asdf");
        JsonPath authTokenJson = given()
                .baseUri("http://178.154.246.238:58082/")
                .contentType("application/json")
                .body(requestParams)
                .when()
                .post("login/")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath();
        ContextHolder.put("LoginKey", authTokenJson.get("token").toString());
        return "Token " + ContextHolder.getValue("LoginKey").toString();
    }

}
