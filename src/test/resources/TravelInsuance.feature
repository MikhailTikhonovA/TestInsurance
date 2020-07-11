#language: ru

Функционал: : Страхование

  Сценарий: Заявка на страхование выезжающих за рубеж

    Когда  выбран пункт главного меню "Страхование"
    И  выбран тип страхования - "Страхование путешественников"
    Тогда  проверка отображения заголовка меню - "Страхование путешественников"
    Когда  нажать на кнопку запуска оформления полиса
    И  выбран тип покрытия - "Минимальная"
    Тогда нажать на кнопку перехода на следующий шаг оформления
    Когда   заполняются поля формы:
      | Фамилия застрахованного        | Petro            |
      | Имя застрахованного            | Petr             |
      | ДР застрахованного             | 12.02.1990       |
      | Фамилия страхуемого            | Петро            |
      | Имя страхуемого                | Петр             |
      | Отчество страхуемого           | Васильевич       |
      | ДР страхуемого                 | 12.03.1990       |
      | Серия паспорта С               | 1212             |
      | Номер паспорта С               | 324546           |
      | Дата выдачи паспорта С         | 11.08.2019       |
      | Организация выдавшая паспорт С | УВД по г. Москва |
    Тогда проверка заполненных полей:
      | Фамилия застрахованного        | Petro            |
      | Имя застрахованного            | Petr             |
      | ДР застрахованного             | 12.02.1990       |
      | Фамилия страхуемого            | Петро            |
      | Имя страхуемого                | Петр             |
      | Отчество страхуемого           | Васильевич       |
      | ДР страхуемого                 | 12.03.1990       |
      | Серия паспорта С               | 1212             |
      | Номер паспорта С               | 324546           |
      | Дата выдачи паспорта С         | 11.08.2019       |
      | Организация выдавшая паспорт С | УВД по г. Москва |
    Когда нажать на кнопку подтверждения
    Тогда проверить текст алерта на странице - "При заполнении данных произошла ошибка"