package com.example.gas_station;

import com.example.gas_station.refuel.Pump;
import org.junit.Assert;
import org.junit.Test;

public class FuelDistributorTest {

    @Test
    public void testFuelDistributorPumpLevels(){
        FuelDistributor fuelDistributor = FuelDistributor.create(3000f, 5000f);

        Assert.assertEquals(Fuel.petrol(3000f), fuelDistributor.petrolPump().fuelLevel());
        Assert.assertEquals(Fuel.diesel(5000f), fuelDistributor.dieselPump().fuelLevel());
    }

    @Test
    public void testFuelDistributorSelectPetrolPump(){
        FuelDistributor fuelDistributor = FuelDistributor.create(3000f, 5000f);

        Assert.assertEquals(Pump.of(Fuel.petrol(3000f)), fuelDistributor.petrolPump());
    }

    @Test
    public void testFuelDistributorSelectDieselPump(){
        FuelDistributor fuelDistributor = FuelDistributor.create(3000f, 5000f);

        Assert.assertEquals(Pump.of(Fuel.diesel(5000f)), fuelDistributor.dieselPump());
    }
}
