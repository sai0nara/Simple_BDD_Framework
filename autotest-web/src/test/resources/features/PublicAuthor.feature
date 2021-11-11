#language:ru
@djangoAdmin
Функционал: Проверка авторизации на странице авторизации от имени "public"

  Сценарий: Открытие страницы http://178.154.246.238:58082/, активация поля "Я желаю войти с админскими
  правами", ввод значения "public" в поле логина, ввод значения "hrmhrm123456" в поле пароля, получение
  токена с помощью api запроса, ввод токена в поле токена, авторизация с помощью кнопки "войти", проверка
  отсутствия сообщения об ошибке, проверка нахождения на странице "Администрирование Django", проверка
  присутствия на странице значения "ДОБРО ПОЖАЛОВАТЬ, PUBLIC"

    Дано открыть "http://178.154.246.238:58082/"
    Тогда инициализация страницы "DjangoAuthorization"
    Если чекбокс "Я желаю войти с админскими правами" отображается и не выбран
    Тогда нажать на чекбокс "Я желаю войти с админскими правами"
    Если чекбокс "Я здесь впервые" отображается и не выбран
    Тогда заполнить поле "логин" значением "public"
    И заполнить поле "пароль" значением "hrmhrm123456"
    И получить Token для юзера "public" с паролем "hrmhrm123456"
    И заполнить поле "токен" значением "Token"
    Если на странице имеется элемент "войти"
    Тогда нажать на "войти"
    Если на странице отсутствует текст "Сообщение об ошибке"
    Тогда переход на страницу "DjangoAdministration"
    И инициализация страницы "DjangoAdministration"
    Если в поле Добро пожаловать, присутствует текст "PUBLIC"