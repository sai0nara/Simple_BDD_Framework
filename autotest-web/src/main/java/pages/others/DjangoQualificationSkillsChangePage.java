package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/qualificationskills/change
 */

@Name(value = "DjangoQualificationSkillsChangePage")
public class DjangoQualificationSkillsChangePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Показатель квалификации для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Показатель квалификации для изменения']");

    }

