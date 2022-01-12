package api;

import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.ApiSteps;
import steps.Fixture;

import java.util.List;

public class OrganizationsTest {
    private static final PageManager pageManager = new PageManager();
    private static final ApiSteps apiSteps = new ApiSteps(pageManager);
    private static final String endpoint = "organizations";

    @Test(priority = 1)
    public void testGet() {
        apiSteps.get(endpoint);
    }

    @Test(priority = 2)
    public void testPost() {
        apiSteps.post(endpoint, "qwerqwerqwer1");
    }

    @Test(priority = 3)
    public void testPatch() {
        apiSteps.patch(endpoint,"qwerqwerqwer1", "qwarqwarqwar1");
    }

    @Test(priority = 4)
    public void testDelete() {
        apiSteps.delete(endpoint, "qwarqwarqwar1");
    }

    @Test(priority = 5)
    public void testGetEnd() {
        apiSteps.get(endpoint);
    }

    @Test(priority = 6)
    public void test() {
        List<String> arr = Fixture.newFixture(endpoint);
        System.out.println(arr);
    }
}
