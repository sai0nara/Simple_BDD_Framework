package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/projectrole/
 */

@Name(value = "DjangoProjectRolePage")
public class DjangoProjectRolePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Проектная роль для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Проектная роль для изменения']");

    }

