#language:ru
@DjangoAddEmployee
Функционал: Проверка заполняемости ключевых полей блока и создания нового сотрудника
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

  Сценарий: Заполнить ключевые поля, кликнуть на "Сохранить", проверить,
  что сотрудник добавился

    Если ввести в поле "Фамилия" значение "Иванов"
    И ввести в поле "Имя" значение "Иван"
    И ввести в поле "Отчество" значение "Иванович"
    И в выпадющем списке "Пол" выбрать элемент со значением "Male"

    Если нажать на "Сохранить"
    То инициализация страницы "DjangoEmployee"
    И поле "Сообщение об успешном редактирование" инфоблок с текстом "The Сотрудник “Иванов Иван” was added successfully." присутствует

