package org.prog;

import org.prog.cars.*;

public class Main {
    //test

    public static void main(String[] args) {
//        Samsung samsung = new Samsung();
//        SamsungAndroindGenOne samsungAndroindGenOne = new SamsungAndroindGenOne();
//        SamsungAndroindGenTwo samsungAndroindGenTwo = new SamsungAndroindGenTwo();
//        SamsungAndroindGenThree samsungAndroindGenThree = new SamsungAndroindGenThree();
//        SamsungAndroindGenFour samsungAndroindGenFour = new SamsungAndroindGenFour();
//        SamsungAndroindGenFive samsungAndroindGenFive = new SamsungAndroindGenFive();
//        SamsungAndroindGenSix samsungAndroindGenSix = new SamsungAndroindGenSix();
//
//        samsung.getResolution();
//        samsungAndroindGenOne.getResolution();
//        samsungAndroindGenTwo.getResolution();
//        samsungAndroindGenThree.getResolution();
//        samsungAndroindGenFour.getResolution();
//        samsungAndroindGenFive.getResolution();
//        samsungAndroindGenSix.getResolution();
//        Tesla tesla = new Tesla();
//        Honda honda = new Honda();
        Ford ford = new Ford();
//
////        useTesla(tesla);
//
//        useCar(tesla);
//        useCar(honda);
//        useCar(ford);

//        ford.driveTo("Kyiv");
//        ford.driveTo("Kyiv", "Odessa");
//        ford.driveTo("Kyiv", "Odessa", "Dnepr");

/*        Person person = new Person();


        person.iWant("iPhone", "14 Pro max", "256 GB");
        person.iWant("iPhone", "14 Pro max");
        person.iWant("iPhone");
        person.iWant();*/

        Truck truck = new Truck();
        truck.turn();

        CargoTruck cargo = new CargoTruck();
        cargo.turn();

        Lorry lorry = new Lorry();
        lorry.turn();

        Tesla telsa = new Tesla();
        useTesla(telsa);

        useFord(ford);

        Honda honda = new Honda();
        useHonda(honda);

        System.out.println("ICar:");
        useCar(honda);
        useCar(ford);
        useCar(telsa);

    }

    public static void useCar(ICar iCar) {
        iCar.fillCar();
        iCar.goTo();
        iCar.maxSpeed();
    }

    public static void useTesla(Tesla tesla) {
        tesla.goTo();
        tesla.autoPilot();
        tesla.maxSpeed();
    }

    public static void useFord(Ford ford) {
        ford.goTo();
        ford.fillCar();
        ford.maxSpeed();
    }

    public static void useHonda(Honda honda) {
        honda.goTo();
        honda.fillCar();
        honda.maxSpeed();
    }


}

