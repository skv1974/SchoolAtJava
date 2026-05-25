package homeWork7.arena.heroes;

public class Mage extends Hero{

    //количество маны
    private int mana;

    //атака мага
    @Override
    public void attack(){
        System.out.println("Маг запускает огненный шар!");
    }

    //======конструкторы, геттеры и сеттеры======
    public Mage() {
    }

    public Mage(String name, int level, int health, int mana) {
        super(name, level, health);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
