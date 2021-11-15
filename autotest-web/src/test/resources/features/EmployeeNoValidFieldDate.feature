#language:ru
@tk10.3
Функция: Проверка поведения системы при не заполнении ключевых полей. Закладка "Изменить сотрудника" по ролью HR

  Структура сценария: Открытие страницы http://178.154.246.238:58082/, авторизация под аккаунтом "hr",
  после нажатия на кнопку "Сотрудники", проверить, как отрабатывает система при не заполнении ключевых полей.

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
    И на текущей странице в блоке 'ФИО' нажать на любую ссылку
    Тогда инициализация страницы 'DjangoEmployeeChange'
    Затем заполнить поле 'Дата приема на работу' значением '<text>'
    Тогда нажать на кнопку '<savebutton>'
    Если на текущей странице 'Сообщение об ошибке в заголовке' с текстом '<infoblock>' присутствует
    И поле 'Сообщение об ошибке Дата приема на работу' инфоблок с текстом '<errorblock>' присутствует

    Примеры:
      |url                          |login |password    |button     |text      |savebutton                           |infoblock                         |errorblock              |
      |http://178.154.246.238:58082/|hr    |hrmhrm12345 |Сотрудники |123qweфыв!|Сохранить и продолжить редактирование|Пожалуйста, исправьте ошибку ниже.|Введите правильную дату.|
