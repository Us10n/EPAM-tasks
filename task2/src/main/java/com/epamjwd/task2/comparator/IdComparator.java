package com.epamjwd.task2.comparator;

import com.epamjwd.task2.entity.Cube;

import java.util.Comparator;

public class IdComparator implements Comparator<Cube> {
    @Override
    public int compare(Cube cube1, Cube cube2) {
        return Long.compare(cube1.getCubeId(),cube2.getCubeId());
    }
}
