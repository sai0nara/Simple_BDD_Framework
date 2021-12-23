package pages.administrators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.*;

/**
 * @link - http://178.154.246.238:58082/admin/core/accountadmin/
 */

@Name("Страница - Администраторы аккаунта")
public class AdministratorsOfAccountPage extends WebPage {

    @Name("Первый сотрудник из списка")
    private SelenideElement firstEmployeeByList = $x("*//tr[1]/th/a");

    @Name("Рандомный сотрудник из списка")
    private ElementsCollection randomEmployeeByList = $$x("//*[@id=\"result_list\"]/tbody/tr/th/a");
}
