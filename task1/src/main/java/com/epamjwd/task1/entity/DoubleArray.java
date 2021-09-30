package com.epamjwd.task1.entity;

import java.util.Arrays;

public class DoubleArray implements CustomArray {
    private Double[] array;


    @Override
    public DoubleArray doubleArray() {
        return this;
    }

    public DoubleArray(Double[] array) {
        this.array = array;
    }

    public DoubleArray() {
    }

    public Double[] getArray() {
        return array;
    }

    public void setArray(Double[] array) {
        this.array = array;
    }

    public Integer getSize() {
        return array.length;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleArray that = (DoubleArray) o;
        if (this.array.length != that.array.length) return false;

        boolean result = true;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != that.array[i]) {
                result = false;
                break;
            }
        }
        return result;
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
        return "CustomArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
