package org.prog.collections;

import java.awt.*;
import java.util.*;
import java.util.List;


/**
 * Write HashMap of owned cars, set their colors using enum you create
 * print owners of cars of certain color
 */
public class HomeWork {

    public static void main(String[] args) {


        Map<String, List<Car>> hw = new HashMap<>();
        hw.put("John", new ArrayList<>());
        List<Car> johnsCar = hw.get("John");
        johnsCar.add(new Car(CarColor.WHITE));
        johnsCar.add(new Car(CarColor.BLACK));
        johnsCar.add(new Car(CarColor.GREEN));

        hw.put("Kate", new ArrayList<>());
        List<Car> katesCar = hw.get("Kate");
        katesCar.add(new Car(CarColor.WHITE));

        hw.put("Mike", new ArrayList<>());
        List<Car> mikesCar = hw.get("Mike");
        mikesCar.add(new Car(CarColor.RED));
        mikesCar.add(new Car(CarColor.BLACK));

        List<String> owners = new ArrayList<>();
        for (Map.Entry<String, List<Car>> entry : hw.entrySet()) {
            for (Car value : entry.getValue()) {
                if (value.carColor == CarColor.GREEN){
                owners.add(entry.getKey());
            }
        }
    }
        System.out.println(owners);
}

/*        hw.put("John", list.add(new Car(CarColor.WHITE)));


        Map<String, List<Car>> ownedCars = new HashMap<>();
        ownedCars.put("Joe", new ArrayList<>());
        List<Car> joesCars = ownedCars.get("Joe");
        joesCars.add(redCar);

        ownedCars.get("Joe").add(new Car(CarColor.WHITE));*/

}
