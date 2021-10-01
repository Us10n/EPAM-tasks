package com.epamjwd.task1.service;

import com.epamjwd.task1.entity.CustomArray;
import com.epamjwd.task1.entity.DoubleArray;

public interface SortService {
    public CustomArray bubbleSort(DoubleArray customArray, SortDirection direction);
    public CustomArray selectSort(DoubleArray customArray, SortDirection direction);
    public CustomArray inserSort(DoubleArray customArray, SortDirection direction);
}
