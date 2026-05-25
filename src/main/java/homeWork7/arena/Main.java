package homeWork7.arena;

import homeWork7.arena.heroes.Archer;
import homeWork7.arena.heroes.Hero;
import homeWork7.arena.heroes.Knight;
import homeWork7.arena.heroes.Mage;

public class Main {


    public static void main(String[] args) {

        //создаем героев
        Hero[] heroes = {
                new Knight("Коля", 100, 101, 10),
                new Archer("Артем", 99, 50, 102),
                new Mage("Аля", 99, 25, 1000)
        };

        for (Hero hero : heroes){
            hero.printInfo();
            hero.attack();
        }

        //создание эксклюзивного лыцаля и переопределение его атрибута
        final Knight knight = new Knight("Ланселот", 10, 102, 11);

        System.out.println("До изменения: " + knight);

        // Изменяем поле внутри объекта (в данном случае бронь)
        knight.setArmor(12);

        System.out.println("После изменения: " + knight);

        //количество созданных героев
        Hero.printHeroesCreated();
    }

}
