package com.epamjwd.task1.service;

import com.epamjwd.task1.entity.CustomArray;

public interface SortService {
    public CustomArray bubbleSort(CustomArray customArray, SortDirection direction);
    public CustomArray selectSort(CustomArray customArray, SortDirection direction);
    public CustomArray inserSort(CustomArray customArray,SortDirection direction);
}
