package pages.employee;

import com.codeborne.selenide.ElementsCollection;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.*;

@Name(value = "DjangoEmployee")
public class DjangoEmployeePage extends WebPage {
    @Name("ФИО")
    private ElementsCollection fio = $$x("//th[@class='field-full_name']/a");
}

