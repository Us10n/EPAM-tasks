package com.epamjwd.task1.factory;

import com.epamjwd.task1.entity.DoubleArray;

public class CustomFactory {
    private static CustomFactory instance;

    public DoubleArray createArray(Double[] args){
        return new DoubleArray(args);
    }

    public static CustomFactory getInstance() {
        if (instance == null) {
            instance = new CustomFactory();
        }
        return instance;
    }
}
