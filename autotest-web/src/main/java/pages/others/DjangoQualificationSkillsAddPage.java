package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/qualificationskills/add
 */

@Name(value = "DjangoQualificationSkillsAddPage")
public class DjangoQualificationSkillsAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Показатель квалификации")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Показатель квалификации']");

    }

