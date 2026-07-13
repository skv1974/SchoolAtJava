package homeWork13;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static SquadManager squadManager = new SquadManager();
    static List<Alien> aliens = new ArrayList<>();
    static List<String> squad = new ArrayList<>();
    static AssaultQueue queue = new AssaultQueue();

    public static void main(String[] args) {

        //создаем 7 штук пришельцев с 2 дублями
        aliens.add(new Alien("Вася","Grok",1));
        aliens.add(new Alien("Вася","Grok",2)); //дубль записи №1
        aliens.add(new Alien("Петя", "Anubis", 10));
        aliens.add(new Alien("Зина", "Mars", 1));
        aliens.add(new Alien("Семен", "Edem",1));
        aliens.add(new Alien("Петя", "Anubis", 3)); //дубль записи №3
        aliens.add(new Alien("Зина","Anubis", 10)); //псевдо дубль записи №4 разные планеты

        //Проверяем список пришельцев на дубли
        alienArrayCheckOnDoubles();

        //Выводим список пришельцев
        printOutAliensArray();

        //=======================
        //демо с List
        squadManager.demonstrateListCreator();

        //=======================
        //проверка на трусы
        System.out.println("=====\n" + "Уничтожаем трусов");

        squad.add("Иван");
        squad.add("Трус Вася");
        squad.add("Петр");
        squad.add("Трус Коля");
        squad.add("Сергей");

        //удаляем трусов
        squadManager.filterOutCowards(squad);

        //=========================
        //очередь в ад и обратно
        System.out.println("=====\n" + "Демо с очередью");

        queue.addRecruit("Иван");
        queue.addRecruit("Петр");
        queue.addRecruit("Сергей");
        queue.addRecruit("Олег");
        queue.addRecruit("Максим");

        System.out.println("Очередь:");
        queue.printQueue();

        System.out.println("Ушел: " + queue.retreatCoward());
        System.out.println("Ушел: " + queue.retreatCoward());

        System.out.println("Пришли Никита, Антон, Роман");
        queue.addRecruit("Никита");
        queue.addRecruit("Антон");
        queue.addRecruit("Роман");

        System.out.println("Итоговая очередь:");
        System.out.println(queue);

        //===========================
        //Спец репортаж
        System.out.println("=====\n" + "Вести с фронта");

        MissionReport report1 =
                new MissionReport("Штурм Зоны 51", aliens, 50);

        MissionReport report2 =
                new MissionReport("Штурм Зоны 51", aliens, 50);

        System.out.println(report1);

        System.out.println("\nСравнение отчетов:");
        System.out.println("report1 == report2 : "
                + (report1 == report2));

        System.out.println("report1.equals(report2) : "
                + report1.equals(report2));

    }

    //для вывода списка пришельцев
    private static void printOutAliensArray() {
        System.out.println("=====\n" + "Список зарегистрированных пришельцев");
        for (Alien alien : aliens) {
            System.out.println(alien);
        }
        System.out.println("Конец списка" + "\n=====");
    }

    //для проверки списка пришельцев на дубли (сравниваем имя + планету)
    private static void alienArrayCheckOnDoubles() {
        System.out.println("=====\n" + "Проверка на пришельцев на дубли");
        for (int index = 0; index < aliens.size() -1; index++) {
            for (int alien = index; alien < aliens.size() - 1; alien++) {
                if (aliens.get(index).getName().equals(aliens.get(alien + 1).getName()) &
                        aliens.get(index).getPlanet().equals(aliens.get(alien + 1).getPlanet())) {
                    System.out.println("Ахтунг, запись №" + (alien + 2) +
                            " дубликат записи №" + (index + 1) + "! Такой пришелец уже зарегистрирован!");
                }/*else
                     {System.out.println("Запись №" + (index + 1)
                             + " не совпадает с Записью №" + (alien + 2) + " = ok");} //для отладки*/
            }
        }
        System.out.println("Проверка на дубли завершена\n" + "=====");
    }
}
