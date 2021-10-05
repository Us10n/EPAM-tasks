package com.epamjwd.task1.entity;

import java.util.Arrays;

public class DoubleArray {
    private Double[] array;

    public DoubleArray(Double[] array) {
        this.array = array;
    }

    public Double[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(Double[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public DoubleArray() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleArray that = (DoubleArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        if (array == null)
            return 0;
        int result = 1;
        for (Double value : this.array) {
            result += value.intValue() * 31;
        }

        return result;
    }

    @Override
    public String toString() {
        return "DoubleArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
