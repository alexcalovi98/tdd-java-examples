package com.example.gas_station;

import com.example.gas_station.refuel.Tank;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GasStationE2ETest {

    /** Arriva il tank a riempire la pompa di 100L di benzina,
     * arriva una macchina Diesel e chiede 10L,
     * arrivano 4 auto che chiedono 30L ognuna.
     * Controlla lo stato finale di tutte le cinque auto e la pompa
     */
    @Test
    public void testGasStationTestCaseOne(){
        FuelDistributor fuelDistributor = FuelDistributor.create(5000, 5000);
        Tank tank = Tank.of(Fuel.petrol(100));
        Car dieselCar = Car.create(Fuel.diesel(5));
        List<Car> petrolCars = createFourPetrolCars();

        tank.refuel(fuelDistributor.petrolPump(), Liters.valueOf(100f));
        fuelDistributor.dieselPump().refuel(dieselCar, Liters.valueOf(10f));
        for(Car petrolCar : petrolCars){
            fuelDistributor.petrolPump().refuel(petrolCar, Liters.valueOf(30f));
        }

        Assert.assertEquals(Fuel.diesel(15f), dieselCar.fuelLevel());
        for(Car petrolCar: petrolCars){
            Assert.assertEquals(Fuel.petrol(35f), petrolCar.fuelLevel());
        }
        Assert.assertEquals(Fuel.petrol(4980f), fuelDistributor.petrolPump().fuelLevel());
        Assert.assertEquals(Fuel.diesel(4990f), fuelDistributor.dieselPump().fuelLevel());
    }

    private List<Car> createFourPetrolCars() {
        List<Car> petrolCars = new ArrayList<>(4);
        for(int i = 0; i < 4; i++){
            petrolCars.add(Car.create(Fuel.petrol(5)));
        }
        return petrolCars;
    }
}
