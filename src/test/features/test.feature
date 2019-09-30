#language:ru
@test
Функционал: Сбербанк

@success
  Сценарий: Успешный сценарий Кукумбера №1

  * Подготовка тестовой среды
  * Переход в меню ипотеки
  * Заполнение полей:
    |Стоимость    |5180000|
    |Первый взнос |3058000|
    |Срок         |30|
  * Проверка данных:
    |Сумма кредита      |2 122 000 ₽|
    |Ежемесячный платеж |18 937 ₽|
    |Необходимый доход  |31 561 ₽|
    |Процентная ставка  |10,2 %|
  * Конец работы
@fail
  Сценарий: Успешный сценарий Кукумбера №2

  * Подготовка тестовой среды
  * Переход в меню ипотеки
  * Заполнение полей:
    |Стоимость    |5180000|
    |Первый взнос |3058000|
    |Срок         |30|
  * Проверка данных:
    |Сумма кредита      |2 122 000 ₽|
    |Ежемесячный платеж |18 937 ₽|
    |Необходимый доход  |31 561 ₽|
    |Процентная ставка  |11 %|
  * Конец работы