#language:ru
@tk7.31
Функция: Проверка поведения системы при добавлении сотрудника. Страница "Сотрудники" по ролью HR

  Структура сценария: 1. Открытие страницы http://178.154.246.238:58082/, авторизация под аккаунтом "hr",
  после нажатия на кнопку "Сотрудники", на текущей странице нажать на кнопку с текстом 'ДОБАВИТЬ НОВЫЙ СОТРУДНИК+',
  проверка блока 'Фактические отпуска'

    Дано открыть '<url>'
    Тогда инициализация страницы 'DjangoAuthorization'
    Если чекбокс 'Я желаю войти с админскими правами' отображается и не выбран
    Тогда нажать на чекбокс 'Я желаю войти с админскими правами'
    Если поле ввода 'логин' отображается
    Тогда заполнить поле 'логин' значением '<login>'
    Если поле ввода 'пароль' отображается
    Тогда заполнить поле 'пароль' значением '<password>'
    Если поле ввода 'токен' отображается
    Тогда ввести 'токен' для пользователя '<login>' с паролем '<password>'
    Если кнопка 'войти' отображается
    Тогда нажать на 'войти'
    Тогда инициализация страницы 'DjangoAdministration'
    Если кнопка '<button>' отображается
    Тогда нажать на '<button>'
    Тогда инициализация страницы 'DjangoEmployee'
    И нажать на 'Добавить сотрудник'
    Тогда инициализация страницы 'DjangoEmployeeChange'
    И нажать на 'Фактические отпуска'
    Если в текущем блоке поле 'Заметка' заблокировано
    Тогда нажать на 'Скрыть отпуска'
    Тогда в текущем блоке поле 'Заметка' отсутствует

    Примеры:
      |url                          |login |password    |button     |
      |http://178.154.246.238:58082/|hr    |hrmhrm12345 |Сотрудники |
