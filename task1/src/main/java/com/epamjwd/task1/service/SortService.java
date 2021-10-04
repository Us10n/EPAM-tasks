package com.epamjwd.task1.service;

import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.exception.DoubleArrayException;

public interface SortService {
    public DoubleArray bubbleSort(DoubleArray customArray, SortDirection direction);
    public DoubleArray selectSort(DoubleArray customArray, SortDirection direction);
    public DoubleArray shellSort(DoubleArray customArray, SortDirection direction);
}
