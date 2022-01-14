package steps;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import ru.lanit.at.utils.DataGenerator;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.given;
import static steps.ApiSteps.getAuthToken;

public class Fixture {

    /**
     * Вспомогательные методы для создания сотрудника
     *
     */

    public static int getRandom(int range) {
        return (int)(Math.random() * range);
    }

    public static int getRandom(int start, int range) {
        return start + (int)(Math.random() * range);
    }

    public static String getOptionEmployee(int line, int column) {

        String[][] names = new String[][]{
                {"Бородкин", "Заплывший", "Иванов", "Императивченко", "Малафеев", "Оливковый", "Ориентированный", "Сушеный", "Тормозов"},
                {"Битард", "Граф", "Финик", "Семён", "Поц", "Питонщик", "Молодец", "Леблядь", "Иван"},
                {"Моисеевич", "Гопнилович", "Иванович", "Юнисович", "Бугулькович", "Пентестович", "Феофилович", "Малахитович", "Валентинович"},
        };
        return names[line][column];
    }

    public static List<String> newFixture(String endPoint) {
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
        List<String> list = listOfAccounts.getList("id");
        System.out.println(list);
        return list;
    }
    public static List<String> newFixtureGetIdInWrapArray(String endPoint) {
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
        List<String> list = listOfAccounts.getList("key_skills.id");
        System.out.println(list.get(1));
        System.out.println(list);
        return list;
    }

    public static int getCityIdEmployee() {

        int[] idies = new int[]
        {7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44};

        return idies[getRandom(0, idies.length-1)];
    }

    public static int getPositionIdEmployee() {

        int[] positions = new int[]
                {90,132,127,122,118,97,96,95,93,92,91,128,109,110,111,112,113,114,115,119,120,123,126,129,130,131,
                        104,124,106,117,98,101,102,103,82,81,76,77,89,88,87,86,79,133,84,125,83,78,116,108,121,134};

        return positions[getRandom(0, positions.length-1)];
    }

    public static int getProjectIdEmployee() {

        int[] projects = new int[]
                {16,17,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,42,43,44,45,46,47,48,52,
                        53,54,55,56,58,59,60,61,63,64,65,66,67,68,69,70,71,72,74,75,76,77,78,80,81,82,84,85,86,87,88,89,
                        90,91,92,93,94,95,96,97,99,100,101,102,103,104,105,106,107,108,109,111,112,113,114,115,116,117,118,
                        119,120,121,122,123,124,125,126,127,129,130,132,133,134,136,137,138,139,140,141,142,143,144,145,147,
                        148,149,150,153,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,
                        177,178,179,180,181,182,183,184,185};

        return projects[getRandom(0, projects.length-1)];
    }

    public static int getTestTypeEmployee() {

        int[] testTypes = new int[]
                {1, 2, 3, 4, 5};

        int testT = 0;

        if(getPositionIdEmployee() == 108) {
            testT = testTypes[0];
        }
        else if (getPositionIdEmployee() == 121) {
            testT = testTypes[4];
        }
        else if (getPositionIdEmployee()>=76 && getPositionIdEmployee()<=89) {
            testT = testTypes[1];
        }
        else if (getPositionIdEmployee() == 116 || getPositionIdEmployee() == 125 || getPositionIdEmployee() == 133) {
            testT = testTypes[1];
        }
        else if (getPositionIdEmployee()>=98 && getPositionIdEmployee()<=106) {
            testT = testTypes[3];
        }
        else if (getPositionIdEmployee() == 117 || getPositionIdEmployee() == 124) {
            testT = testTypes[3];
        }
        else if (getPositionIdEmployee()>=90 && getPositionIdEmployee()<=97) {
            testT = testTypes[2];
        }
        else if (getPositionIdEmployee() == 118 || getPositionIdEmployee() == 122 ||
                getPositionIdEmployee() == 127 || getPositionIdEmployee() == 132) {
            testT = testTypes[2];
        }
        return testT;
    }

    public static LocalDate getBirthday() {
        LocalDate start = LocalDate.of(1964, Month.JANUARY, 01);
        long startOfEp = start.toEpochDay();
        LocalDate end = LocalDate.now();
        long endOfEp = end.toEpochDay();
        long birth = ThreadLocalRandom
                .current()
                .nextLong(startOfEp, endOfEp);
        return LocalDate.ofEpochDay(birth);
    }

