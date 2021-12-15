package pages.employee;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "DjangoAdminAccessChangeEmployee")
public class DjangoAdminAccessChangeEmployeePage extends WebPage {

    @Name("Инфоблок")
    private SelenideElement infoblock = $x("//div[@id='content']/h1");
//    @Name("Восстановить удаленный Сотрудники с административным доступом")
//    private SelenideElement buttonRestore = $x("//a[@class='recoverlink']");
//    @Name("Добавить Сотрудник с административным доступом")
//    private SelenideElement buttonAddEmployee = $x("//a[@class='addlink']");
//    @Name("Список сотрудников")
//    private ElementsCollection listEmployee = $$x("//tbody/tr/th/a");
//    @Name("Действие")
//    private SelenideElement dropDownAction = $x("//select[@name='action']");
//    @Name("Выполнить")
//    private SelenideElement buttonExecute = $x("//button[@class='button']");


}
