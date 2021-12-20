package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы

/**
 * ./admin/core/achievement/change
 */

@Name(value = "DjangoAchievementChangePage")
public class DjangoAchievementChangePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Достижение для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Достижение для изменения']");

    }

