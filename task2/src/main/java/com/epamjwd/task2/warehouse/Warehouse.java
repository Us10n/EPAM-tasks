package com.epamjwd.task2.warehouse;

import com.epamjwd.task2.entity.CubeParameter;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    public static Warehouse instance;
    private final Map<Long, CubeParameter> cubeParameterMap;

    private Warehouse() {
        cubeParameterMap = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void putParameters(long cubeId, CubeParameter cubeParameter) {
        cubeParameterMap.put(cubeId, cubeParameter);
    }

    public CubeParameter getParameters(long cubeId) {
        return cubeParameterMap.get(cubeId);
    }

    public boolean updateParameters(long cubeId, double surfaceSquare, double volume) {
        CubeParameter cubeParameter = cubeParameterMap.get(cubeId);
        if (cubeParameter == null) {
            return false;
        }
        cubeParameter.setSurfaceArea(surfaceSquare);
        cubeParameter.setVolume(volume);
        return true;
    }
}
