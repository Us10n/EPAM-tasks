package com.epamjwd.task1.service.impl;

import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.service.AverageValueService;

import java.util.Arrays;

public class AverageValueServiceImpl implements AverageValueService {
    @Override
    public Number getAverage(DoubleArray array) {
        return Arrays.stream(array.getArray()).mapToDouble(i -> i).average().orElse(Double.NaN);
    }
}
