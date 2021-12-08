#language:ru
@tk6.1 @UI @regress
Функция: Проверка поведения системы при невалидном вводе в поле поиска. Страница "Сотрудники" по ролью HR

  Предыстория: Иницилизация и авторизация под ролью hr

    Дано открыть сайт
    Тогда инициализация страницы 'DjangoAuthorization'

  Структура сценария: Открытие стартовой страницы, авторизация под аккаунтом "hr",
  после нажатия на кнопку "Сотрудники", проверить, ввод в поле 'Поиск' значения ‘<qweфыв!>’

    Если авторизоваться логином '<login>'
    Тогда инициализация страницы 'DjangoAdministration'
    Если кнопка '<button>' отображается
    Тогда нажать на '<button>'
    Тогда инициализация страницы 'DjangoEmployee'
    Если поле ввода '<field>' отображается
    Тогда заполнить поле '<field>' значением '<text>'
    Тогда нажать на 'Найти'
    Если в блоке 'ФИО' количество записей равно 0

    Примеры:
      |login |button     |field |text    |
      |hr    |Сотрудники |Поиск |qweфыв! |
