package pages.user_group_totp;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;
/**
 * PageObject, описывающий страницу 'Пользователи'
 * http://178.154.246.238:58082/admin/auth/user/
 */
@Name(value = "DjangoUser")
public class DjangoUserPage extends WebPage {

    @Name("Инфоблок")
    private SelenideElement infoblock = $x("//div[@id='content']/h1");
}
