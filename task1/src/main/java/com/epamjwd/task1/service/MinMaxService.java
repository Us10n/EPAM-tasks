package com.epamjwd.task1.service;

import com.epamjwd.task1.entity.CustomArray;
import com.epamjwd.task1.entity.DoubleArray;

public interface MinMaxService {
    public Number getMin(DoubleArray customArray);
    public Number getMax(DoubleArray customArray);

}
