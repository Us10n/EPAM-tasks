package com.epamjwd.task2.service.impl;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.channels.Pipe;

import static org.testng.Assert.*;

public class CalculationCubeServiceImplTest {

    @Test
    public void testSurfaceArea() {
        Point center=new Point(0.,0.,0.);
        Cube cube=new Cube(center,2.);
        CalculationCubeServiceImpl cubeService=new CalculationCubeServiceImpl();
        Double expected=24.;
        Double actual=cubeService.surfaceArea(cube);

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testVolume() {
        Point center=new Point(0.,0.,0.);
        Cube cube=new Cube(center,2.);
        CalculationCubeServiceImpl cubeService=new CalculationCubeServiceImpl();
        Double expected=8.;
        Double actual=cubeService.volume(cube);

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testVolumeRatio() {
        Point center=new Point(0.,0.,0.);
        Cube cube=new Cube(center,2.);
        CalculationCubeServiceImpl cubeService=new CalculationCubeServiceImpl();
        Double expected=1.;
        Point secantPoint =new Point(0.,0.,0.);
        Double actual=cubeService.volumeRatio(cube,secantPoint );

        Assert.assertEquals(actual,expected);
    }
}