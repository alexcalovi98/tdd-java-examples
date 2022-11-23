package com.example.gas_station.refuel;

import com.example.gas_station.Car;
import com.example.gas_station.Fuel;
import com.example.gas_station.Liters;
import org.junit.Assert;
import org.junit.Test;

public class PumpTest {

    @Test
    public void testPumpPetrolLevel(){
        Pump pump = Pump.of(Fuel.petrol(2000f));

        Assert.assertEquals(Fuel.petrol(2000f), pump.fuelLevel());
    }

    @Test
    public void testPumpRefuelCar(){
        Pump pump = Pump.of(Fuel.petrol(2000f));
        Car car = Car.create(Fuel.petrol(20f));

        pump.refuel(car, Liters.valueOf(50f));

        Assert.assertEquals(Fuel.petrol(1950f), pump.fuelLevel());
        Assert.assertEquals(Fuel.petrol(70f), car.fuelLevel());
    }

    @Test
    public void testPumpRefuelCarButTheFuelLevelIsTooLow(){
        Pump pump = Pump.of(Fuel.petrol(20f));
        Car car = Car.create(Fuel.petrol(30f));

        pump.refuel(car, Liters.valueOf(60f));

        //if there is not enough fuel, skip the refuel
        Assert.assertEquals(Fuel.petrol(20f), pump.fuelLevel());
        Assert.assertEquals(Fuel.petrol(30f), car.fuelLevel());
    }

    @Test
    public void testPumpRefuelCarWithTheSameFuelLevel(){
        Pump pump = Pump.of(Fuel.petrol(20f));
        Car car = Car.create(Fuel.petrol(30f));

        pump.refuel(car, Liters.valueOf(20f));

        Assert.assertEquals(Fuel.petrol(0), pump.fuelLevel());
        Assert.assertEquals(Fuel.petrol(50f), car.fuelLevel());
    }
}
