package com.epamjwd.task1.service.impl;

import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.service.SortDirection;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class SortServiceImplTest {
    static SortServiceImpl sortService;

    @BeforeClass
    public static void setUp() {
        sortService = new SortServiceImpl();
    }

    @Test
    public void testBubbleSortUp() {
        Double[] nums = {-1.0, 12.5, 11.1, 23., 44., -11., 0.};
        DoubleArray doubleArray = new DoubleArray(nums);
        Double[] actual = sortService.bubbleSort(doubleArray, SortDirection.UP).getArray();
        Double[] expected = Arrays.stream(nums).sorted(Comparator.naturalOrder()).toArray(Double[]::new);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void testBubbleSortDown() {
        Double[] nums = {-1.0, 12.5, 11.1, 23., 44., -11., 0.};
        DoubleArray doubleArray = new DoubleArray(nums);
        Double[] actual = sortService.bubbleSort(doubleArray, SortDirection.DOWN).getArray();
        Double[] expected = Arrays.stream(nums).sorted(Comparator.reverseOrder()).toArray(Double[]::new);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void testSelectSortUp() {
        Double[] nums = {-1.0, 12.5, 11.1, 23., 44., -11., 0.};
        DoubleArray doubleArray = new DoubleArray(nums);
        Double[] actual = sortService.selectSort(doubleArray, SortDirection.UP).getArray();
        Double[] expected = Arrays.stream(nums).sorted(Comparator.naturalOrder()).toArray(Double[]::new);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void testSelectSortDown() {
        Double[] nums = {-1.0, 12.5, 11.1, 23., 44., -11., 0.};
        DoubleArray doubleArray = new DoubleArray(nums);
        Double[] actual = sortService.selectSort(doubleArray, SortDirection.DOWN).getArray();
        Double[] expected = Arrays.stream(nums).sorted(Comparator.reverseOrder()).toArray(Double[]::new);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void testShellSortUp() {
        Double[] nums = {-1.0, 12.5, 11.1, 23., 44., -11., 0.};
        DoubleArray doubleArray = new DoubleArray(nums);
        Double[] actual = sortService.selectSort(doubleArray, SortDirection.UP).getArray();
        Double[] expected = Arrays.stream(nums).sorted(Comparator.naturalOrder()).toArray(Double[]::new);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void testShellSortDown() {
        Double[] nums = {-1.0, 12.5, 11.1, 23., 44., -11., 0.};
        DoubleArray doubleArray = new DoubleArray(nums);
        Double[] actual = sortService.shellSort(doubleArray, SortDirection.DOWN).getArray();
        Double[] expected = Arrays.stream(nums).sorted(Comparator.reverseOrder()).toArray(Double[]::new);
        Assert.assertArrayEquals(expected,actual);
    }
}