#language:ru
@DjangoAddEmployee
Функционал: Проверка заполняемости блока "Навыки"
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

  Сценарий: Нажать на ссылку с текстом 'Показать' в блоке 'Навыки',
  активировать <3> случайных чек-бокса, нажать на 'Скрыть',
  проверить отсутствие на странице чек-бокса 'Языки программирования: C# 5.0'

    Дано инициализация страницы "DjangoEmployeeChange"
    Затем нажать на "Показать Навыки"
    И активировать в чек-лист "Список навыков" чекбокс "Языки программирования: Golang"
    И активировать в чек-лист "Список навыков" чекбокс "Языки программирования: PHP"
    И активировать в чек-лист "Список навыков" чекбокс "Фреймворки АТ: TestNG"
    Затем нажать на "Скрыть Навыки"
    И на странице отсутствует элемент "Языки программирования: C# 5.0"

