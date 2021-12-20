package pages.others;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

//URL страницы
/**
 * ./admin/core/employeeprojectsalaryrate/change
 */

@Name(value = "DjangoEmployeeProjectSalaryRateChangePage")
public class DjangoEmployeeProjectSalaryRateChangePage extends WebPage {

    //Подзаголовок страницы
    @Name("Выберите Проектная ставка для изменения")
    private SelenideElement pageContent = $x("//div[@class='flex']//h1[text()='Выберите Проектная ставка для изменения']");

    }

