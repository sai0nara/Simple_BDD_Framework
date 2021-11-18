#language:ru
@djangoHr
Функционал: Проверка корректности работы кнопки на странице изменения сотрудника под ролью HR

  Предыстория:
    Дано открыть "http://178.154.246.238:58082/"
    Тогда инициализация страницы "DjangoAuthorization"
    Если чекбокс "Я желаю войти с админскими правами" отображается и не выбран
    Тогда нажать на чекбокс "Я желаю войти с админскими правами"
    Если чекбокс "Я здесь впервые" отображается и не выбран
    Тогда заполнить поле "логин" значением "hr"
    И заполнить поле "пароль" значением "hrmhrm12345"
    Если поле ввода "токен" отображается
    Тогда ввести 'токен' для пользователя "hr" с паролем "hrmhrm12345"
    Если на странице имеется элемент "войти"
    Тогда нажать на "войти"
    Если на странице отсутствует текст "Сообщение об ошибке"
    Тогда переход на страницу "DjangoAdministration"
    И инициализация страницы "DjangoAdministration"
    Если на странице имеется элемент "Сотрудники"
    Когда нажать на "Сотрудники"
    Тогда переход на страницу "DjangoEmployee"
    И инициализация страницы "DjangoEmployee"
    Если на текущей странице в блоке "ФИО" нажать на любую ссылку
    Тогда переход на страницу "DjangoEmployeeChange"

  Сценарий: Нажать кнопку 'Сохранить и продолжить редактирование', проверка присутствия инфоблока
  с текстом 'The Сотрудник “  “ was changed successfully. You may add another Сотрудник below.'

    Дано инициализация страницы "DjangoEmployeeChange"
    Если на странице имеется элемент "Сохранить и продолжить редактирование"
    Тогда нажать на "Сохранить и продолжить редактирование"
    Если в полях The Сотрудник “ и ” was changed successfully. You may edit it again below. присутствует элемент "Name"