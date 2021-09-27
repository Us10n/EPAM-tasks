package com.epamjwd.lab0.factory;

import com.epamjwd.lab0.entity.CustomNumber;

public class CustomFactory {
    private static CustomFactory instance;

    public CustomNumber getNumber(NumberTypes type){
        switch (type) {
            case CustomNumber:
                return new CustomNumber();
            default:
                throw new IllegalArgumentException("Wrong doughnut type:" + type);
        }
    }
    public static CustomFactory getInstance() {
        if (instance == null) {
            instance = new CustomFactory();
        }
        return instance;
    }
}
