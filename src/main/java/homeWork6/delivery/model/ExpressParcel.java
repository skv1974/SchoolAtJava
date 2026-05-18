package homeWork6.delivery.model;

public class ExpressParcel extends Parcel{

    int deliveryHours;

    //стоимость доставки с наследованием
    public double calculateDeliveryPrice(){

        if (this.deliveryHours < 24){
        return (super.calculateDeliveryPrice() + 500);

        }else return super.calculateDeliveryPrice();

    }

    //вывод инфо о посылке с наследованием
    public void printInfo(){
        super.printInfo();
        System.out.println("Delivery deadline: " + this.deliveryHours);
    }

    //====================
    //конструктор с наследованием
    public ExpressParcel(String nameConsignee, String address, double weight, String trackNumber, int deliveryHours) {
        super(nameConsignee, address, weight, trackNumber);
        this.deliveryHours = deliveryHours;
    }

    //геттеры и сеттеры
    public int getDeliveryHours() {
        return deliveryHours;
    }

    public void setDeliveryHours(int deliveryHours) {
        this.deliveryHours = deliveryHours;
    }
}
