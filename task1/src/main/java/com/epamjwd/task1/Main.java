package com.epamjwd.task1;

import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.exception.CustomFileException;
import com.epamjwd.task1.exception.DoubleArrayException;
import com.epamjwd.task1.parser.CustomParser;
import com.epamjwd.task1.reader.CustomReader;
import com.epamjwd.task1.service.SortDirection;
import com.epamjwd.task1.service.impl.FindServiceImpl;
import com.epamjwd.task1.service.impl.SortServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    private static final Logger Log = LogManager.getLogger();
    private static final String path = "./src/main/resources/data/nums.txt";

    public static void main(String[] args) throws CustomFileException, DoubleArrayException {
        CustomReader customReader = new CustomReader();
        List<String> stringList = customReader.readAll(path);

        List<DoubleArray> doubleArrayList = new ArrayList<>();
        stringList.forEach(line -> {
            DoubleArray doubleArray = CustomParser.getInstance().convertStringToDoubleArray(line);
            Optional<DoubleArray> optionalDoubleArray = Optional.ofNullable(doubleArray);
            optionalDoubleArray.ifPresent(doubleArrayList::add);
        });
        Log.info(doubleArrayList.toString());

        FindServiceImpl findService = new FindServiceImpl();
        SortServiceImpl sortService = new SortServiceImpl();
        doubleArrayList.forEach(array -> {
            Log.info("Min= " + findService.getMin(array));
            Log.info("Max= " +findService.getMax(array));
            Log.info("Average= "+findService.getAverage(array));
            try {
                Log.info("After replace(0 index)= "+findService.replaceByIndex(array,0,0.));
            } catch (DoubleArrayException e) {
                e.printStackTrace();
            }
            Log.info("Sum = "+ findService.getSum(array));
            Log.info("Number of positive= "+findService.getPositiveNumberAmount(array));
            Log.info("Number of negative= "+findService.getNegativeNumberAmount(array));
            Log.info("BubbleSort(UP): "+sortService.bubbleSort(array, SortDirection.UP));
            Log.info("SelectSort(DOWN): "+sortService.selectSort(array, SortDirection.DOWN));
            Log.info("ShellSort(UP): "+sortService.shellSort(array, SortDirection.UP));
        });
    }
}
