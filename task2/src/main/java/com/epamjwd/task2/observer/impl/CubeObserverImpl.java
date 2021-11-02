package com.epamjwd.task2.observer.impl;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.observer.CubeEvent;
import com.epamjwd.task2.observer.CubeObserver;
import com.epamjwd.task2.service.impl.CalculationCubeServiceImpl;
import com.epamjwd.task2.entity.CubeParameter;
import com.epamjwd.task2.warehouse.Warehouse;

public class CubeObserverImpl implements CubeObserver {
    @Override
    public void parameterChange(CubeEvent event) {
        CalculationCubeServiceImpl cubeService = new CalculationCubeServiceImpl();
        Cube cube = event.getSource();

        double surfaceArea = cubeService.surfaceArea(cube);
        double volume = cubeService.volume(cube);

        Warehouse warehouse = Warehouse.getInstance();
        warehouse.updateParameters(cube.getCubeId(), surfaceArea, volume);
    }
}
