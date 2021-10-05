package com.epamjwd.lab0.service;

import com.epamjwd.lab0.entity.CustomNumber;

import java.util.List;

public class CustomOperations extends Operations {

    @Override
    public CustomNumber add(List<CustomNumber> customNumberList) {
        if (customNumberList.size() < 2) {
            return null;
        }
        Double result = 0.;
        for (CustomNumber number : customNumberList) {
            result += number.getValue();
        }
        return new CustomNumber(result);
    }

    @Override
    public CustomNumber sub(List<CustomNumber> customNumberList) {
        if (customNumberList.size() < 2) {
            return null;
        }
        Double result = customNumberList.get(0).getValue();
        for (CustomNumber number : customNumberList.subList(1,customNumberList.size())) {
            result -= number.getValue();
        }
        return new CustomNumber(result);
    }

    @Override
    public CustomNumber mul(List<CustomNumber> customNumberList) {
        if (customNumberList.size() < 2) {
            return null;
        }
        Double result = 1.;
        for (CustomNumber number : customNumberList) {
            result *= number.getValue();
        }
        return new CustomNumber(result);
    }

    @Override
    public CustomNumber div(List<CustomNumber> customNumberList) {
        if (customNumberList.size() < 2) {
            return null;
        }
        Double result = customNumberList.get(0).getValue();
        for (CustomNumber number : customNumberList.subList(1,customNumberList.size())) {
            result /= number.getValue();
        }
        return new CustomNumber(result);
    }
}
