package homeWork7.arena.heroes;

public class Hero {

    //атрибуты героя
    protected String name;
    protected int level;
    protected int health;

    // максимальное значение уровня
    public static final int MAX_LEVEL = 100;

    //для подсчета созданных героев
    private static int heroesCreated = 0;

    //вывод инфы о герое
    public void printInfo(){
        System.out.println("=====Данные о герое=====");
        System.out.println("Name hero: " + name);
        System.out.println("Level:" + level);
        System.out.println("Current health: " + health);
    }

    //получение урона (уменьшение здоровья) героем
    public void takeDamage(int damage){
        health = health - damage;
        if (health <= 0 ){
            health = 0;}
    }

    //повышение уровня героя
    public void levelUp(){
        level = level + 1;
        if (level >= 100){
            level = 100;}
    }

    //герой атакует
    public void attack(){
        System.out.println("Герой наносит обычный удар.");
    }

    //один удар по цели
    public void attack(String target){
        System.out.println("Герой наносит обычный удар. Цель: " + target);
    }

    //несколько ударов по цели
    public void attack(String target, int times){
        System.out.println("Герой атакует цель " + target + " " + times + " раза.");
    }

    //отдых героя
    public final void rest(){
        System.out.println("Герой отдыхает и восстанавливает силы.");
    }

    //вывод инфы о количестве созданных героев
    public static void printHeroesCreated(){
        System.out.println("Всего создано героев: " + heroesCreated);
    }

    //======конструкторы, геттеры и сеттеры======
    public Hero() {
    }

    public Hero(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;

        heroesCreated++; //при создании нового героя счетчик увеличивается
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}



