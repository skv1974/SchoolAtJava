package org.example;

import java.util.Arrays;
import static java.lang.Math.*;

public class HomeWork3 {

    public static void main(String[] args) {

        boysAndGoods();
        passwordValidation();

    }

    public static void boysAndGoods(){
        /**Время маркетинговых исследований потребительских корзин небольшой фокус группы (3 человека)
        Петя чаще всего покупает: курица, бананы, творог
        Коля чаще всего покупает: курица, бананы, творог
        Терентий чаще всего покупает: пиво, пельмени, ласка магия черного
        Для хранения этих данных создайте 3 массива строк - в каждом будет храниться список наиболее часто приобретаемых товаров каждого человека (1 человек = 1 массив).
        Сравните между собой корзины по количеству товаров:
        1) Пети и Коли
        2) Пети и Терентия
        Сравните между собой корзины по их составу:
        1) Пети и Коли
        2) Пети и Терентия
        Проведите ценное исследование - привлекают ли пользователей товары с более длинными названиями?
                Для этого выведите среди всех покупок Пети, Коли и Терентия товары:
        1) с самым длинным названием
        2) с самым коротким названием
        3) среднюю длину названия товара среди всех представленных товаров*/

        //для проверки корзин
        boolean isEqualGoods;

        //для выяснения коротких и длинных названий продуктов
        String minGoodName = "самое короткое название товара на земле";
        String maxGoodName = "";
        double avrGoodNameLength = 0;

        //массивы для товаров парней
        String[] peteGoods = {"курица", "бананы", "творог"};
        String[] nikolayGoods = {"курица", "бананы", "творог"};
        String[] terentiyGoods = {"пиво", "пельмени", "ласка магия черного"};

        System.out.println("\nПервая часть задания №3");

        //сравниваем корзины Пети и Коли
        isEqualGoods = Arrays.deepEquals(peteGoods,nikolayGoods);
        System.out.println("совпадают ли корзины Пети и Коли: " + isEqualGoods);

        //сравниваем корзины Пети и Терентия
        isEqualGoods = Arrays.deepEquals(peteGoods,terentiyGoods);
        System.out.println("совпадают ли корзины Пети и Терентия: " + isEqualGoods + "\n");

        //перегоняем все продукты в один массив
        String[][] allGoods = new String[3][3];
        System.arraycopy(peteGoods, 0 , allGoods[0], 0, 3);
        System.arraycopy(nikolayGoods, 0 , allGoods[1], 0, 3);
        System.arraycopy(terentiyGoods, 0 , allGoods[2], 0, 3);

        //ищем самое короткое и самое длинное названия товаров
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){

                if (minGoodName.length() > allGoods[i][j].length()){
                    minGoodName = allGoods[i][j];
                }

                if (maxGoodName.length() < allGoods[i][j].length()){
                    maxGoodName = allGoods[i][j];
                }
                avrGoodNameLength = avrGoodNameLength + allGoods[i][j].length();
            }

        }

        //выводы о товарах
        System.out.println("самое короткое название товара: " + minGoodName);
        System.out.println("самое длинное название товара: " + maxGoodName);
        System.out.println("среднее количество символов в названии товаров : " + round(avrGoodNameLength / 9) + "\n");
    }

    public static void passwordValidation(){
        /**Задай массив с тремя любыми паролями (строки).
                Проверь что каждый из паролей:
        длиннее 8 символов
        не начинается с символа 1
        не заканчивается символом z
        не содержит последовательность "1234"
        не содержит последовательность "qwerty"
        Результат проверки выведи на экран в формате:
        "пароль 'значение_пароля' прошел проверку: true/false"*/

        //для итога проверки валидности пароля
        boolean isPasswordPassed;

        //массив с паролями
        String[] passwords = new String[3];
        passwords[0] = "qwerty1235";
        passwords[1] = "qw12345ty";
        passwords[2] = "zxcv123rr";

        System.out.println("Вторая часть задания №3");

        for (int i = 0 ; i < passwords.length; i++){

            //перегоняем строку в буквы
            char[] password = new char[passwords[i].length()];
            password = passwords[i].toCharArray();

            //проверочки пароля, делаем вывод о валидности
            if (password[0] == '1' | password[password.length - 1] == 'z' |
                    passwords[i].contains("qwerty") | passwords[i].contains("1234")){

                isPasswordPassed = false;

            }else isPasswordPassed = true;

            //выводим вывод о валидности
            System.out.println("пароль " + passwords[i] + " прошел проверку: " + isPasswordPassed);
        }


    }
}
