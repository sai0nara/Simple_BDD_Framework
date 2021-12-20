package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/qualificationskilltype/add
 */

@Name(value = "DjangoQualificationSkillTypeAddPage")
public class DjangoQualificationSkillTypeAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Тип квалификации")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Тип квалификации']");

    }

