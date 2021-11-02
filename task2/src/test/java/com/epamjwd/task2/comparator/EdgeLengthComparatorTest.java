package com.epamjwd.task2.comparator;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EdgeLengthComparatorTest {

    @Test
    public void testCompareEdgeEquals() {
        Point center1 = new Point(1., 1., 1.);
        Point center2 = new Point(1., 1., 1.);
        Cube cube1 = new Cube(center1, 4.);
        Cube cube2 = new Cube(center2, 4.);

        EdgeLengthComparator comparator=new EdgeLengthComparator();
        int actual = comparator.compare(cube1, cube2);
        int expected = 0;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCompareEdgeGreater() {
        Point center1 = new Point(1., 1., 1.);
        Point center2 = new Point(1., 1., 1.);
        Cube cube1 = new Cube(center1, 5.);
        Cube cube2 = new Cube(center2, 4.);

        EdgeLengthComparator comparator=new EdgeLengthComparator();
        int actual = comparator.compare(cube1, cube2);
        int expected = 1;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCompareEdgeLess() {
        Point center1 = new Point(1., 1., 1.);
        Point center2 = new Point(1., 1., 2.);
        Cube cube1 = new Cube(center1, 3.);
        Cube cube2 = new Cube(center2, 4.);

        EdgeLengthComparator comparator=new EdgeLengthComparator();
        int actual = comparator.compare(cube1, cube2);
        int expected = -1;

        Assert.assertEquals(actual, expected);
    }
}