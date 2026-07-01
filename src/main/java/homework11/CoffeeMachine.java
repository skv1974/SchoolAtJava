package homework11;

public class CoffeeMachine {

    //Метод готовки кофе
    public void makeCoffee(int waterAmount) {
        if (waterAmount <= 200) {
            throw new NotEnoughWaterException("Ошибка: недостаточно воды! Требуется больше 200 мл, а доступно только " + waterAmount + " мл.");
        }
        System.out.println("Кофе успешно приготовлен! Приятного аппетита.");
    }

    //Метод подсчета чашек (исключение деления на ноль проверится силами жава машины)
    public int calculateCups(int waterAmount, int cupVolume) {
        return waterAmount / cupVolume;
    }

    //Метод вывода названия кофе (проверка на null пройдет силами жава машины)
    public void printCoffeeName(String coffeeName) {
        System.out.println(coffeeName.toUpperCase());
    }
}