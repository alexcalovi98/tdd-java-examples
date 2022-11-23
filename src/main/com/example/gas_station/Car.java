package com.example.gas_station;

import com.example.gas_station.base.EntityWithFuel;

public class Car extends EntityWithFuel {

    private Car(Fuel fuel) {
        super(fuel);
    }

    public static Car create(Fuel fuel) {
        return new Car(fuel);
    }

    public void refuel(Fuel fuelToAdd) {
        fuel = fuel.add(fuelToAdd.liters());
    }
}
