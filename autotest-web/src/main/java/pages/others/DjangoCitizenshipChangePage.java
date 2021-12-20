package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/citizenship/change
 */

@Name(value = "DjangoCitizenshipChangePage")
public class DjangoCitizenshipChangePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Гражданство для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Гражданство для изменения']");

    }

