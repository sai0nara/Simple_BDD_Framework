#language:ru
@DjangoAddEmployee
Функционал: Проверка заполнения поля "Дата приема на работу" через ввод с клавиатуры
  Предыстория:
    Дано открыть сайт
    Тогда инициализация страницы "DjangoAuthorization"

    Если нажать на чекбокс "Я желаю войти с админскими правами"
    То заполнить поле "логин" значением "admin"
    И заполнить поле "пароль" значением "asdf"

    Если на странице имеется элемент "токен"
    Тогда ввести "токен" для пользователя "admin" с паролем "asdf"

    Если на странице имеется элемент "войти"
    Тогда кликнуть на элемент "войти"
    И переход на страницу "DjangoAdministration"

    Если кликнуть на элемент "Сотрудники"
    То инициализация страницы "DjangoEmployee"

    Если кликнуть на элемент "Добавить сотрудник"
    То инициализация страницы "DjangoEmployeeChange"

  Сценарий: Очистить поле 'Дата приема на работу', вести любое значение в формате 'дд.мм.гггг'

    Дано инициализация страницы "DjangoEmployeeChange"
    Если очистить поле "Дата приема на работу"
    То поле "Дата приема на работу" содержит значение ""
    Тогда ввести в поле "Дата приема на работу" значение "18.11.2021"