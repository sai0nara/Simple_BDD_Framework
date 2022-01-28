#language:ru
@djangoHr
Функционал: Проверка корректности работы блока Предыдущий опыт работы под ролью HR

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

  Сценарий: Нажать кнопку 'Предыдущий опыт работы', в текущем блоке нажать
  на ссылку текстом 'Добавить еще один Предыдущий опыт работы', проверить, что
  в текущем блоке поле 'Название организации' не заполнено, затем нажать на ссылку
  текстом 'Скрыть', проверить, что поле 'Название организации' отсутствует

    Дано инициализация страницы "DjangoEmployeeChange"
    Если проскроллить страницу до элемента "Предыдущий опыт работы"
    Тогда нажать на "Предыдущий опыт работы"
    Если на странице имеется элемент "Добавить еще один Предыдущий опыт работы"
    Тогда нажать на "Добавить еще один Предыдущий опыт работы"
    Если чекбокс "Название организации опыта" отображается и не выбран
    Тогда нажать на "Скрыть"
    Если на странице отсутствует элемент "Название организации опыта"