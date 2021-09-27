package com.epamjwd.lab0.entity;

import static java.lang.Double.doubleToLongBits;

public class CustomNumber {
    private Double value;

    public CustomNumber(){
    }

    public CustomNumber(Double value) {
        this.value=value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        long bits = doubleToLongBits(value);
        return (int)(bits ^ (bits >>> 32));
    }

    @Override
    public String toString() {
        return "CustomNumber{" +
                "value=" + value +
                '}';
    }
}
