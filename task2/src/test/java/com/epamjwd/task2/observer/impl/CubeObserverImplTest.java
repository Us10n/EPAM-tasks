package com.epamjwd.task2.observer.impl;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.CubeParameter;
import com.epamjwd.task2.entity.Point;
import com.epamjwd.task2.service.impl.CalculationCubeServiceImpl;
import com.epamjwd.task2.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CubeObserverImplTest {
    Cube cube;
    CubeObserverImpl cubeObserver;
    Warehouse warehouse;


    @BeforeClass
    public void init() {
        Point cubeCenter = new Point(0., 0., 0.);
        cube = new Cube(cubeCenter, 4.);
        cube.attach(new CubeObserverImpl());
        cubeObserver = new CubeObserverImpl();
        warehouse = Warehouse.getInstance();

        CalculationCubeServiceImpl cubeService = new CalculationCubeServiceImpl();
        Double surfaceArea = cubeService.surfaceArea(cube);
        Double volume = cubeService.volume(cube);

        CubeParameter cubeParameter = new CubeParameter(surfaceArea, volume);
        warehouse.putParameters(cube.getCubeId(), cubeParameter);
    }


    @Test
    public void testAnyParameterChange() {
        cube.setEdgeLength(1.);
        Double expected=1.;
        Double actual=warehouse.getParameters(cube.getCubeId()).getVolume();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testSurfaceAreaChange() {
        cube.setEdgeLength(1.);
        Double expected=6.;
        Double actual=warehouse.getParameters(cube.getCubeId()).getSurfaceArea();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testVolumeChange() {
        cube.setEdgeLength(1.);
        Double expected=1.;
        Double actual=warehouse.getParameters(cube.getCubeId()).getVolume();
        Assert.assertEquals(actual,expected);
    }
}