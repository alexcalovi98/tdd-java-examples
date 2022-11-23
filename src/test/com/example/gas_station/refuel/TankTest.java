package com.example.gas_station.refuel;

import com.example.gas_station.Fuel;
import com.example.gas_station.Liters;
import org.junit.Assert;
import org.junit.Test;

public class TankTest {

    @Test
    public void testTankEquals(){
        Tank tank = Tank.of(Fuel.petrol(5000));

        Assert.assertEquals(Tank.of(Fuel.petrol(5000)), tank);
    }

    @Test
    public void testRefuelTank(){
        Tank tank = Tank.of(Fuel.petrol(5000f));
        Pump pump = Pump.of(Fuel.petrol(50f));

        tank.refuel(pump, Liters.valueOf(1450f));

        Assert.assertEquals(Fuel.petrol(3550f), tank.fuelLevel());
        Assert.assertEquals(Fuel.petrol(1500f), pump.fuelLevel());
    }
}
