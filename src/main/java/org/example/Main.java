package org.example;

public class Main {
    public static void main(String[] args) {
    /* Создай главный метод - точку входа в Java приложение.
    В этом методе задай переменные
    - имя сотрудника (строка)
    - должность (строка)
    - ставка за одну смену (число)
    - количество смен (число)
    - премия (число)
    - штраф сотрудника за подгоревший лаваш (число)
    - цена 1 шаурмы (число)
    - количество штук проданной шаурмы (число)

    В этом же методе напиши код, который выведет:
    - данные о сотруднике (имя, должность)
    - зарплату без премии (зарплата = количество смен умножить на ставку за одну смену)
    - штраф, премию и итоговую зарплату с учетом премии и штрафом
    - выручку (количество проданной шарумы умножить на стоимость шаурмы) */

        String name = "Артем";
        String position = "продавэц";
        double shiftSalary = 1000;
        int workShift = 5;
        double bonus = 2000;
        double penalty = 499.99;
        double prise = 180;
        int grossSales = 100;


        System.out.println("Данные о сотруднике: " + "\n\tИмя - "+ name + "\n\tДолжность - " + position);
        System.out.println("================================================");
        System.out.println("\tНачислено без премии - " + workShift * shiftSalary);
        System.out.println("\tНачислено штрафов - " + penalty);
        System.out.println("\tНачислено премии - " + bonus);
        System.out.println("Начислено ИТОГО - " + (workShift * shiftSalary + penalty+ bonus));
        System.out.println("================================================");
        System.out.println("Выручка с продаж (всего) - " + grossSales * prise);

    }
}