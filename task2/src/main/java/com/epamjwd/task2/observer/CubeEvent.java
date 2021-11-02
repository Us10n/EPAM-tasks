package com.epamjwd.task2.observer;

import com.epamjwd.task2.entity.Cube;

import java.util.EventObject;

public class CubeEvent extends EventObject {

    public CubeEvent(Object source) {
        super(source);
    }

    @Override
    public Cube getSource() {
        return (Cube)super.getSource();
    }
}
