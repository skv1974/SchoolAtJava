package homeWork6.delivery.model;

public class Parcel {

    String nameConsignee;
    String address;
    double weight;
    String trackNumber;

    //стоимость доставки
    public double calculateDeliveryPrice(){

        return 100 + this.weight * 30;
    }

    //вывод инфо о посылке
    public void printInfo(){

        System.out.println("Имя получателя - " + this.nameConsignee);
        System.out.println("Адрес доставки - " + this.address);
        System.out.println("Вес посылки - " + this.weight);
        System.out.println("Трек посылки - " + this.trackNumber);
    }

    //===============================
    //конструктор
    public Parcel(String nameConsignee, String address, double weight, String trackNumber) {
        this.nameConsignee = nameConsignee;
        this.address = address;
        this.weight = weight;
        this.trackNumber = trackNumber;
    }

    //конструктор без аргументов
    public Parcel() {
    }

    //=====геттеры=====
    public String getNameConsignee() {
        return nameConsignee;
    }

    public String getAddress() {
        return address;
    }

    public double getWeight() {
        return weight;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    //=====сеттеры=====
    public void setNameConsignee(String nameConsignee) {
        this.nameConsignee = nameConsignee;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }
}
