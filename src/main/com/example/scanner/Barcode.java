package com.example.scanner;

import java.util.Objects;

public class Barcode {

    private final String value;

    private Barcode(String value) {
        this.value = value;
    }

    static Barcode valueOf(String value){
        return new Barcode(value);
    }

    static Barcode empty(){
        return new Barcode("");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barcode barcode = (Barcode) o;
        return value.equals(barcode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
