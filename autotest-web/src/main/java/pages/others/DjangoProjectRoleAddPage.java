package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/projectrole/add
 */

@Name(value = "DjangoProjectRoleAddPage")
public class DjangoProjectRoleAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Проектная роль")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Проектная роль']");

    }

