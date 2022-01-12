package api;

import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.ApiSteps;
import steps.Fixture;

import java.util.List;

// TODO: 18.01.2022 Здесь нужна фикстура
//  Для конкретно этого эндпоинта требуется ID Employees
public class AdministratorsTest {
    private static PageManager pageManager = new PageManager();
    private static ApiSteps apiSteps = new ApiSteps(pageManager);

    @Test(priority = 1)
    public void testGet() {
        apiSteps.get("administrators");
    }

    @Test(priority = 2)
    public void testPost() {
        apiSteps.post("administrators", "qwerqwerqwer1");
    }

    @Test(priority = 3)
    public void testPatch() {
        apiSteps.patch("administrators","qwerqwerqwer1", "qwarqwarqwar1");
    }

    @Test(priority = 4)
    public void testDelete() {
        apiSteps.delete("administrators", "qwarqwarqwar1");
    }

    @Test(priority = 5)
    public void testGetEnd() {
        apiSteps.get("administrators");
    }

    @Test(priority = 6)
    public void test() {
        List<String> arr = Fixture.newFixture("administrators");
        System.out.println(arr);
    }
}