    public static LocalDate getJoinDate() {
        LocalDate start = LocalDate.of(2018, Month.DECEMBER, 04);
        long startOfEp = start.toEpochDay();
        LocalDate end = LocalDate.of(2021, Month.JANUARY, 01);
        long endOfEp = end.toEpochDay();
        long joinDate = ThreadLocalRandom
                .current()
                .nextLong(startOfEp, endOfEp);
        return LocalDate.ofEpochDay(joinDate);
    }

    public static LocalDate getChangeCityDate(LocalDate joinDate) {
        LocalDate start = joinDate;
        long startOfEp = start.toEpochDay();
        LocalDate end = LocalDate.now();
        long endOfEp = end.toEpochDay();
        long changeDate = ThreadLocalRandom
                .current()
                .nextLong(startOfEp, endOfEp);
        return LocalDate.ofEpochDay(changeDate);
    }

    public static String getNumber() {
        return DataGenerator.generateValueByMask("DDDDDDDDDD");
    }

    public static String getMail() {
        return DataGenerator.generateValueByMask("EEEEEDD"+"@"+"test.ru");
    }

    private Map<String, Object> getParameters() {

        Map<String, Object> params = new HashMap<>();

        return params;
    }

    /**
     * Метод меняет переменные, описанные как ${var} на соотвествующие значения из Map,
     где ключ соотвествует имени переменной.
     *
     * @param parameters = Map с параметрами.
     * @param template   = строка, в которой необходимо заменить знаечние.
     * @param <T>
     * @return = строка, в которой выполнена замена.
     */
    public static <T> String replaceVariables(Map<String, Object> parameters, String template) {
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            String parameter = entry.getKey();
            //       String value = entry.getValue().replace("\"", "\\\"");
            //       template = template.replace("${" + parameter + "}", value);
        }
        return template;
    }

    /**
     * Метод для создания сотрудника
     *
     */
    @Step("создание сотрудника")
    public static void createEmployee () {
/*
        JSONObject requestBody = new JSONObject();
        JSONArray reqArray = new JSONArray();

        reqArray.add()


        employee_cities.put("change_date", String.valueOf(getChangeCityDate(getJoinDate())));
        employee_cities.put("city", getCityIdEmployee());


        employee_positions.put("position", getPositionIdEmployee());

        employee_projects.put("project", 185);
        employee_projects.put("testing_type", 2);
        employee_projects.put("start_date", String.valueOf(getJoinDate()));


        requestBody.put("name", getOptionEmployee(1, getRandom(9)));
        requestBody.put("surname", "А");
        requestBody.put("patronymic", getOptionEmployee(2, getRandom(9)));
        requestBody.put("gender", "м");
        requestBody.put("birth", String.valueOf(getBirthday()));
        requestBody.put("joining_date", String.valueOf(getJoinDate()));
        requestBody.put("phone", "+7" + getNumber());
        requestBody.put("internal_email", getMail());

        requestBody.put("employee_cities",
                "[{\"city\": 13, \"change_date\": \"2021-01-15\"}]"
        );
        */

     /*   requestBody.putA("employee_cities", employee_cities);
        requestBody.put("employee_positions", employee_positions);

        if ((getPositionIdEmployee()>=76 && getPositionIdEmployee()<=108) &&
            (getPositionIdEmployee()!=115 && getPositionIdEmployee()!=119 &&
             getPositionIdEmployee()!=120 && getPositionIdEmployee()!=123 &&
             getPositionIdEmployee()!=126 && getPositionIdEmployee()!= 134) &&
            (getPositionIdEmployee()>131)) {

            requestBody.put("employee_projects", employee_projects);
        }

      */

        /*    JsonPath createLoginJson = given()
                    .baseUri("http://178.154.246.238:58082/api")
                    .contentType("application/json")
                    .header("Authorization", getAuthToken("admin", "asdf"))
                    .body(requestBody)
                    .body(employee_cities)
                    .when()
                    .post("/employees/")
                    .then()
                    .statusCode(201)
                    .extract()
                    .jsonPath();

         */
    }
}
