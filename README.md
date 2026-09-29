Создано при помощи агента Opencode по приказу повелителя вселенной

# SchoolAtJava

Личный учебный репозиторий с домашними заданиями по Java: базовый синтаксис, ООП, коллекции, обработка исключений, а также автотесты UI, API и BDD.

## Стек

| Инструмент | Версия | Назначение |
| --- | --- | --- |
| Gradle | 9.3.0 | сборка |
| JDK | 18+ (в IDEA — `valhalla-ea-23`) | |
| JUnit | 5 | юнит-тесты, запуск сьютов |
| Allure | 2.42.1 | отчёты, аннотации, вложения |
| Selenide | 7.0.0 | UI-тесты |
| REST Assured | 5.5.6 | тесты REST API |
| Hamcrest | 3.0 | матчеры |
| Cucumber | 7.18.0 | BDD-сценарии |
| Lombok | 1.18.30 | бойлерплейт |
| Datafaker | 2.5.4 | генерация тестовых данных |
| JFiglet | 0.0.8 | ASCII-арт |
| Jackson | 3.2.1 | работа с JSON |
| JAX-B | 2.3.2 | XML для JDK 9+ |

## Запуск

```bash
# все тесты
./gradlew test

# отчёт Allure (собирается в build/allure-results)
./gradlew allureReport

# HTML-отчёт Cucumber
./gradlew test --tests homeWork16.RunCucumberTest
```

Отдельные ДЗ запускаются как обычные `main`-классы, например:

```bash
./gradlew run --args="-cp src/main/java homeWork12.Main"
```

## Структура

Каждое домашнее задание лежит в собственном пакете `homeWorkN` внутри `src/main/java`, тесты — в `src/test/java/homeWorkN`. Внутри кода оставлены комментарии с формулировками заданий.

```
src/
├── main/java/
│   ├── homeWorks1_5/     # HomeWork1 … HomeWork5
│   ├── homeWork6/        # доставка: model / service / app
│   ├── homeWork7/        # арена: heroes, ANSWER.md
│   ├── homeWork8/        # winAmp
│   ├── homework9/        # LogoGen
│   ├── homework11/       # исключения, CoffeeMachine
│   ├── homeWork12/       # аэропорт, иерархия исключений
│   ├── homeWork13/       # коллекции: List, LinkedList, Iterator
│   ├── homeWork14/       # Comparator, XMLUtils
│   ├── homeWork15/       # BoardGame + GameRental
│   └── homeWork20/       # Calculator + Allure-оформление
└── test/
    ├── java/homeWork15/  # юнит-тесты аренды настолок
    ├── java/homeWork16/  # Cucumber: steps, hooks, runner
    ├── java/homeWork17/  # REST-тесты serverest.dev
    ├── java/homeWork19/  # UI: act1 (XPath) и act2 (Page Object)
    ├── java/homeWork20/  # Allure-тесты калькулятора
    └── resources/        # booking.feature, allure.properties
```

## Домашние задания

| ДЗ | Тема | Что внутри |
| --- | --- | --- |
| 1 | Переменные и арифметика | расчёт зарплаты продавца шаурмы: смены, ставка, премия, штраф, выручка |
| 2 | Условия и `Random` | проверка клиента: возраст, чёрный список, приглашение, баланс кошелька, расчёт бонуса |
| 3 | Массивы и строки | корзины покупателей: сравнение длины и состава, самое длинное/короткое название, средняя длина; валидация паролей |
| 4 | Циклы, `Scanner`, `null` | сборка сообщения из пяти строк с резервным фрагментом; анализ 100 тестов (Pass / Flaky / Bug / Critical) через остаток от деления |
| 5 | Методы и видимость | генерация кода доступа, проверка кода, перегрузка `logEvent`, генерация ID агентов; `public` / `private` |
| 6 | Наследование | `Parcel` → `FragileParcel` / `ExpressParcel`, переопределение расчёта цены, полиморфный массив в `ParcelService` |
| 7 | `static`, `final`, полиморфизм | `Hero` → `Knight` / `Archer` / `Mage`, статический счётчик созданных героев, `final`-поля. В пакете есть `ANSWER.md` с разбором семи теоретических вопросов |
| 8 | `ArrayList` | плеер `Winamp` и плейлист: добавление, удаление, обновление, получение трека |
| 9 | Сторонние библиотеки | `LogoGen`: ASCII-логотип через JFiglet и случайные ФИО, адрес и телефон через Datafaker |
| 11 | Исключения: база | `CoffeeMachine` и собственное `NotEnoughWaterException`; в `App` разбираются `InputMismatchException`, `ArithmeticException`, `NullPointerException` |
| 12 | Исключения: иерархия | стойка выдачи багажа: проверяемые (`FlightNotFound`, `OverweightBaggage`, `BaggageTagPrint`), непроверяемые (`InvalidPassengerName`, `InvalidBaggageWeight`) и критическая ошибка `ConveyorBeltMalfunctionError extends Error`; шесть сценариев в `Main` |
| 13 | Коллекции | `Alien` с `equals` / `hashCode` / `toString`; сравнение `ArrayList`, `Arrays.asList` и `List.of`; удаление через `Iterator` и `removeIf`; очередь на `LinkedList`; поиск дубликатов; разница `==` и `equals` |
| 14 | Компараторы | сортировка фильмов по рейтингу своим `Comparator`, утилита `XMLUtils.createEmptyElement` и её тесты |
| 15 | Модульное тестирование | `BoardGame` и `GameRental` с проверками в конструкторах; 19 юнит-тестов на аренду, возврат и расчёт стоимости |
| 16 | Cucumber BDD | `booking.feature` с тегами `@smoke` / `@negative` / `@regression`, `Scenario Outline`, `DataTable` и `DocString`; шаги, hooks и раннер |
| 17 | REST-тесты | REST Assured против `serverest.dev`: получение списка, поиск по email, создание, обновление, удаление с авторизацией, проверка товаров |
| 19 | UI-тесты | `act1` — тест «как его писали родители» на чистом XPath; `act2` — тот же сценарий после рефакторинга в Page Object (`MainPage`, `LoginPage` с Lombok `@Data` и чейн-методами) |
| 20 | Allure | `Calculator` и `CalculatorSteps` с `@Step` и вложениями; тесты с `@Epic`, `@Feature`, `@Story`, `@Severity`, `@Owner`, `@Link` на задачи JIRA |

## Ветки

- `master` — основная ветка со всеми домашними заданиями.
- `homework11` — отдельная ветка с домашним заданием 11.

## Замечания по состоянию проекта

- `src/main/java/homeWork14/XMLUtilsTest.java` лежит в основных исходниках, а не в `src/test`; аннотации JUnit попадают в сборку приложения.
- В `homeWork17/ServeRestTest` путь удаления пользователя задан как `" /usuarios/"` с ведущим пробелом — запрос уйдёт на неверный адрес.
- В `homeWork20/ArithmeticTest.testAddWithNegativeNumber` ожидается `-2`, а проверяется `2` — тест упадёт.
- `homeWork13/SquadManager.java` содержит неиспользуемый `import java.sql.Array`.
- В `build.gradle` две версии JUnit (BOM 5.14.0 и явная 5.10.3); Jackson подключён, но не используется.
- Шаги Cucumber только печатают в консоль — за ними нет предметной логики.
- Нет CI, нет `LICENSE`, описание репозитория на GitHub не заполнено.
