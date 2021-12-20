package pages.admin_access;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "DjangoAdminAccessChangeEmployee")
public class DjangoAdminAccessChangeEmployeePage extends WebPage {

    @Name("Инфоблок")
    private SelenideElement infoblock = $x("//div[@id='content']/h1");
}
