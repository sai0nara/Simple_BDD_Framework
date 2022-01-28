#language:ru
@DjangoAddEmployee
Функционал: Проверка работоспособности кнопки "Добавить ещё один объект типа"  в блоке "Квалификация"
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

  Сценарий: Нажать на 'Показать' в блоке 'Квалификация', нажать на 'Добавить ещё один объект типа',
  проверить наличие инфоблока с текстом 'Добавить Показатель квалификации'

    Дано инициализация страницы "DjangoEmployeeChange"
    Если нажать на "Показать Квалификация"
    И нажать на кнопку "Добавить еще один объект типа Квалификация"
    То инициализация страницы "DjangoQualificationSkills"
    Тогда на странице имеется элемент "Добавить Показатель квалификации"


