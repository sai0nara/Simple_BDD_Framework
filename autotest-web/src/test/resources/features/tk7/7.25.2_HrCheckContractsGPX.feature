#language:ru
@djangoHr
Функционал: Проверка корректности работы блока Договоры ГПХ под ролью HR

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
    Тогда нажать на "Сотрудники"
    Тогда переход на страницу "DjangoEmployee"
    И инициализация страницы "DjangoEmployee"
    Если на странице имеется элемент "Добавить сотрудник"
    Когда нажать на "Добавить сотрудник"
    Тогда переход на страницу "DjangoEmployeeChange"

  Сценарий: Нажать кнопку 'Договоры ГПХ', в текущем блоке нажать
  на ссылку текстом 'Добавить еще один Договор ГПХ', проверить, что
  в текущем блоке поле 'Номер договора' не заполнено, затем нажать на ссылку
  текстом 'Скрыть', проверить, что поле 'Должность' отсутствует

    Дано инициализация страницы "DjangoEmployeeChange"
    Если на странице имеется элемент "Договоры"
    Тогда нажать на "Договоры ГПХ"
    Если на странице имеется элемент "Добавить еще один Договор ГПХ"
    Тогда нажать на "Добавить еще один Договор ГПХ"
    Если поле "Номер договора" отображается и пусто
    Тогда нажать на "Скрыть"
    Если на странице отсутствует элемент "Номер договора"