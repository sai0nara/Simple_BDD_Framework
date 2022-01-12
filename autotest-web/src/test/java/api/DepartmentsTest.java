package api;

import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.ApiSteps;

public class DepartmentsTest {
    private static PageManager pageManager = new PageManager();
    private static ApiSteps apiSteps = new ApiSteps(pageManager);

    @Test(priority = 1)
    public void testGet() {
        apiSteps.get("departments");
    }

    @Test(priority = 2)
    public void testPost() {
        apiSteps.postForTwo("departments", "qwerqwerqwer1", "description2");
    }

    @Test(priority = 3)
    public void testPatch() {
        apiSteps.patchForTwo("departments","qwerqwerqwer1", "qwerqwerqwer2",
                "description1", "description2");
    }

    @Test(priority = 4)
    public void testDelete() {
        apiSteps.deleteForTwo("departments", "qwerqwerqwer1",
                "qwerqwerqwer2");
    }

    @Test(priority = 5)
    public void testGetEnd() {
        apiSteps.get("departments");
    }
}
