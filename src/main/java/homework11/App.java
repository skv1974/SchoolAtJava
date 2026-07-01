package homework11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        //Проверка ввода количества воды (не цифры) InputMismatchException
        try {
            System.out.print("Введите количество воды (целое число): ");
            int waterInput = scanner.nextInt();
            System.out.println("Вы ввели: " + waterInput + " мл.");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: нужно было ввести число");
        }

        System.out.println("\n--- Следующий тест ---");

        // Проверка работы переопределенного исключения NotEnoughWaterException
        try {
            machine.makeCoffee(100);
        } catch (NotEnoughWaterException e) {
            // Выводим сообщение из объекта исключения
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка кофемашины завершена");
        }

        System.out.println("\n--- Следующий тест ---");

        //Проверка деления на ноль ArithmeticException
        try {
            machine.calculateCups(1000, 0);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: размер чашки не может быть 0");
        }

        System.out.println("\n--- Следующий тест ---");

        //Проверка на нуль NullPointerException
        try {
            String nullCoffee = null;
            machine.printCoffeeName(nullCoffee);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: ссылка на название кофе равна null (NullPointerException)");
        }

        scanner.close();
    }
}