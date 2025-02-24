#language:ru
@DjangoAdministrationHeader
Функционал: Проверка работоспособности кнопки "Администрирование Django"

  Сценарий: Открытие страницы Django Administration, авторизация от лица админ,
  кликнуть на элемент "Администрирование Django"

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

    Если кликнуть на элемент "Администрирование Django"
    То на странице присутствует текст "Администрирование сайта"


