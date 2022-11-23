package com.example.gas_station.refuel;

import com.example.gas_station.Fuel;
import com.example.gas_station.base.EntityForRefuel;

public class Tank extends EntityForRefuel {
    private Tank(Fuel fuel) {
        super(fuel);
    }

    public static Tank of(Fuel fuel){
        return new Tank(fuel);
    }
}
