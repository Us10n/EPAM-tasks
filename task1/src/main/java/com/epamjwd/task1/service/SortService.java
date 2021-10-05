package com.epamjwd.task1.service;

import com.epamjwd.task1.entity.DoubleArray;

public interface SortService {
    DoubleArray bubbleSort(DoubleArray customArray, SortDirection direction);
    DoubleArray selectSort(DoubleArray customArray, SortDirection direction);
    DoubleArray shellSort(DoubleArray customArray, SortDirection direction);
}
