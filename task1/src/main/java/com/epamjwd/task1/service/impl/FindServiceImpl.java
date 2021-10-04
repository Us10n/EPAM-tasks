package com.epamjwd.task1.service.impl;

import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.exception.DoubleArrayException;
import com.epamjwd.task1.service.FindService;

import java.util.Arrays;

public class FindServiceImpl implements FindService {
    @Override
    public Double getAverage(DoubleArray doubleArray) {
        Double[] doubles = doubleArray.getArray();
        if (doubles.length == 1) {
            return doubles[0];
        }
        double sum = 0;
        for (Double aDouble : doubles) {
            sum += aDouble;
        }
        return sum / doubles.length;
    }

    @Override
    public Double getAverageUsingStream(DoubleArray doubleArray) {
        return Arrays.stream(doubleArray.getArray()).mapToDouble(Double::doubleValue).average().orElse(Double.NaN);
    }

    @Override
    public Double getMin(DoubleArray doubleArray) {
        Double[] doubles = doubleArray.getArray();
        if (doubles.length == 1) {
            return doubles[0];
        }
        double min = doubles[0];
        for (int i = 1; i < doubles.length; i++) {
            min = doubles[i] < min ? doubles[i] : min;
        }
        return min;
    }

    @Override
    public Double getMinUsingStream(DoubleArray doubleArray) {
        return Arrays.stream(doubleArray.getArray()).mapToDouble(Double::doubleValue).min().orElse(Double.NaN);
    }

    @Override
    public Double getMax(DoubleArray doubleArray) {
        Double[] doubles = doubleArray.getArray();
        if (doubles.length == 1) {
            return doubles[0];
        }
        double max = doubles[0];
        for (int i = 1; i < doubles.length; i++) {
            max = doubles[i] > max ? doubles[i] : max;
        }
        return max;
    }

    @Override
    public Double getMaxUsingStream(DoubleArray doubleArray) {
        return Arrays.stream(doubleArray.getArray()).mapToDouble(Double::doubleValue).max().orElse(Double.NaN);
    }

    @Override
    public DoubleArray replaceByIndex(DoubleArray doubleArray, int index, Double newValue) throws DoubleArrayException {
        Double[] doubles = doubleArray.getArray();
        if ((index < 0) || (index >= doubles.length)) {
            throw new DoubleArrayException("Index out of range: " + index);
        }
        doubles[index]=newValue;

        return new DoubleArray(doubles);
    }

    @Override
    public Double getSum(DoubleArray doubleArray) {
        Double sum=0.;
        Double[] doubles = doubleArray.getArray();
        for(Double number: doubles) {
            sum += number;
        }
        return sum;
    }

    @Override
    public Double getSumUsingStream(DoubleArray doubleArray) {
        return Arrays.stream(doubleArray.getArray()).mapToDouble(Double::doubleValue).sum();
    }

    @Override
    public Long getPositiveNumberAmount(DoubleArray doubleArray) {
        Long count = 0L;
        Double[] doubles = doubleArray.getArray();

        for (Double aDouble : doubles) {
            if (aDouble > 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Long getPositiveNumberAmountUsingStream(DoubleArray doubleArray) {
        return Arrays.stream(doubleArray.getArray()).mapToDouble(Double::doubleValue).filter(p -> p > 0.).count();
    }

    @Override
    public Long getNegativeNumberAmount(DoubleArray doubleArray) {
        Long count = 0L;
        Double[] doubles = doubleArray.getArray();
        for (Double aDouble : doubles) {
            if (aDouble < 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Long getNegativeNumberAmountUsingStream(DoubleArray doubleArray) {
        return Arrays.stream(doubleArray.getArray()).mapToDouble(Double::doubleValue).filter(p -> p < 0.).count();
    }
}
