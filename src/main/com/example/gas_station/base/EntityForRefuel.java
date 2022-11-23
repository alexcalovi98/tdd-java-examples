package com.example.gas_station.base;

import com.example.gas_station.Fuel;
import com.example.gas_station.Liters;

public abstract class EntityForRefuel extends EntityWithFuel {

    protected EntityForRefuel(Fuel fuel) {
        super(fuel);
    }

    public void refuel(EntityWithFuel entityWithFuel, Liters liters) {
        if(fuel.liters().compareTo(liters) > -1){
            entityWithFuel.fuel = entityWithFuel.fuel.add(liters);
            fuel = fuel.remove(liters);
        }
    }
}
