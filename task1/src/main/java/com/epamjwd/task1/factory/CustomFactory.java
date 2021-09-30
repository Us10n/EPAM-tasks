package com.epamjwd.task1.factory;

import com.epamjwd.task1.entity.CustomArray;
import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.exceptions.IllegalArrayType;

public class CustomFactory {
    private static CustomFactory instance;

    public CustomArray createArray(ArrayType type) throws IllegalArrayType {
        switch (type) {
            case DoubleArray:
                return new DoubleArray();
            default:
                throw new IllegalArrayType("Wrong array type: " + type);
        }
    }

    public static CustomFactory getInstance() {
        if (instance == null) {
            instance = new CustomFactory();
        }
        return instance;
    }
}
