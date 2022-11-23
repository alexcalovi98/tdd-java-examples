package com.example.gas_station;

import com.example.gas_station.refuel.Pump;

import java.util.Objects;

public class FuelDistributor {

    private final Pump petrolPump;
    private final Pump dieselPump;

    private FuelDistributor(Pump petrolPump, Pump dieselPump) {
        this.petrolPump = petrolPump;
        this.dieselPump = dieselPump;
    }

    public static FuelDistributor create(float petrolLiters, float dieselLiters) {
        return new FuelDistributor(
                Pump.of(Fuel.petrol(petrolLiters)),
                Pump.of(Fuel.diesel(dieselLiters))
        );
    }

    public Pump petrolPump() {
        return petrolPump;
    }

    public Pump dieselPump() {
        return dieselPump;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelDistributor that = (FuelDistributor) o;
        return petrolPump.equals(that.petrolPump) && dieselPump.equals(that.dieselPump);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petrolPump, dieselPump);
    }

    @Override
    public String toString() {
        return "FuelDistributor{" +
                "petrolPump=" + petrolPump.toString() +
                ", dieselPump=" + dieselPump.toString() +
                '}';
    }
}
