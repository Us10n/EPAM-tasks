package com.epamjwd.task2.validator;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CubeValidatorTest {

    @Test
    public void testIsCubePositive() {
        Point center=new Point(0.,0.,0.);
        Cube cube=new Cube(center,1.);

        CubeValidator validator= CubeValidator.getInstance();
        boolean actual=validator.isCube(cube);
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsCubeNegative() {
        Point center=new Point(0.,0.,0.);
        Cube cube=new Cube(center,-1.);

        CubeValidator validator= CubeValidator.getInstance();
        boolean actual=validator.isCube(cube);
        Assert.assertFalse(actual);
    }
}