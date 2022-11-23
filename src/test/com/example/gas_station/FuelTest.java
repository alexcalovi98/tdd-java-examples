package com.example.gas_station;

import org.junit.Assert;
import org.junit.Test;

public class FuelTest {

    @Test
    public void testFuelEquals(){
        Fuel fuel = Fuel.petrol(20f);

        Assert.assertEquals(Fuel.petrol(20f), fuel);
    }

    @Test
    public void testFuelWithDifferentTypesNotEqualsEquals(){
        Fuel petrol = Fuel.petrol(20f);
        Fuel diesel = Fuel.diesel(20f);

        Assert.assertNotEquals(petrol, diesel);
    }

    @Test
    public void testAddFuel(){
        Fuel fuel = Fuel.petrol(20f);

        Fuel currentFuel = fuel.add(Liters.valueOf(80f));

        Assert.assertEquals(Fuel.petrol(100f), currentFuel);
    }

    @Test
    public void testRemoveFuel(){
        Fuel fuel = Fuel.petrol(50f);

        Fuel currentFuel = fuel.remove(Liters.valueOf(20f));

        Assert.assertEquals(Fuel.petrol(30f), currentFuel);
    }
}
