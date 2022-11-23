package com.example.gas_station.refuel;

import com.example.gas_station.Fuel;
import com.example.gas_station.base.EntityForRefuel;

public class Pump extends EntityForRefuel {

    public Pump(Fuel fuel) {
        super(fuel);
    }

    public static Pump of(Fuel fuel) {
        return new Pump(fuel);
    }

    @Override
    public String toString() {
        return "Pump{" +
                "fuel=" + fuel.toString() +
                '}';
    }
}
