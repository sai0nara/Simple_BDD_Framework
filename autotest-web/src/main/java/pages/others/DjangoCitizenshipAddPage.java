package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/citizenship/add
 */

@Name(value = "DjangoCitizenshipAddPage")
public class DjangoCitizenshipAddPage extends WebPage {

    //Подзаголовок страницы
    @Name("Добавить Гражданство")
    private SelenideElement pageContent = $x("//div[@class='colM']//h1[text()='Добавить Гражданство']");

    }

