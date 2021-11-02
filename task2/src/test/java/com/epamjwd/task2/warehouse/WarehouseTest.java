package com.epamjwd.task2.warehouse;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.CubeParameter;
import com.epamjwd.task2.entity.Point;
import com.epamjwd.task2.service.CalculationCubeService;
import com.epamjwd.task2.service.impl.CalculationCubeServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class WarehouseTest {
    Warehouse warehouse;

    @BeforeTest
    public void init() {
        warehouse = Warehouse.getInstance();
    }

    @Test
    public void testPutParameters() {
        Cube cube = new Cube(new Point(1., 2., 3.), 1.);
        CalculationCubeServiceImpl cubeService = new CalculationCubeServiceImpl();

        Double surfaceArea = cubeService.surfaceArea(cube);
        Double volume = cubeService.volume(cube);

        CubeParameter cubeParameter = new CubeParameter();
        cubeParameter.setSurfaceArea(surfaceArea);
        cubeParameter.setVolume(volume);

        warehouse.putParameters(cube.getCubeId(), cubeParameter);

        CubeParameter expected = cubeParameter;
        CubeParameter actual = warehouse.getParameters(cube.getCubeId());

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetParameters() {
        Cube cube = new Cube(new Point(1., 2., 3.), 1.);
        CalculationCubeServiceImpl cubeService = new CalculationCubeServiceImpl();

        Double surfaceArea = cubeService.surfaceArea(cube);
        Double volume = cubeService.volume(cube);

        CubeParameter cubeParameter = new CubeParameter();
        cubeParameter.setSurfaceArea(surfaceArea);
        cubeParameter.setVolume(volume);

        warehouse.putParameters(cube.getCubeId(), cubeParameter);

        CubeParameter expected = cubeParameter;
        CubeParameter actual = warehouse.getParameters(cube.getCubeId());

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testUpdateParameters() {
        Cube cube = new Cube(new Point(1., 2., 3.), 1.);
        CalculationCubeServiceImpl cubeService = new CalculationCubeServiceImpl();

        Double surfaceArea = cubeService.surfaceArea(cube);
        Double volume = cubeService.volume(cube);

        CubeParameter cubeParameter = new CubeParameter();
        cubeParameter.setSurfaceArea(surfaceArea);
        cubeParameter.setVolume(volume);

        warehouse.putParameters(cube.getCubeId(), cubeParameter);

        boolean expected=true;
        boolean actual = warehouse.updateParameters(cube.getCubeId(), 0.,0.);

        Assert.assertEquals(actual, expected);
    }
}