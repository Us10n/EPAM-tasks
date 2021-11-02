package com.epamjwd.task2.repository;

import com.epamjwd.task2.entity.Cube;

import java.util.*;
import java.util.stream.Collectors;

public class CubeRepository {
    private static CubeRepository instance;
    private final List<Cube> cubeList = new ArrayList<>();

    private CubeRepository() {
    }

    public static CubeRepository getInstance() {
        if (instance == null) {
            instance = new CubeRepository();
        }
        return instance;
    }

    public Cube findByIndex(int index) {
        return cubeList.get(index);
    }

    public Cube findById(int id) {
        return cubeList.get(id);
    }

    public List<Cube> getCubes() {
        return Collections.unmodifiableList(cubeList);
    }

    public boolean add(Cube cube) {
        return cubeList.add(cube);
    }

    public boolean remove(Cube cube) {
        return cubeList.remove(cube);
    }

    public Cube remove(int index) {
        return cubeList.remove(index);
    }

    public int size() {
        return cubeList.size();
    }

    public boolean isEmpty() {
        return cubeList.isEmpty();
    }

    public boolean addAll(Collection<Cube> collection) {
        return cubeList.addAll(collection);
    }

    public boolean removeAll(Collection<Cube> collection) {
        return cubeList.removeAll(collection);
    }

    public List<Cube> sort(Comparator<Cube> comparator) {
        return cubeList.stream().sorted(comparator).collect(Collectors.toList());
    }

    public List<Cube> query(Specification specification){
        return cubeList.stream().filter(specification::specify).collect(Collectors.toList());
    }
}
