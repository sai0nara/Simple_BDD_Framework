package pages.employee;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "DjangoReturnEmployee")
public class DjangoReturnEmployeePage extends WebPage {

    @Name("Сохранить")
    private SelenideElement save = $x("//input[@name='_save']");

}

