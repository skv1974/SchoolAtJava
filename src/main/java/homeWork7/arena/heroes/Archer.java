package homeWork7.arena.heroes;

public class Archer extends Hero{

    //количество стрел
    private int arrowsCount;

    //атака лучника
    @Override
    public void attack(){
        System.out.println("Лучник выпускает стрелу!");
    }

    /*public final void rest(){
        попытка переопределения отдыха
    }*/

    //======конструкторы, геттеры и сеттеры======
    public Archer() {
    }

    public Archer(String name, int level, int health, int arrowsCount) {
        super(name, level, health);
        this.arrowsCount = arrowsCount;
    }

    public int getArrowsCount() {
        return arrowsCount;
    }

    public void setArrowsCount(int arrowsCount) {
        this.arrowsCount = arrowsCount;
    }
}
