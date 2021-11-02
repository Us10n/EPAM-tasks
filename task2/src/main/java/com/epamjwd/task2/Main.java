package com.epamjwd.task2;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;
import com.epamjwd.task2.exception.CustomFileException;
import com.epamjwd.task2.factory.GeometricFactory;
import com.epamjwd.task2.parser.impl.CustomParserImpl;
import com.epamjwd.task2.reader.impl.CustomReaderImpl;
import com.epamjwd.task2.service.impl.CalculationCubeServiceImpl;
import com.epamjwd.task2.validator.CubeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String filePath = "/data/parameters.txt";

    public static void main(String[] args) throws CustomFileException {
        CustomReaderImpl reader = new CustomReaderImpl();
        List<String> lines = reader.readAll(filePath);

        List<Cube> cubes = new ArrayList<>();
        for (String line : lines) {
            Optional<List<Double>> cubeParameters = CustomParserImpl.getInstance()
                    .stringToCubeSpecification(line);

            Optional<Cube> cube = Optional.empty();
            if (cubeParameters.isPresent()) {
                cube = GeometricFactory.getInstance()
                        .createCube(cubeParameters.get());
            }

            if (cube.isPresent() && CubeValidator.getInstance().isCube(cube.get())) {
                cubes.add(cube.get());
            }
        }

        CalculationCubeServiceImpl cubeService = new CalculationCubeServiceImpl();
        Point secantPlanePoint = new Point(0.5, 0.5, 5.);
        for (Cube cube : cubes) {
            logger.info("Current cube= " + cube);
            logger.info("Surface area= " + cubeService.surfaceArea(cube));
            logger.info("Volume = " + cubeService.volume(cube));
            logger.info("Volume ratio= " + cubeService.volumeRatio(cube, secantPlanePoint));
        }

        //The work of task`s second part is presented in tests
    }
}