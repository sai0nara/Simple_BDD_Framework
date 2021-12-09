#language:ru
@djangoHr
Функционал: Проверка корректности истории изменений сотрудника в блоке Сертификаты под ролью just_employee

  Предыстория: Иницилизация и авторизация под ролью just_employee
    Дано открыть "http://178.154.246.238:58082/"
    Тогда инициализация страницы "DjangoAuthorization"
    Тогда заполнить поле "логин" значением "just_employee"
    И заполнить поле "пароль" значением "hrmhrm123"
    Тогда нажать на "войти"
    И инициализация страницы "DjangoEmployeeChange"

    Сценарий: Роль "just_employee", Страница "Изменить Сотрудник", блок "Сертификаты", проверка редактирования блока
      Если проскроллить страницу до элемента "Показать Сертификаты"
      Тогда нажать на "Показать Сертификаты"
      И ввести в поле "Сертификаты:" случайное значение по маске "RRRRRRDDDDD"
      И ввести в поле "Курсы:" случайное значение по маске "RRRRRRDDDDD"
      И нажать на "Сохранить и продолжить редактирование"
      Если поле "Сообщение о успешном редактировании" инфоблок с текстом "The Сотрудник “Бородкин Битард” was changed successfully. You may edit it again below." присутствует
