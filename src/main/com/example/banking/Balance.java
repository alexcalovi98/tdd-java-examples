package com.example.banking;

import java.util.Objects;

public class Balance {

    private final int amount;

    private Balance(int amount) {
        this.amount = amount;
    }

    public Balance add(int amount){
        return new Balance(this.amount + amount);
    }

    public Balance remove(int amount) {
        return new Balance(this.amount - amount);
    }

    public static Balance valueOf(int value) {
        return new Balance(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return amount == balance.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }
}
