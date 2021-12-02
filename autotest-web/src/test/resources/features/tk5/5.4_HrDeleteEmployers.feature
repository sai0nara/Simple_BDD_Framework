#language:ru
@djangoHr
Функционал: Проверка работотоспособности удаления сотрудников под ролью HR

  Предыстория:
    Дано открыть "http://178.154.246.238:58082/"
    Тогда инициализация страницы "DjangoAuthorization"
    Если чекбокс "Я желаю войти с админскими правами" отображается и не выбран
    Тогда нажать на чекбокс "Я желаю войти с админскими правами"
    Если чекбокс "Я здесь впервые" отображается и не выбран
    Тогда заполнить поле "логин" значением "hr"
    И заполнить поле "пароль" значением "hrmhrm12345"
    Если поле ввода "токен" отображается
    Тогда ввести 'токен' для пользователя "hr" с паролем "hrmhrm12345"
    Если на странице имеется элемент "войти"
    Тогда нажать на "войти"
    Если на странице отсутствует текст "Сообщение об ошибке"
    Тогда переход на страницу "DjangoAdministration"
    И инициализация страницы "DjangoAdministration"
    Если на странице имеется элемент "Сотрудники"
    Когда нажать на "Сотрудники"
    Тогда переход на страницу "DjangoEmployee"

  Сценарий: В блоке Таблица выбрать любой "чек-бокс", проверить, что на странице
  присутствует текст "Выбрано 1 из 100", затем в выпадающем списке "Действие"
  выбрать значение "Удалить выбранные Сотрудники", нажать кнопку "Выполнить",
  проверка присутствия текста "Вы уверены?", нажать кнопку "Yes, I`m sure", проверка
  присутствия сообщения с текстом "Успешно удалены 1 Сотрудник."

    Дано инициализация страницы "DjangoEmployee"
    Если на текущей странице в блоке "Таблица чек-бокс" нажать на любую ссылку
    И на странице имеется элемент "Выбрано 1 из 100"
    Тогда в блоке "Действие" выбрать 1 "Удалить выбранные Сотрудники"
    Если на странице имеется элемент "Выполнить"
    Тогда нажать на "Выполнить"
    И переход на страницу "DjangoDeleteEmployee"
    И инициализация страницы "DjangoDeleteEmployee"
    Если на странице присутствует текст "Вы уверены?"
    И проскроллить страницу до элемента "Yes, I`m sure"
    Тогда нажать на "Yes, I`m sure"
    Если на странице присутствует текст "Успешно удалены 1 Сотрудник."



