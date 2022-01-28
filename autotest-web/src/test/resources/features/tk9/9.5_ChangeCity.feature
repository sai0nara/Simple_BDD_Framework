#language:ru
@djangoHr
Функционал: Проверка корректности изменения города сотрудника под ролью HR

  Предыстория:
    Дано открыть сайт
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

  Сценарий: На странице в блоке Города изменить город на значение "Пенза", проверка
  присутствия блока "Дата изменения" и выбор в нем даты "Сегодня", проверка и нажатие
  кнопки "Сохранить и продолжить редактирование", проверка присутствия значения "Пенза"
  в блоке Общей информации в поле "Текущий город"

    Дано инициализация страницы "DjangoEmployeeChange"
    Если проскроллить страницу до элемента "Города"
    Тогда нажать на "Города"
    Если нажать на "Список городов"
    И в выпадающем списке "Список городов" выбрать "Пенза"
    И на странице в блоке "Дата изменения" выбрать элемент "Сегодня2"
    Если проскроллить страницу до элемента "Сохранить и продолжить редактирование"
    Тогда нажать на "Сохранить и продолжить редактирование"
    Если в полях The Сотрудник “ и ” was changed successfully. You may edit it again below. присутствует элемент "Name"
    Тогда проскроллить страницу до элемента "Name"
