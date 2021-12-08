#language:ru
@DjangoAddEmployee
Функционал: Проверка заполняемости поля "Гражданство"
  Предыстория:
    Дано открыть "http://178.154.246.238:58082/"
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

  Сценарий: Проверить активность элемента "Изменить выбранный объект типа ",
  проверить активность элемента "Удалить выбранный объект типа ",
  нажать на "Гражданство", в выпадающем списке "Гражданство" выбрать любое значение,
  проверить активность элемента "Изменить выбранный объект типа ",
  проверить активность элемента "Удалить выбранный объект типа ",

    Дано инициализация страницы "DjangoEmployeeChange"
    Если элемент "Изменить выбранный объект типа Гражданство" не активен из-за отсутствия параметра "<href>"
    И элемент "Удалить выбранный объект типа Гражданство" не активен из-за отсутствия параметра "<href>"
    И в выпадющем списке "Гражданство" выбрать случайный элемент
    То элемент "Изменить выбранный объект типа Гражданство" активен из-за присутствия параметра "<href>"
    И элемент "Удалить выбранный объект типа Гражданство" активен из-за присутствия параметра "<href>"
