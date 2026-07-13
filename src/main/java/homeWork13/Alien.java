package homeWork13;

import java.util.Objects;

public class Alien {

    String name;
    String planet;
    int dangerLevel;

    //конструкторы
    public Alien() {
    }

    public Alien(String name, String planet, int dangerLevel) {
        this.name = name;
        this.planet = planet;
        this.dangerLevel = dangerLevel;
    }

    //геттеры сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(int dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    //=========

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alien alien = (Alien) o;
        return dangerLevel == alien.dangerLevel && Objects.equals(name, alien.name) && Objects.equals(planet, alien.planet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planet, dangerLevel);
    }

    @Override
    public String toString() {
        return "Alien{" +
                "name='" + name + '\'' +
                ", planet='" + planet + '\'' +
                ", dangerLevel=" + dangerLevel +
                '}';
    }
}
