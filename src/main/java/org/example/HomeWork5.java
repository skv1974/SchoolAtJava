package org.example;

import java.time.Year;
import java.util.Random;

public class HomeWork5 {
    public static void main(String[] args) {

        /**
        Соберите всё в методе main(). Система должна выполнить следующий сценарий:

        Сгенерировать код доступа через generateAccessCode() и сохранить в переменную
        Проверить его через isValidCode(code, 8) и вывести результат
        Записать в лог событие "Server protection activated"
        Записать критическое событие "Intrusion attempt detected" (isCritical = true)
        Сгенерировать три ID агентов: prefix "AGENT", seed 42, 77 и 13 - вывести каждый

        Протоколы 1, 3, 4 должны быть доступны для других классов программы. Остальные - скрыты от всех.*/

        //входные данные
        String message = "Server protection activated";
        int minLength = 8;

        String criticalMessage = "Intrusion attempt detected";
        boolean isCritical = true;

        String prefix = "AGENT";
        int[] seeds = {42, 77, 13};

        //переменная для кода доступа
        String accessCode;

        //создание кода доступа
        accessCode = generateAccessCode();
        System.out.println(accessCode);

        //результат проверки кода доступа
        System.out.println("проверка кода доступа пройдена - " + accessCode + ": " + isValidCode(generateAccessCode(),minLength));

        //запись логов
        System.out.println(logEvent(message));
        System.out.println(logEvent(criticalMessage,isCritical));

        //генерация агент айди
        for (int seed : seeds) {
            System.out.println(generateAgentId(prefix, seed));
        }

    }

    //===================helpers==============
    public static String generateAccessCode(){
        /**
        Реализуйте метод generateAccessCode() - без параметров, возвращает String. Метод должен собирать код доступа из трёх частей:
        Первые 4 символа: текущий год
        Разделитель: символ "-"
        Последние 4 символа: результат Math.pow(3, 7), приведённый к int
        Итоговый код собирается конкатенацией и возвращается через return.
        ====================
         */

        //получение текущего года
        String year = Year.now().toString();

        //создание кода
        String accessCode = year + "-" + (int) Math.pow(3, 7);

        return accessCode;
    }

    private static boolean isValidCode (String code, int minLength){
        /**
        Реализуйте метод isValidCode(String code, int minLength) - возвращает boolean. Метод должен вернуть true, если:
        code не равен null
        длина code больше или равна minLength
        code содержит символ "-"
        Во всех остальных случаях - false.*/

        //переменная для проверки кода
        boolean checkCodeResult;

        if (code != null && code.length() >= minLength && code.contains("-")){
            checkCodeResult = true;
        }else checkCodeResult = false;

        return checkCodeResult;
    }

    public static String logEvent (String message){
        /**
        Реализуйте два перегруженных метода logEvent():
        Версия 1: принимает String message - выводит:
        [INFO] {message}*/

        return "[INFO] " + message;
    }

    public static String logEvent (String message, boolean isCritical){
        /**
        Версия 2: принимает String message и boolean isCritical - если isCritical = true, выводит: [CRITICAL] {message},
        иначе вызывает первую версию.
        Версия 2 должна переиспользовать версию 1, а не дублировать вывод.*/

        if (isCritical){
            return "[CRITICAL] " + message;
        }else return logEvent(message);

    }

    private static String generateAgentId (String prefix, int seed){
        /**
        Реализуйте метод generateAgentId(String prefix, int seed) - возвращает String.
        Создайте объект Random с переданным seed
        Сгенерируйте случайное число от 1000 до 9999 включительно
        Верните строку вида: {PREFIX}-{число}*/

        String result;
        Random random = new Random();
        random.setSeed(seed);
        int randomInt = random.nextInt(1000, 9999);
        result = ("{" + prefix + "}-{" + randomInt +"}");

        return result;
    }


}


