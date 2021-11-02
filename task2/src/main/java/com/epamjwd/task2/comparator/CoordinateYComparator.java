package com.epamjwd.task2.comparator;

import com.epamjwd.task2.entity.Cube;

import java.util.Comparator;

public class CoordinateYComparator implements Comparator<Cube> {
    @Override
    public int compare(Cube cube1, Cube cube2) {
        return Double.compare(cube1.getCenter().getY(), cube2.getCenter().getY());
    }

}
