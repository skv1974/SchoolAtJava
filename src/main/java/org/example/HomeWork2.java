package org.example;
import java.util.Random;
import static java.lang.Math.*;

public class HomeWork2 {
    public static void main(String[] args) {

        int ageCustomer;
        double sumAccountCustomer;
        double inviteSum = 0;
        boolean isBlackListCustomer;
        boolean isInviteCustomer;
        boolean isCheckedCustomer;

        Random random = new Random();

        ageCustomer = random.nextInt(10, 101); //узнаем возраст

        isBlackListCustomer = random.nextBoolean(); //черный список
        isInviteCustomer = random.nextBoolean();    //приглашение

        sumAccountCustomer = round(random.nextDouble(0,1000000)); //узнаем кол-во сольдо в кошельке

        if (ageCustomer >= 18 & isInviteCustomer  & (!isBlackListCustomer | sumAccountCustomer >= 50000)) {
            isCheckedCustomer = true;
            inviteSum = round(sumAccountCustomer * 0.075);
        } else isCheckedCustomer = false;

        System.out.println("BL - " + isBlackListCustomer);
        System.out.println("invite - " + isInviteCustomer);
        System.out.println("age - " + ageCustomer);
        System.out.println("amount - " + sumAccountCustomer);
        System.out.println("checked - " + isCheckedCustomer);
        System.out.println("inviteSum - " + inviteSum);
    }
}
