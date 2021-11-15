#language:ru
@Test

Функционал: Аторизация

  Сценарий: проверка авторизации под ролью "just_employee" с активированным чек-боксом
  "Я желаю войти с админскими правами" и заполненным полем "OTP Token (from Google Authenticator)"
    Дано открыть url "http://178.154.246.238:58082/"
    Когда инициализация страницы "DjangoAuthorization"
    Тогда кликнуть на элемент "Я желаю войти с админскими правами"
    И чекбокс "Я здесь впервые" отображается и не выбран
    И ввести в поле "логин" значение "just_employee"
    И ввести в поле "пароль" значение "hrmhrm123"
    И ввести в поле "токен" значение "111111"
    И кликнуть на элемент "войти"
    Если на странице присутствует текст "У этого пользователя нет админских прав."