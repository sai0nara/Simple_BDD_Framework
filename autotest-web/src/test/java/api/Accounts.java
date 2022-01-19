package api;

import hooks.WebHooks;
import io.qameta.allure.Description;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;
import ru.lanit.at.api.testcontext.ContextHolder;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.ApiSteps;

import java.net.ContentHandler;

public class Accounts {

    private static final PageManager pageManager = new PageManager();
    private static final ApiSteps apiSteps = new ApiSteps(pageManager);

    @Test
    @Description(value = "проверка корректности получения списка аккаунтов")
    public static void getListOfAccounts() {

        ApiSteps.simpleApiGet("api/accounts/","",200);

    }

    @Test
    @Description(value = "позитивная проверка корректности создания аккаунта")
    public static void createSomeAccount() {

        JSONObject newAccount = new JSONObject();
        newAccount.put("name", "Крупный новый банк");

        ApiSteps.simpleApiPost("api/accounts/",201,newAccount);
        ApiSteps.simpleApiGet("api/accounts/", ContextHolder.getValue("posted_data"),200);
        ApiSteps.simpleApiDelete("api/accounts/", ContextHolder.getValue("posted_data"),204);
        ApiSteps.simpleApiGet("api/accounts/", ContextHolder.getValue("posted_data"),404);

    }

    @Test
    @Description(value = "проверка корректности изменения созданного аккаунта")
    public static void changeCreatedAccount() {

        JSONObject newAccount = new JSONObject();
        newAccount.put("name", "Крупный новый банк");

        JSONObject patchedAccount = new JSONObject();
        patchedAccount.put("name", "Надежный и солидный банк");

        ApiSteps.simpleApiPost("api/accounts/",201,newAccount);
        ApiSteps.simpleApiGet("api/accounts/", ContextHolder.getValue("posted_data"),200);
        ApiSteps.simpleApiPatch("api/accounts/",ContextHolder.getValue("posted_data"),200,patchedAccount);
        ApiSteps.simpleApiDelete("api/accounts/", ContextHolder.getValue("posted_data"),204);
        ApiSteps.simpleApiGet("api/accounts/", ContextHolder.getValue("posted_data"),404);

    }

    @Test
    @Description(value = "проверка корректности удаления созданного аккаунта")
    public static void deleteCreatedAccount() {

        JSONObject newAccount = new JSONObject();
        newAccount.put("name", "Крупный новый банк");

        ApiSteps.simpleApiPost("api/accounts/",201,newAccount);
        ApiSteps.simpleApiGet("api/accounts/", ContextHolder.getValue("posted_data"),200);
        ApiSteps.simpleApiDelete("api/accounts/", ContextHolder.getValue("posted_data"),204);
        ApiSteps.simpleApiGet("api/accounts/", ContextHolder.getValue("posted_data"),404);

    }

}
