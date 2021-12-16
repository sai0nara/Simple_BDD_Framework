package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class DjangoPagesHeader extends WebPage {

    @Name("Изменить пароль")
    SelenideElement changePassword = $x("//a[@href='/admin/password_change/']");
    @Name("Выйти")
    SelenideElement logout = $x("//a[@href='/admin/logout/']");

    @Name("Администрирование Django")
    private SelenideElement headerPage = $x("//a[@href='/admin/']");

    @Name("Инфоблок")
    private SelenideElement tableHeader = $x("//div[@id='content']/h1");
// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: Инфоблок
    @Name("Заголовок таблицы")
    private SelenideElement header = $x("//div[@id='content']/h1");

    @Name("Сообщение об ошибке в заголовке")
    private SelenideElement headerError = $x("//p[@class='errornote']");
    @Name("Предупреждение в заголовке")
    private SelenideElement headerWarning = $(By.className("warning"));

    @Name("Сообщение о успешном редактировании")
    private SelenideElement messageOfHeader = $x("//li[@class='success']");
// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: Сообщение о успешном редактировании
    @Name("Сообщение об успешном редактирование")
    private SelenideElement headerSuccess = $(".success");

    @Name("Name")
    private SelenideElement nameOfHeader = $x("//li[@class='success']/a");
}
