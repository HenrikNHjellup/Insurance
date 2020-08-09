package Programutvikling;


import Programutvikling.Model.Customer.Customer;

import java.io.IOException;


public class MainInsuranceTester {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Customer customer = new Customer("Simen","Skarkerud","12345678",
                "simen@mjosen.no","","2182","Gjøvik");

        System.out.println(customer);
/*
        Calendar cal = Calendar.getInstance();


        /* Tester av båtforsikring
        BoatInsurance båtforsikring = null;


        try {
            båtforsikring = new BoatInsurance(12345, 1000,
                    1000, cal, "insuranceConditions/BoatInsuranceConditions_34243.pdf", "etternavn", "fornavn",
                    "QWe987", "seilbåt", "seil2000", 30, 1998, "seil");



        } catch (InvalidInsuranceInputException e) {
            System.err.printf("exceptions fra subklasse : " + e.getMessage());
        }

        System.out.println("\n---------------------------");

        if (båtforsikring != null) {
            System.out.println(båtforsikring);
        } else System.out.println("forsikring ikke init");



        /*tester av husforsikring

        HouseInsurance husforsikring = null;
        try {
            husforsikring = new HouseInsurance(54321, 1000,
                    1000, cal, "insuranceConditions/BoatInsuranceConditions_34243.pdf", "Adresse", "Villa",
                    "reisverk", "middels", 120, 100_000_000,
                    250_000);


        } catch (InvalidInsuranceInputException e) {
            System.err.printf("exceptions fra subklasse : " + e.getMessage());
        }

        System.out.println("\n---------------------------");

        if (husforsikring != null) {
            System.out.println(husforsikring);
        } else System.out.println("forsikring ikke init");

    /*    Customer customer1 = new Customer("Ole", "Nilsen", "fsdf",
        "sdf", "sfd", "sdf", "sdf");
        customerList.add(customer1);
        System.out.println(customerList);
*/
    }
}

