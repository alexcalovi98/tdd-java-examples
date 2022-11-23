package com.example.gas_station.base;

import com.example.gas_station.Fuel;

import java.util.Objects;

public abstract class EntityWithFuel {

    protected Fuel fuel;

    protected EntityWithFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Fuel fuelLevel() {
        return this.fuel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityWithFuel e = (EntityWithFuel) o;
        return fuel.equals(e.fuel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuel);
    }
}
