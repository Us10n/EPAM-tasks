package com.epamjwd.task2.comparator;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdComparatorTest {

    @Test
    public void testCompareIdEquals() {
        Point center1 = new Point(1., 1., 1.);
        Cube cube1 = new Cube(center1, 4.);

        IdComparator comparator=new IdComparator();
        int actual = comparator.compare(cube1, cube1);
        int expected = 0;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCompareIdGreater() {
        Point center1 = new Point(1., 1., 1.);
        Point center2 = new Point(1., 1., 1.);
        Cube cube1 = new Cube(center1, 5.);
        Cube cube2 = new Cube(center2, 4.);

        IdComparator comparator=new IdComparator();
        int actual = comparator.compare(cube2, cube1);
        int expected = 1;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCompareIdLess() {
        Point center1 = new Point(1., 1., 1.);
        Point center2 = new Point(1., 1., 2.);
        Cube cube1 = new Cube(center1, 3.);
        Cube cube2 = new Cube(center2, 4.);

        IdComparator comparator=new IdComparator();
        int actual = comparator.compare(cube1, cube2);
        int expected = -1;

        Assert.assertEquals(actual, expected);
    }
}