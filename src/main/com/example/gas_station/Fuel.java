package com.example.gas_station;

import java.util.Objects;

public class Fuel {
    private final Liters liters;
    private final Type type;

    private Fuel(Liters liters, Type type) {
        this.liters = liters;
        this.type = type;
    }

    public Liters liters() {
        return liters;
    }

    public static Fuel petrol(float liters) {
        return new Fuel(Liters.valueOf(liters), Type.PETROL);
    }

    public static Fuel diesel(float liters) {
        return new Fuel(Liters.valueOf(liters), Type.DIESEL);
    }

    public Fuel add(Liters liters) {
        return new Fuel(this.liters.add(liters), type);
    }

    public Fuel remove(Liters liters) {
        return new Fuel(this.liters.remove(liters), type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fuel fuel = (Fuel) o;
        return liters.equals(fuel.liters) && type == fuel.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(liters, type);
    }

    @Override
    public String toString() {
        return "Fuel{" +
                "liters=" + liters.toString() +
                ", type=" + type +
                '}';
    }

    enum Type {
        PETROL, DIESEL
    }
}
