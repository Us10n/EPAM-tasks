package com.epamjwd.task1.service.impl;

import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.exception.DoubleArrayException;
import com.epamjwd.task1.service.SortDirection;
import com.epamjwd.task1.service.SortService;

public class SortServiceImpl implements SortService {
    @Override
    public DoubleArray bubbleSort(DoubleArray doubleArray, SortDirection direction) {
        Double[] sortedArray = doubleArray.getArray();
        Double tempValue;
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = 0; j < sortedArray.length - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1] && direction == SortDirection.UP) {
                    tempValue = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = tempValue;
                }
                if (sortedArray[j] < sortedArray[j + 1] && direction == SortDirection.DOWN) {
                    tempValue = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = tempValue;
                }
            }
        }
        DoubleArray sortedDoubleArray = new DoubleArray(sortedArray);

        return sortedDoubleArray;
    }

    @Override
    public DoubleArray selectSort(DoubleArray doubleArray, SortDirection direction){
        Double[] sortedArray = doubleArray.getArray();

        Double minValue = 0.;
        int minValueIndex = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            minValue = sortedArray[i];
            minValueIndex = i;
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[j] < minValue && direction == SortDirection.UP) {
                    minValue = sortedArray[j];
                    minValueIndex = j;
                }
                if (sortedArray[j] > minValue && direction == SortDirection.DOWN) {
                    minValue = sortedArray[j];
                    minValueIndex = j;
                }
            }
            sortedArray[minValueIndex] = sortedArray[i];
            sortedArray[i] = minValue;
        }

        DoubleArray sortedDoubleArray = new DoubleArray(sortedArray);

        return sortedDoubleArray;
    }

    @Override
    public DoubleArray shellSort(DoubleArray doubleArray, SortDirection direction){
        Double[] sortedArray = doubleArray.getArray();

        for (int gap = sortedArray.length / 2; gap > 0; gap /= 2) {
            boolean flag;
            do {
                flag = false;
                for (int i = 0, j = gap; j < sortedArray.length; i++, j++) {
                    if (sortedArray[i] > sortedArray[j] && direction == SortDirection.UP) {
                        Double tmp = sortedArray[j];
                        sortedArray[j] = sortedArray[i];
                        sortedArray[i] = tmp;
                        flag = true;
                    }
                    if (sortedArray[i] < sortedArray[j] && direction == SortDirection.DOWN) {
                        Double tmp = sortedArray[j];
                        sortedArray[j] = sortedArray[i];
                        sortedArray[i] = tmp;
                        flag = true;
                    }
                }
            } while (flag);
        }

        DoubleArray sortedDoubleArray = new DoubleArray(sortedArray);

        return sortedDoubleArray;
    }
}
