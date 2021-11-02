package com.epamjwd.task2.comparator;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CoordinateXComparatorTest {

    @Test
    public void testCompareXEquals() {
        Point center1=new Point(1.,1.,1.);
        Point center2=new Point(1.,1.,1.);
        Cube cube1=new Cube(center1,4.);
        Cube cube2=new Cube(center2,4.);

        CoordinateXComparator comparator=new CoordinateXComparator();
        int actual=comparator.compare(cube1,cube2);
        int expected=0;

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testCompareXGreater() {
        Point center1=new Point(1.,1.,1.);
        Point center2=new Point(0.,1.,1.);
        Cube cube1=new Cube(center1,4.);
        Cube cube2=new Cube(center2,4.);

        CoordinateXComparator comparator=new CoordinateXComparator();
        int actual=comparator.compare(cube1,cube2);
        int expected=1;

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testCompareXLess() {
        Point center1=new Point(1.,1.,1.);
        Point center2=new Point(2.,1.,1.);
        Cube cube1=new Cube(center1,4.);
        Cube cube2=new Cube(center2,4.);

        CoordinateXComparator comparator=new CoordinateXComparator();
        int actual=comparator.compare(cube1,cube2);
        int expected=-1;

        Assert.assertEquals(actual,expected);
    }
}