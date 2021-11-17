#language:ru
@tk6.x
Функция: Проверка поведения системы при невалидном вводе в поле поиска. Страница "Сотрудники" по ролью HR

  Структура сценария: 1. Открытие страницы http://178.154.246.238:58082/, авторизация под аккаунтом "hr",
  после нажатия на кнопку "Сотрудники", проверить, ввод в поле 'Поиск' значения ‘<qweфыв!>’

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
    Если поле ввода 'Поиск' отображается
    Тогда заполнить поле 'Поиск' значением '<text>'
    Тогда нажать на 'Найти'
    Если в блоке 'ФИО' количество записей равно 0

    Примеры:
      |url                          |login |password    |button     |text      |searchbutton                         |infoblock                         |errorblock                                               |errormessagebox                          |
      |http://178.154.246.238:58082/|hr    |hrmhrm12345 |Сотрудники |qweфыв!   |Сохранить и продолжить редактирование|Пожалуйста, исправьте ошибку ниже.|Введите правильную дату.                                 |Сообщение об ошибке Дата приема на работу|
#      |http://178.154.246.238:58082/|hr    |hrmhrm12345 |Сотрудники |Телефон              |123qweфыв!|Сохранить и продолжить редактирование|Пожалуйста, исправьте ошибку ниже.|Введите корректный номер телефона (пример: +79123456789).|Сообщение об ошибке Телефон              |
#      |http://178.154.246.238:58082/|hr    |hrmhrm12345 |Сотрудники |Email                |123qweфыв!|Сохранить и продолжить редактирование|Пожалуйста, исправьте ошибку ниже.|Введите корректный адрес электронной почты.              |Сообщение об ошибке Email                |
