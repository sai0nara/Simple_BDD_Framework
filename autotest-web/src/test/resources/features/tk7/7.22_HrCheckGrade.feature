#language:ru
@djangoHr
Функционал: Проверка корректности работы блока Грейды под ролью HR

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
    Тогда нажать на "Сотрудники"
    Тогда переход на страницу "DjangoEmployee"
    И инициализация страницы "DjangoEmployee"
    Если на странице имеется элемент "Добавить сотрудник"
    Когда нажать на "Добавить сотрудник"
    Тогда переход на страницу "DjangoEmployeeChange"

  Сценарий: Нажать кнопку 'Грейды', в текущем блоке нажать
  на ссылку текстом 'Добавить еще один Грейд', проверить, что
  в текущем блоке поле 'Заметка Грейды' не заполнено, затем нажать на ссылку текстом
  'Скрыть', проверить, что поле 'Заметка Грейды' отсутствует

    Дано инициализация страницы "DjangoEmployeeChange"
    Если проскроллить страницу до элемента "Грейды"
    Тогда нажать на "Грейды"
    Если на странице имеется элемент "Добавить еще один Грейд"
    Тогда нажать на "Добавить еще один Грейд"
    Если чекбокс "Заметка Грейды" отображается и не выбран
    Тогда нажать на "Скрыть"
    Если на странице отсутствует элемент "Заметка Грейды"