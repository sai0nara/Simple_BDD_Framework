package api;

import io.qameta.allure.Description;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;
import ru.lanit.at.api.testcontext.ContextHolder;
import steps.ApiSteps;

public class Accounts extends BaseApiTest {
    @Test
    @Description(value = "проверка корректности получения списка аккаунтов")
    public static void getListOfAccounts1() {

        ApiSteps.simpleApiGet("api/accounts/",200);

    }

    @Test
    @Description(value = "проверка корректности получения списка аккаунтов")
    public static void getListOfAccounts() {

        ApiSteps.simpleApiGetById("api/accounts/","",200);

    }

    @Test
    @Description(value = "позитивная проверка корректности создания аккаунта")
    public static void createSomeAccount() {

        JSONObject newAccount = new JSONObject();
        newAccount.put("name", "Крупный новый банк1234");

        ApiSteps.simpleApiPost("api/accounts/",201,newAccount);
        ApiSteps.simpleApiGetById("api/accounts/", ContextHolder.getValue("posted_data"),200);
        ApiSteps.simpleApiDelete("api/accounts/", ContextHolder.getValue("posted_data"),204);
        ApiSteps.simpleApiGetById("api/accounts/", ContextHolder.getValue("posted_data"),404);

    }

    @Test
    @Description(value = "проверка корректности изменения созданного аккаунта")
    public static void changeCreatedAccount() {

        JSONObject newAccount = new JSONObject();
        newAccount.put("name", "Крупный новый банк2123");

        JSONObject patchedAccount = new JSONObject();
        patchedAccount.put("name", "Надежный и солидный банк");

        ApiSteps.simpleApiPost("api/accounts/",201,newAccount);
        ApiSteps.simpleApiGetById("api/accounts/", ContextHolder.getValue("posted_data"),200);
        ApiSteps.simpleApiPatch("api/accounts/",ContextHolder.getValue("posted_data"),200,patchedAccount);
        ApiSteps.simpleApiDelete("api/accounts/", ContextHolder.getValue("posted_data"),204);
        ApiSteps.simpleApiGetById("api/accounts/", ContextHolder.getValue("posted_data"),404);

    }

    @Test
    @Description(value = "проверка корректности удаления созданного аккаунта")
    public static void deleteCreatedAccount() {

        JSONObject newAccount = new JSONObject();
        newAccount.put("name", "Крупный новый банк2123");

        ApiSteps.simpleApiPost("api/accounts/",201,newAccount);
        ApiSteps.simpleApiGetById("api/accounts/", ContextHolder.getValue("posted_data"),200);
        ApiSteps.simpleApiDelete("api/accounts/", ContextHolder.getValue("posted_data"),204);
        ApiSteps.simpleApiGetById("api/accounts/", ContextHolder.getValue("posted_data"),404);

    }

}
