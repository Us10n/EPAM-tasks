package com.epamjwd.task2.factory;


import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomFactoryTest {

    @Test
    public void testCreatePoint() {
        Double[] pointCoordinate = {1., 4., 6.};
        Point point = GeometricFactory.getInstance().createPoint(pointCoordinate).get();
        Assert.assertNotNull(point);
    }

    @Test
    public void testCreateCube1() {
        Point center = new Point(1., 1., 1.);
        Double edgeLength = 2.;
        Cube cube = GeometricFactory.getInstance().createCube(center, edgeLength).get();
        Assert.assertNotNull(cube);
    }

    @Test
    public void testCreateCube2() {
        List<Double> cubeParameterList = new ArrayList();
        cubeParameterList.add(1.);
        cubeParameterList.add(2.1);
        cubeParameterList.add(11.1);
        cubeParameterList.add(3.23);
        Cube cube = GeometricFactory.getInstance().createCube(cubeParameterList).get();
        Assert.assertNotNull(cube);
    }

}