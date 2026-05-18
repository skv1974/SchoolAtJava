package homeWork6.delivery.model;

public class FragileParcel extends Parcel{

    boolean requiresCarefulHandling;

    //стоимость доставки с наследованием
    public double calculateDeliveryPrice(){

        return super.calculateDeliveryPrice() + 200;
    }

    //вывод инфо о посылке с наследованием
    public void printInfo(){
        super.printInfo();
        System.out.println("Посылка хрупкая - " + this.requiresCarefulHandling);
    }

    //конструктор с наследованием
    public FragileParcel(String nameConsignee, String address, double weight, String trackNumber, boolean requiresCarefulHandling) {
        super(nameConsignee, address, weight, trackNumber);
        this.requiresCarefulHandling = requiresCarefulHandling;
    }

    //геттеры и сеттеры
    public void setRequiresCarefulHandling(boolean requiresCarefulHandling) {
        this.requiresCarefulHandling = requiresCarefulHandling;
    }

    public boolean getRequiresCarefulHandling() {
        return requiresCarefulHandling;
    }
}
