package homework9;

import com.github.lalyos.jfiglet.FigletFont;
import net.datafaker.Faker;

import java.io.IOException;
import java.util.Random;

public class LogoGen {

    //Массив из фамилий для первой части названия
    private static final String[] LAST_NAMES_POOL = {
            "Smotroff", "Zhiltsov", "Gerasin", "Petrova"
    };

    public static void main(String[] args) throws IOException {
        //=====Создание Логотипа=====
        String part1 = getRandomLastNameFromArray();
        String part2 = "AND";

        Faker faker = new Faker();
        String part3 = faker.name().lastName();

        printAsciiArt(part1);
        printAsciiArt(part2);
        printAsciiArt(part3);

        //Пустая строка-разделитель между логотипом и данными
        System.out.println();

        // =====Генерилка юр данных для регистрации=====
        //Генерация адреса
        String address = faker.address().fullAddress();

        //Генерация номера телефона
        String phoneNumber = faker.phoneNumber().phoneNumber();

        //Генерация полного имени (ФИО)
        String fullName = faker.name().fullName();

        // Вывод данных в консоль под логотипом
        System.out.println(address);
        System.out.println(phoneNumber);
        System.out.println(fullName);
    }

    //Метод для выбора случайной фамилии из массива
    private static String getRandomLastNameFromArray() {
        Random random = new Random();
        int randomIndex = random.nextInt(LAST_NAMES_POOL.length);
        return LAST_NAMES_POOL[randomIndex];
    }


    //Метод для рисования в ASCII
    private static void printAsciiArt(String text) throws IOException {
            String asciiArt = FigletFont.convertOneLine(text);
            System.out.println(asciiArt);
    }
}