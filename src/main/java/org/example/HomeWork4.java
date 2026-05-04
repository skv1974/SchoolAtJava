package org.example;

import java.util.Objects;
import java.util.Scanner;

public class HomeWork4 {

    public static void main(String[] args) {

        inputAndDescriptionText();

        testReportAnalise();
    }


    public static void inputAndDescriptionText(){

        Scanner scanner = new Scanner(System.in);

        String allText = "";
        String string;


        // ждем ввода 5 строк
        for (int i = 0; i < 5; i++){

            string = scanner.nextLine();

            // проверяем строку на null без учета регистра
            if (string == null | string.equals("") | string.toUpperCase().equals("NULL")){
                System.out.println("Часть сообщения повреждена! Используем резервный фрагмент...");
                string = "XX";

            }

            //добавляем разделитель кроме хвоста текста
            if (i < 4){
            allText = allText + string + "#";}
            else {
                allText = allText + string;
            }

        }

        //выводим итоговый текст
        System.out.println("Расшифрованное послание: " + allText);

    }

    public static void testReportAnalise(){

        //для показа только дефектов
        boolean showOnlyIssues = true;

        int pass = 0;
        int flaky = 0;
        int bug = 0;
        int critical = 0;

        //цикл с анализом результатов тестов
        int i = 1;

        while (i <= 100){

            int mod3;
            int mod5;

            //узнаем остаток после деления на 3 и 5
            mod3 = i % 3;
            mod5 = i % 5;

            if (mod3 == 0 & mod5 == 0){                             //проверка на крит
                critical++;
                System.out.println("Test#" + i + ": Critical!");
            }else {
                if (mod3 == 0){                                     //проверка на флаки
                    flaky++;
                    System.out.println("Test#" + i + ": Flaky");
                }
                if (mod5 == 0){                                     //проверка на баг
                    bug++;
                    System.out.println("Test#" + i + ": Bug");
                }
                if (mod3 != 0 & mod5 != 0 & !showOnlyIssues){       //доп условие если pass и надо выводить
                    System.out.println("Test#" + i + ": Pass");
                    pass++;
                }
                if (mod3 != 0 & mod5 != 0 & showOnlyIssues){        //доп условие если pass и не надо выводить
                    pass++;}
            }

            if (critical>=3){                                       //доп условие проверки на остановку при 3 критах
                System.out.println("Слишком много критических багов — будим тимлида!");
                break;
            }
            i++;
        }

        //вывод результатов
        System.out.println("===== ИТОГИ НОЧНОЙ СМЕНЫ =====");
        System.out.println("Всего тестов: 100");
        System.out.println("Pass: " + pass);
        System.out.println("Flaky: " + flaky);
        System.out.println("Bug: " + bug);
        System.out.println("Critical: " + critical);

    }
}
