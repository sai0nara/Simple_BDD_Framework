#language:ru
@djangoHr
Функционал: Проверка корректности работы блока Города под ролью HR

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

  Сценарий: Нажать кнопку 'Города', в текущем блоке нажать
  на ссылку текстом 'Добавить еще один Город', проверить, что
  в текущем блоке поле 'Город' не заполнено, затем нажать на ссылку
  текстом 'Скрыть', проверить, что поле 'Город' отсутствует

    Дано инициализация страницы "DjangoEmployeeChange"
    Если проскроллить страницу до элемента "Города"
    Тогда нажать на "Города"
    Если на странице имеется элемент "Добавить еще один Город"
    Тогда нажать на "Добавить еще один Город"
    Если чекбокс "Город" отображается и не выбран
    Тогда нажать на "Скрыть"
    Если на странице отсутствует элемент "Город"