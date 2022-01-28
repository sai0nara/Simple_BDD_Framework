#language:ru
@djangoHr
Функционал: Проверка корректности изменений ключевых полей сотрудника под ролью just_employee

  Предыстория: Иницилизация и авторизация под ролью just_employee
    Дано открыть сайт
    Тогда инициализация страницы "DjangoAuthorization"
    Тогда заполнить поле "логин" значением "just_employee"
    И заполнить поле "пароль" значением "hrmhrm123"
    Тогда нажать на "войти"
    Если на странице отсутствует текст "Сообщение об ошибке"
    Тогда инициализация страницы "DjangoEmployeeChange"

    Сценарий: Страница "Изменить Сотрудник", блок "Общая информация", проверка редактирования ключевых полей
      Если поле "Фамилия" заполнено текстом "Бородкин"
      И поле "Имя" заполнено текстом "Битард"
      И в выпадющем списке "Пол" выбран элемент со значением "Male"
      И элемент "Корпоративная почта" заблокирован
      Тогда ввести в поле "Фамилия" значение "Бородкина"
      И ввести в поле "Имя" значение "Анастасия"
      И в выпадающем списке "Пол" выбрать "Female"
      И нажать на "Сохранить и продолжить редактирование"
      Если поле "Сообщение о успешном редактировании" инфоблок с текстом "The Сотрудник “Бородкина Анастасия” was changed successfully. You may edit it again below." присутствует
      Тогда поле "Фамилия" заполнено текстом "Бородкина"
      И поле "Имя" заполнено текстом "Анастасия"
      И в выпадющем списке "Пол" выбран элемент со значением "Female"
#      возврат к первоначальному состоянию
      Тогда ввести в поле "Фамилия" значение "Бородкин"
      И ввести в поле "Имя" значение "Битард"
      И в выпадающем списке "Пол" выбрать "Male"
      И нажать на "Сохранить и продолжить редактирование"