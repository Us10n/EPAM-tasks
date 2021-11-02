package com.epamjwd.task2.validator;

import com.epamjwd.task2.entity.Cube;

public class CubeValidator {
    private static CubeValidator instance;

    private CubeValidator() {
    }

    public static CubeValidator getInstance() {
        if (instance == null) {
            instance = new CubeValidator();
        }
        return instance;
    }

    public boolean isCube(Cube cube) {
        return cube != null && cube.getEdgeLength() > 0;
    }

}
