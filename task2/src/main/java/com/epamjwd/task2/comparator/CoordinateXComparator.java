package com.epamjwd.task2.comparator;

import com.epamjwd.task2.entity.Cube;

import java.util.Comparator;

public class CoordinateXComparator implements Comparator<Cube> {
    @Override
    public int compare(Cube cube1, Cube cube2) {
        return Double.compare(cube1.getCenter().getX(), cube2.getCenter().getX());
    }

}
