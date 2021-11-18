#language:ru
@djangoHr
Функционал: Проверка корректности истории изменений фамилии сотрудника под ролью HR

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
    И инициализация страницы "DjangoEmployee"
    Если кликнуть на элемент по тексту "Бородкин Битард Моисеевич"
    Тогда переход на страницу "DjangoEmployeeChange"

  Сценарий: В поле 'Фамилия' ввести значение "Бородкинов", сохранить и продолжить изменения, в поле
    'Фамилия' ввести значение "Бородкин", сохранить и продолжить изменения, нажать кнопку 'История
    изменений', проверка присутствия инфоблока 'История инфоблока', выбрать в инфоблоке предпоследнюю
    запись, проверить присутствие инфоблока "Вернуть Бородкинов Битард Гопнилович", сохранить, проверить
    присутствие инфоблока с текстом 'The Сотрудник '<link>' was changed successfully.'

    Дано инициализация страницы "DjangoEmployeeChange"
    Если заполнить поле "Фамилия" значением "Бородкинов"
    И на странице имеется элемент "Сохранить и продолжить редактирование"
    Тогда нажать на "Сохранить и продолжить редактирование"
    Если заполнить поле "Фамилия" значением "Бородкин"
    И на странице имеется элемент "Сохранить и продолжить редактирование"
    Тогда нажать на "Сохранить и продолжить редактирование"
    Если на странице имеется элемент "История"
    И нажать на "История"
    Тогда переход на страницу "DjangoEmployeeHistoryChange"
    И инициализация страницы "DjangoEmployeeHistoryChange"
    Если на странице присутствует текст "История изменений: Бородкин Битард"
    И нажать на предпоследнюю запись из "История изменений"
    Тогда переход на страницу "DjangoReturnEmployee"
    И инициализация страницы "DjangoReturnEmployee"
    Если на странице присутствует текст "Вернуть Бородкинов Битард"
    И на странице имеется элемент "Сохранить"
    Тогда нажать на "Сохранить"
    Тогда переход на страницу "DjangoEmployee"
    И инициализация страницы "DjangoEmployee"
    Если в поле The Сотрудник “ и ” was changed successfully. присутствует элемент "Name"
    Тогда нажать на "Name"
    Тогда переход на страницу "DjangoReturnEmployee"
    И инициализация страницы "DjangoReturnEmployee"
    Если очистить поле "поле Фамилии"
    Тогда заполнить поле "поле Фамилии" значением "Бородкин"
    Если на странице имеется элемент "Сохранить"
    Тогда нажать на "Сохранить"
