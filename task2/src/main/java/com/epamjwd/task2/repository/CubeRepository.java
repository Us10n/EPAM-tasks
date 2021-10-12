package com.epamjwd.task2.repository;

import com.epamjwd.task2.entity.Cube;

import java.util.ArrayList;
import java.util.List;

public class CubeRepository {
    private List<Cube> cubeList = new ArrayList<>();

    public boolean add(Cube cube) {
        return cubeList.add(cube);
    }

    public boolean remove(Cube cube) {
        return cubeList.remove(cube);
    }

    public Cube findByIndex(int index) {
        return cubeList.get(index);
    }

    public Cube findById(int index) {
        return cubeList.get(index);
    }
}
