package com.epamjwd.task1.service;

import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.exception.DoubleArrayException;

public interface FindService {
    Double getMin(DoubleArray array);
    Double getMinUsingStream(DoubleArray array);
    Double getMax(DoubleArray array);
    Double getMaxUsingStream(DoubleArray array);

    DoubleArray replaceByIndex(DoubleArray array, int index, Double newValue) throws DoubleArrayException;

    Double getSum(DoubleArray array);
    Double getSumUsingStream(DoubleArray array);

    Double getAverage(DoubleArray array);
    Double getAverageUsingStream(DoubleArray array);

    Long getPositiveNumberAmount(DoubleArray array);
    Long getPositiveNumberAmountUsingStream(DoubleArray array);

    Long getNegativeNumberAmount(DoubleArray array);
    Long getNegativeNumberAmountUsingStream(DoubleArray array);
}
