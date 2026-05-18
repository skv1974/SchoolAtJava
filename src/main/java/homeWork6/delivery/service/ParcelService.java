package homeWork6.delivery.service;

import homeWork6.delivery.model.Parcel;

public class ParcelService {

    public void printParcelsReport(Parcel[] parcels){

        for (Parcel parcel : parcels){

            parcel.printInfo();
            System.out.println("Стоимость доставки - " + parcel.calculateDeliveryPrice());
            System.out.println("========");
        }
    }
}
