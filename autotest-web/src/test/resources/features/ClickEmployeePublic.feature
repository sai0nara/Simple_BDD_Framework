#language:ru
@clickEmployeePublic
Функция: Проверка работоспособности ссылки "Сотрудники" под аккаунтом "hr"

  Сценарий: Открытие страницы http://178.154.246.238:58082/, авторизация под аккаунтом "hr",
  проверка текста в инфоблоке, после нажатия на кнопку "Сотрудники"

    Дано открыть 'http://178.154.246.238:58082/'
    Тогда инициализация страницы 'DjangoSiteAdmin'
    Если чекбокс 'Я желаю войти с админскими правами' отображается и не выбран
    Тогда нажать на чекбокс 'Я желаю войти с админскими правами'
    Если поле ввода 'логин' отображается
    Тогда заполнить поле 'логин' значением 'public'
    Если поле ввода 'пароль' отображается
    Тогда заполнить поле 'пароль' значением 'hrmhrm123456'
    Если поле ввода 'токен' отображается
    Тогда ввести 'токен' для пользователя 'public' с паролем 'hrmhrm123456'
    Если кнопка 'войти' отображается
    Тогда нажать на кнопку 'войти'
    Тогда инициализация страницы 'DjangoAdministration'
    Если кнопка 'Сотрудники' отображается
    Тогда нажать на кнопку 'Сотрудники'
    Если поле 'Заголовок таблицы' отображается
    Тогда проверить поле 'Заголовок таблицы', что текст в поле 'Выберите Сотрудник для просмотра'