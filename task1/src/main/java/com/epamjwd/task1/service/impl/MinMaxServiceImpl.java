package com.epamjwd.task1.service.impl;

import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.service.MinMaxService;

import java.util.Arrays;

public class MinMaxServiceImpl implements MinMaxService {
    @Override
    public Number getMin(DoubleArray customArray) {
        return Arrays.stream(customArray.getArray()).mapToDouble(i -> i).min().orElse(Double.NaN);
    }

    @Override
    public Number getMax(DoubleArray customArray) {
        return Arrays.stream(customArray.getArray()).mapToDouble(i -> i).max().orElse(Double.NaN);
    }
}
