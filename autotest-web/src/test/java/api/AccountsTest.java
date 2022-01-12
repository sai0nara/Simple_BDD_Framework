package api;

import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.ApiSteps;
import steps.Fixture;

import java.util.List;

public class AccountsTest {
    private static PageManager pageManager = new PageManager();
    private static ApiSteps apiSteps = new ApiSteps(pageManager);

    @Test(priority = 1)
    public void testGet() {
        apiSteps.get("accounts");
    }

//    @Test(priority = 2)
//    public void testPost() {
//        apiSteps.post("accounts", "qwerqwerqwe1");
//    }
//
//    @Test(priority = 3)
//    public void testPatch() {
//        apiSteps.patch("accounts","qwerqwerqw1", "qwarqwarqw2");
//    }
//
//    @Test(priority = 4)
//    public void testDelete() {
//        apiSteps.delete("accounts", "qwarqwarqwar1234567891011121314151617181");
//    }

    @Test(priority = 5)
    public void testGetEnd() {
        apiSteps.get("accounts");
    }

    @Test(priority = 6)
    public void test() {
        List<String> arr = Fixture.newFixture("accounts");
        System.out.println(arr);
    }

//    @Test(priority = 6)
//    public void test1() {
//        apiSteps.testDelete("accounts");
//    }
//
//    @Test(priority = 6)
//    public void test2() {
//        apiSteps.testGet("accounts");
//    }



//    @Test(priority = 1)
//    public void test123() {
//        apiSteps.getById("accounts", "Скайуокер1234");
//    }
}
