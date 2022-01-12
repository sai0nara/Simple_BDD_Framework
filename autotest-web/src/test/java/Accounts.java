import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.ApiSteps;

public class Accounts {

    private static PageManager pageManager = new PageManager();
    private static ApiSteps apiSteps = new ApiSteps(pageManager);

    @Test
    @Description(value = "проверка корректности получения списка аккаунтов")
    public static void getListOfAccounts() {

        apiSteps.getListOfAccs();

    }

    @Test
    @Description(value = "позитивная проверка корректности создания аккаунта")
    public static void createSomeAccount() {

        apiSteps.createAccount("Alaba");

    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    @Description(value = "негативная проверка корректности создания аккаунта")
    public static void noCreateSomeAccount(){

        apiSteps.createAccount("");

    }

    @Test
    @Description(value = "проверка корректности изменения созданного аккаунта")
    public static void changeCreatedAccount() {

        apiSteps.changeAcc("Алабай-hs","Алабай");

    }

    @Test
    @Description(value = "проверка корректности удаления созданного аккаунта")
    public static void deleteCreatedAccount() {

        apiSteps.deleteAcc("Алаба");

    }

}
