package ts8;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.*;

public class ChangingEmployeePositiveTest extends WebHooks {
    private final PageManager pageManager = new PageManager();

    private final AuthorizationSteps authorizationSteps = new AuthorizationSteps(pageManager);
    private final AuthorizationCheckSteps authorizationCheckSteps = new AuthorizationCheckSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);
    private final WebActionSteps webActionSteps = new WebActionSteps(pageManager);
    private final EmployeeSteps employeeSteps = new EmployeeSteps(pageManager);
    private final EmployeeCheckSteps employeeCheckSteps = new EmployeeCheckSteps(pageManager);

    private void initialize() {
        authorizationSteps.openUrl();
        authorizationSteps.setPage("DjangoAuthorization");
        authorizationSteps.authWithLogin("just_employee");
        authorizationCheckSteps.currentTextIsNotExist("Сообщение об ошибке");
        authorizationSteps.setPage("DjangoEmployeeChange");
    }

    @Test(priority = 1)
    @Description("8.1. Проверка редактирования ключевых полей." +
            " Django Administration Роль just_employee")
    public void checkEditingUniqueFieldsPositiveTest() {
        initialize();

        webCheckSteps.checkFieldText("Фамилия", "Бородкин");
        webCheckSteps.checkFieldText("Имя", "Битард");
        webCheckSteps.listCheckedElement("Пол", "Male");
        webCheckSteps.checkElementIsReadOnly("Корпоративная почта");

        webActionSteps.fillTheField("Фамилия", "Бородкина");
        webActionSteps.fillTheField("Имя", "Анастасия");

        employeeSteps.setInDropDown("Пол", "Female");
        webActionSteps.clickOnButton("Сохранить и продолжить редактирование");

        employeeCheckSteps.matchText("Сообщение о успешном редактировании",
                "The Сотрудник “Бородкина Анастасия” was changed successfully. You may edit it again below.");

        webCheckSteps.checkFieldText("Фамилия", "Бородкина");
        webCheckSteps.checkFieldText("Имя", "Анастасия");
        webCheckSteps.listCheckedElement("Пол", "Female");

//        Возврат к первоначальному состоянию
        webActionSteps.fillTheField("Фамилия", "Бородкин");
        webActionSteps.fillTheField("Имя", "Битард");
        employeeSteps.setInDropDown("Пол", "Male");
        webActionSteps.clickOnButton("Сохранить и продолжить редактирование");
    }

    @Test(priority = 2)
    @Description("8.2. Проверка редактирования второстепенных полей." +
            " Django Administration Роль just_employee")
    public void checkEditingSecondFieldsPositiveTest() {
        initialize();

        webActionSteps.fillTheField("Отчество","Валентиновна");
        webActionSteps.fillTheField("Дата приема на работу","20.08.2020");
        webActionSteps.fillTheField("Телефон","+79883456789");
        webActionSteps.fillTheField("День рождения","21.06.1988");
        webActionSteps.listSelectRandElement("Гражданство");
        webActionSteps.clickOnButton("Сохранить и продолжить редактирование");
        employeeCheckSteps.matchText("Сообщение о успешном редактировании",
                "The Сотрудник “Бородкин Битард” was changed successfully. You may edit it again below.");
    }

    @Test(priority = 3)
    @Description("8.3. Проверка добавления фотографии." +
            " Django Administration Роль just_employee")
    public void checkAddingPhotoPositiveTest(){
        initialize();

        String nameOfImage = "test.jpg";
        webActionSteps.uploadFiles("Выберите фото", nameOfImage);
        webCheckSteps.checkNameOfUploadedImage("Проверка имени фото", nameOfImage);
        webActionSteps.clickOnButton("Сохранить и продолжить редактирование");
        employeeCheckSteps.curFieldsContainsThatElement("Name");
        employeeCheckSteps.curFieldsContainsThatElement("Загруженное фото");
        webActionSteps.clickOnButton("Очистить фото");
        webActionSteps.clickOnButton("Сохранить");
    }

    @Test(priority = 4)
    @Description("8.4. Проверка замены загруженной фотографии." +
            " Django Administration Роль just_employee")
    public void checkChangingUploadPhotoPositiveTest(){
        initialize();

        String nameOfImage = "test.png";
        webActionSteps.uploadFiles("Выберите фото", "test.jpg");
        webActionSteps.clickOnButton("Сохранить и продолжить редактирование");
        employeeCheckSteps.curFieldsContainsThatElement("Загруженное фото");
        webActionSteps.uploadFiles("Выберите фото", "test.png");
        webCheckSteps.checkNameOfUploadedImage("Проверка имени фото", nameOfImage);
        webActionSteps.clickOnButton("Сохранить и продолжить редактирование");
        employeeCheckSteps.curFieldsContainsThatElement("Загруженное фото");
        employeeCheckSteps.curFieldsContainsThatElement("Name");
        webActionSteps.clickOnButton("Очистить фото");
        webActionSteps.clickOnButton("Сохранить");
    }

    @Test(priority = 5)
    @Description("8.5. Проверка удаления загруженной фотографии." +
            " Django Administration Роль just_employee")
    public void checkRemovingUploadedPhotoPositiveTest(){
        initialize();

        webActionSteps.uploadFiles("Выберите фото", "test.jpg");
        webActionSteps.clickOnButton("Сохранить и продолжить редактирование");
        employeeCheckSteps.curFieldsContainsThatElement("Загруженное фото");
        webActionSteps.clickOnButton("Очистить фото");
        webActionSteps.clickOnButton("Сохранить и продолжить редактирование");
        employeeCheckSteps.curFieldsContainsThatElement("Name");
        employeeCheckSteps.matchText("Инфоблок фото", "Фотография отсутствует");
        webActionSteps.closeDriver();
    }

    @Test(priority = 6)
    @Description("8.6. Блок \"Квалификация\", проверка редактирования." +
            " Django Administration Роль just_employee")
    public void checkEditingQualityBlockPositiveTest(){
        initialize();

        employeeSteps.scrollToElement("Квалификация");
        webActionSteps
                .clickOnButton("Квалификация");
        employeeSteps.clickRandomN("Все квалификации", 5);
        employeeSteps.unClickRandomN("Все квалификации", 3);
        webActionSteps
                .clickOnButton("Сохранить и продолжить редактирование");
        employeeCheckSteps.matchText("Сообщение о успешном редактировании",
                "The Сотрудник “Бородкин Битард” was changed successfully. You may edit it again below.");
        webActionSteps.closeDriver();
    }

    @Test(priority = 7)
    @Description("8.7. Блок \"Навыки\", проверка редактирования." +
            " Django Administration Роль just_employee")
    public void checkEditingSkillsBlockPositiveTest(){
        initialize();

        employeeSteps.scrollToElement("Навыки");
        webActionSteps
                .clickOnButton("Навыки");
        employeeSteps.clickRandomN("Все навыки", 5);
        employeeSteps.unClickRandomN("Все навыки", 3);
        webActionSteps
                .clickOnButton("Сохранить и продолжить редактирование");
        employeeCheckSteps.matchText("Сообщение о успешном редактировании",
                "The Сотрудник “Бородкин Битард” was changed successfully. You may edit it again below.");
        webActionSteps.closeDriver();
    }

    @Test(priority = 8)
    @Description("8.8. Блок \"Сертификаты\", проверка редактирования." +
            " Django Administration Роль just_employee")
    public void checkEditingCertificatesBlockPositiveTest() {
        initialize();

        employeeSteps.scrollToElement("Сертификаты");
        webActionSteps.clickOnButton("Сертификаты");
        webActionSteps.generateFillTheField("Сертификаты:", "RRRRRRDDDDD");
        webActionSteps.generateFillTheField("Курсы:", "RRRRRRDDDDD");
        webActionSteps
                .clickOnButton("Сохранить и продолжить редактирование");
        employeeCheckSteps.matchText("Сообщение о успешном редактировании",
                "The Сотрудник “Бородкин Битард” was changed successfully. You may edit it again below.");
    }

    @Test(priority = 9)
    @Description("8.9. Блок \"Проекты\", проверка редактирования." +
            " Django Administration Роль just_employee")
    public void checkEditingProjectsBlockPositiveTest() {
        initialize();

        employeeSteps.scrollToElement("Проект");
        webActionSteps
                .clickOnButton("Проект");
        employeeSteps.scrollToElement("Добавить проект");
        webActionSteps
                .clickOnButton("Добавить проект");
        webActionSteps.listSelectRandElement("Выбор проекта");
        webActionSteps.listSelectRandElement("Вид тестирования");
        webActionSteps.listSelectRandElement("Проектная роль");
        webActionSteps.generateFillTheField("Обратная связь", "RRRRRRDDDDD");
        webActionSteps.generateFillTheField("Дата начала", "20.08.2020");
        webActionSteps
                .clickOnButton("Дата окончания: Сегодня");
        webActionSteps.generateFillTheField("Обязанности", "RRRRRRDDDDD");
        webActionSteps
                .clickOnButton("Дата окончания: Сегодня");
        webActionSteps
                .clickOnButton("СТАЖЕР");
        webActionSteps
                .clickOnButton("Сохранить и продолжить редактирование");
        employeeCheckSteps.matchText("Сообщение о успешном редактировании",
                "The Сотрудник “Бородкин Битард” was changed successfully. You may edit it again below.");
    }

    @Test(priority = 10)
    @Description("8.10. Проверка работоспособности кнопки \"СОХРАНИТЬ\"." +
            " Django Administration Роль just_employee")
    public void checkSaveButtonPositiveTest() {
        initialize();

        webActionSteps
                .clickOnButton("Сохранить");

        employeeCheckSteps.matchText("Сообщение о успешном редактировании",
                "The Сотрудник “Бородкин Битард” was changed successfully.");
    }
}
