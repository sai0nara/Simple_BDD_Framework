package pages.employee;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;

@Name(value = "DjangoEmployeeHistoryChange")
public class DjangoEmployeeHistoryChangePage extends WebPage {

    @Name("Список изменений")
    private ElementsCollection listChanges = Selenide.$$x("//th[@scope='row']/a");

    @Name("Города")
    private SelenideElement cities = $("#fieldsetcollapser11");

}

