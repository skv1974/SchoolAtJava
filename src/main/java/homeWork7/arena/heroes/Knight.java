package homeWork7.arena.heroes;

public class Knight extends Hero{

    //количество брони
    private int armor;

    //атака рыцаря
    @Override
    public void attack(){
        System.out.println("Рыцарь бьёт мечом!");
    }

    //перегрузка toString() для рыцаря
    @Override
    public String toString() {
        return ("Имя рыцаря: " + name + ", level= " + level + ", health= " + health + ", armor= " + armor);
    }

    //======конструкторы, геттеры и сеттеры======
    public Knight() {
    }

    public Knight(String name, int level, int health, int armor) {
        super(name, level, health);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
