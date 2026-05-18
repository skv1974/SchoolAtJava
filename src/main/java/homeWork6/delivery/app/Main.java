package homeWork6.delivery.app;

import homeWork6.delivery.model.ExpressParcel;
import homeWork6.delivery.model.FragileParcel;
import homeWork6.delivery.model.Parcel;
import homeWork6.delivery.service.ParcelService;

public class Main {
    public static void main(String[] args) {

        ParcelService parcelService = new ParcelService();

        //простая посылка созданная пустым конструктором
        Parcel emptyParcel = new Parcel();

        emptyParcel.setNameConsignee("name1");
        emptyParcel.setAddress("address1");
        emptyParcel.setWeight(101);
        emptyParcel.setTrackNumber("trackNumber1");

        //простая посылка созданная параметризированным конструктором
        Parcel simpleParcel = new Parcel("name2",
                "address2",
                102,
                "trackNumber2");

        //хрупкая посылка
        FragileParcel fragileParcel = new FragileParcel("name3",
                "address3",
                103,
                "trackNumber3",
                true);

        //экспресс посылка
        ExpressParcel expressParcel = new ExpressParcel("name4",
                "address4",
                104,
                "trackNumber4",
                23);

        //массив из созданных посылок
        Parcel[] parcels = {emptyParcel, simpleParcel, fragileParcel, expressParcel};

        parcelService.printParcelsReport(parcels);
    }
}
