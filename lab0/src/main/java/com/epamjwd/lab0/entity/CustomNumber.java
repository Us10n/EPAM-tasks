package com.epamjwd.lab0.entity;

import java.util.Objects;

import static java.lang.Double.doubleToLongBits;

public class CustomNumber {
    private Double value;

    public CustomNumber() {
    }

    public CustomNumber(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomNumber that = (CustomNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        long bits = doubleToLongBits(value);
        return (int) (bits ^ (bits >>> 32));
    }

    @Override
    public String toString() {
        return "CustomNumber{" +
                "value=" + value +
                '}';
    }
}
