package com.epamjwd.lab0.factory;

import com.epamjwd.lab0.entity.CustomNumber;

public class CustomFactory {
    private static CustomFactory instance;

    public CustomNumber getNumber(Double arg){
        return new CustomNumber(arg);
    }
    public static CustomFactory getInstance() {
        if (instance == null) {
            instance = new CustomFactory();
        }
        return instance;
    }
}
