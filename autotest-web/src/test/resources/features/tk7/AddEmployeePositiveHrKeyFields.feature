#language:ru
@tk7.31
Функция: Проверка поведения системы при добавлении сотрудника. Страница "Сотрудники" по ролью HR

  Структура сценария: 1. Открытие страницы http://178.154.246.238:58082/, авторизация под аккаунтом "hr",
  после нажатия на кнопку "Сотрудники", на текущей странице нажать на кнопку с текстом 'ДОБАВИТЬ НОВЫЙ СОТРУДНИК+'

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

    Если поле ввода 'Поиск' отображается
    Тогда заполнить поле 'Поиск' значением '<text>'
    Тогда нажать на 'Найти'
    Если в блоке 'ФИО' количество записей равно 0

    Примеры:
      |url                          |login |password    |button     |text      |searchbutton                         |infoblock                         |errorblock                                               |errormessagebox                          |
      |http://178.154.246.238:58082/|hr    |hrmhrm12345 |Сотрудники |qweфыв!   |Сохранить и продолжить редактирование|Пожалуйста, исправьте ошибку ниже.|Введите правильную дату.                                 |Сообщение об ошибке Дата приема на работу|
