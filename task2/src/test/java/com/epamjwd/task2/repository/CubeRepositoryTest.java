package com.epamjwd.task2.repository;

import com.epamjwd.task2.comparator.*;
import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;
import com.epamjwd.task2.repository.impl.IdSpecification;
import com.epamjwd.task2.repository.impl.SurfaceAreaSpecification;
import com.epamjwd.task2.repository.impl.VolumeSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class CubeRepositoryTest {
    CubeRepository repository;
    List<Cube> cubeList;

    @BeforeClass
    public void init() {
        repository = CubeRepository.getInstance();
        cubeList = new ArrayList<>();
        Cube cube1 = new Cube(new Point(0., 22., 1.1), 2.);
        Cube cube2 = new Cube(new Point(1.5, 10., -2.8), 1.);
        Cube cube3 = new Cube(new Point(-1., 5., 3.1), 3.2);
        cubeList.add(cube1);
        cubeList.add(cube2);
        cubeList.add(cube3);

        repository.addAll(cubeList);
    }

    @Test
    public void testSortX() {
        List<Cube> expected = cubeList.stream().sorted(new CoordinateXComparator()).collect(Collectors.toList());
        List<Cube> actual = repository.sort(new CoordinateXComparator());

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortY() {
        List<Cube> expected = cubeList.stream().sorted(new CoordinateYComparator()).collect(Collectors.toList());
        List<Cube> actual = repository.sort(new CoordinateYComparator());

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortZ() {
        List<Cube> expected = cubeList.stream().sorted(new CoordinateZComparator()).collect(Collectors.toList());
        List<Cube> actual = repository.sort(new CoordinateZComparator());

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortEdgeLength() {
        List<Cube> expected = cubeList.stream().sorted(new EdgeLengthComparator()).collect(Collectors.toList());
        List<Cube> actual = repository.sort(new EdgeLengthComparator());

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortId() {
        List<Cube> expected = cubeList.stream().sorted(new IdComparator()).collect(Collectors.toList());
        List<Cube> actual = repository.sort(new IdComparator());

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testQueryId() {
        List<Cube> expected = cubeList.stream().filter(new IdSpecification(1)::specify).collect(Collectors.toList());
        List<Cube> actual = repository.query(new IdSpecification(1)::specify);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testQuerySurfaceArea() {
        List<Cube> expected = cubeList.stream().filter(new SurfaceAreaSpecification(6.)::specify).collect(Collectors.toList());
        List<Cube> actual = repository.query(new SurfaceAreaSpecification(6.)::specify);

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testQueryVolume() {
        List<Cube> expected = cubeList.stream().filter(new VolumeSpecification(8.)::specify).collect(Collectors.toList());
        List<Cube> actual = repository.query(new VolumeSpecification(8.)::specify);

        Assert.assertEquals(actual, expected);
    }
}