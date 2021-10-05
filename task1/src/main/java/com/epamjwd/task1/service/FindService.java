package com.epamjwd.task1.service;

import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.exception.DoubleArrayException;

public interface FindService {
    Double min(DoubleArray array);
    Double minUsingStream(DoubleArray array);
    Double max(DoubleArray array);
    Double maxUsingStream(DoubleArray array);

    DoubleArray replaceByIndex(DoubleArray array, int index, Double newValue) throws DoubleArrayException;

    Double sum(DoubleArray array);
    Double sumUsingStream(DoubleArray array);

    Double average(DoubleArray array);
    Double averageUsingStream(DoubleArray array);

    Long positiveNumberAmount(DoubleArray array);
    Long positiveNumberAmountUsingStream(DoubleArray array);

    Long negativeNumberAmount(DoubleArray array);
    Long negativeNumberAmountUsingStream(DoubleArray array);
}
