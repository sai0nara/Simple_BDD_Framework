package api;

import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.ApiSteps;
import steps.Fixture;

import java.util.List;

public class KeySkillTypesTest {
    private static final PageManager pageManager = new PageManager();
    private static final ApiSteps apiSteps = new ApiSteps(pageManager);

    @Test(priority = 1)
    public void testGet() {
        apiSteps.get("key_skill_types");
    }

    @Test(priority = 2)
    public void testPost() {
        apiSteps.postWrap("key_skill_types", "qwerqwerqwer500");
    }

    @Test(priority = 3)
    public void testPatch() {
        apiSteps.patchWrap("key_skill_types","qwerqwerqwer9000", "qwarqwarqwar10000");
    }

    @Test(priority = 4)
    public void testDelete() {
        apiSteps.deleteWrap("key_skill_types", "qwarqwarqwar5000");
    }

    @Test(priority = 5)
    public void testGetEnd() {
        apiSteps.get("key_skill_types");
    }

    @Test(priority = 6)
    public void test() {
        List<String> arr = Fixture.newFixtureGetIdInWrapArray("key_skill_types");
        System.out.println(arr);
    }
}
