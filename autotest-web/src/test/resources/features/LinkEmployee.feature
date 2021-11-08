#language:ru
@linkemployee
Функционал: Проверка страницы администрирования

  Структура сценария: Страница администрирования, проверка работоспособности ссылки 'Сотрудники'

    Дано открыть url 'url'
    И активировать поле 'Я желаю войти с админскими правами'
    И ввести в поле 'логин' значение 'login'
    И ввести в поле 'пароль' значение 'password'
    И ввести в поле 'токен' значение 'token'
    Если на странице имеется элемент "кнопка войти"
    Тогда кликнуть на элемент "кнопка войти"
#    Затем нажать на ссылку с текстом 'Сотрудники'
    Затем нажать на ссылку с текстом 'link'
    Если на текущей странице 'Инфоблок' 'infoblocktext' присутствует
#    Тогда конец теста


    Примеры:
      |url                          |login   |password    |link      |infoblocktext                   |
      |http://178.154.246.238:58082/|hr      |hrmhrm12345 |Сотрудники|Выберите Сотрудник для изменения|
      |http://178.154.246.238:58082/|hr      |hrmhrm12345 |Добавить  |Сотрудник                       |
      |http://178.154.246.238:58082/|public  |hrmhrm123456|Сотрудники|Выберите Сотрудник для изменения|
