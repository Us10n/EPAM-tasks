package com.epamjwd.task2.entity;

public abstract class Shape {
    protected long shapeId;
    protected String name;

    public long getId() {
        return shapeId;
    }

    public void setId(long id) {
        this.shapeId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
