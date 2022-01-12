package api;

import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.ApiSteps;

public class AchievementsTest {
    private static PageManager pageManager = new PageManager();
    private static ApiSteps apiSteps = new ApiSteps(pageManager);

    @Test(priority = 1)
    public void testGet() {
        apiSteps.get("achievements");
    }

    @Test(priority = 2)
    public void testPost() {
        apiSteps.post("achievements", "qwerqwerqwer");
    }

    @Test(priority = 3)
    public void testPatch() {
        apiSteps.patch("achievements","qwerqwerqwer", "qwarqwarqwar");
    }

    @Test(priority = 4)
    public void testDelete() {
        apiSteps.delete("achievements", "qwarqwarqwar");
    }

    @Test(priority = 5)
    public void testGetEnd() {
        apiSteps.get("achievements");
    }
}
