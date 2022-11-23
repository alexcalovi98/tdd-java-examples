package com.example.gas_station;

import org.junit.Assert;
import org.junit.Test;

public class CarTest {

    @Test
    public void testCarEquals(){
        Car car = Car.create(Fuel.petrol(20f));

        Assert.assertEquals(Car.create(Fuel.petrol(20f)), car);
    }

    @Test
    public void testCarRefuel(){
        Car car = Car.create(Fuel.petrol(20f));

        car.refuel(Fuel.petrol(30f));

        Assert.assertEquals(Fuel.petrol(50f), car.fuelLevel());
    }
}
