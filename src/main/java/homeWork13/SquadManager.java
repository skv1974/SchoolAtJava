package homeWork13;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SquadManager {


    public void demonstrateListCreator(){

        List<String> mainSquad = new ArrayList<>();
        mainSquad.add("Marine #1");
        mainSquad.add("Marine #2");
        mainSquad.add("Marine #3");
        mainSquad.add("Marine #4");

        List<String> supportSquad = Arrays.asList("Sup #1", "Sup #2", "Sup #3");

        List<String> eliteSquad = List.of("Elite #1", "Elite #2", "Elite #3");

        System.out.println("=====\n" + "начало демо с List");
        System.out.println("=====\n" + "добавляем и удаляем из mainSquad");

        try {
            mainSquad.add("Vasya");
            System.out.println("что-то добавили");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            mainSquad.remove(1);
            System.out.println("что-то удалили");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        /* тута исключения срабатывают что используются неподдерживаемые операции с коллекциями
        System.out.println("=====\n" + "добавляем и удаляем из supportSquad");
        try {
            supportSquad.add("Vasya");
            System.out.println("что-то добавили");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            supportSquad.remove(1);
            System.out.println("что-то удалили");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("=====\n" + "добавляем и удаляем из eliteSquad");
        try {
            eliteSquad.add("Vasya");
            System.out.println("что-то добавили");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            eliteSquad.remove(1);
            System.out.println("что-то удалили");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }*/

        System.out.println("конец демо с List" + "\n=====");
    }

    //Удалятор трусов
    public void filterOutCowards(List<String> squad) {

        System.out.println("До фильтрации: " + squad);

        Iterator<String> iterator = squad.iterator();

        while (iterator.hasNext()) {
            String soldier = iterator.next();

            if (soldier.startsWith("Трус")) {
                iterator.remove();
            }
        }

        System.out.println("После фильтрации: " + squad);
    }

    // Альтернативный вариант удалятора трусов
    public void filterOutCowardsRemoveIf(List<String> squad) {
        squad.removeIf(name -> name.startsWith("Трус"));
    }
}
