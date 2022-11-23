package com.example.gas_station;

import java.util.Objects;

public class Liters implements Comparable<Liters> {

    private final float liters;

    private Liters(float liters) {
        this.liters = liters;
    }

    public static Liters valueOf(float liters){
        return new Liters(liters);
    }

    public Liters add(Liters litersToAdd) {
        return new Liters(this.liters + litersToAdd.liters);
    }

    public Liters remove(Liters litersToRemove) {
        return new Liters(this.liters - litersToRemove.liters);
    }

    @Override
    public int compareTo(Liters o) {
        return Float.compare(this.liters, o.liters);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Liters liters1 = (Liters) o;
        return Float.compare(liters1.liters, liters) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(liters);
    }

    @Override
    public String toString() {
        return "Liters{" +
                "liters=" + liters +
                '}';
    }
}
