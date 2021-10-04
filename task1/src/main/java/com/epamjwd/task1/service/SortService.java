<<<<<<< HEAD
package com.epamjwd.task1.service;

import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.exception.DoubleArrayException;

public interface SortService {
    public DoubleArray bubbleSort(DoubleArray customArray, SortDirection direction);
    public DoubleArray selectSort(DoubleArray customArray, SortDirection direction);
    public DoubleArray shellSort(DoubleArray customArray, SortDirection direction);
}
=======
package com.epamjwd.task1.service;

import com.epamjwd.task1.entity.CustomArray;
import com.epamjwd.task1.entity.DoubleArray;

public interface SortService {
    public CustomArray bubbleSort(DoubleArray customArray, SortDirection direction);
    public CustomArray selectSort(DoubleArray customArray, SortDirection direction);
    public CustomArray inserSort(DoubleArray customArray, SortDirection direction);
}
>>>>>>> 33dda93079ed769fe037e304cdc43bd0d99737dc
