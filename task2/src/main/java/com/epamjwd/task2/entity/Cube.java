package com.epamjwd.task2.entity;

import com.epamjwd.task2.generator.IdGenerator;
import com.epamjwd.task2.observer.CubeEvent;
import com.epamjwd.task2.observer.CubeObserver;
import com.epamjwd.task2.observer.CustomObservable;

import java.util.ArrayList;
import java.util.List;

public class Cube implements CustomObservable {
    private Long cubeId;
    private Point center;
    private Double edgeLength;

    private final List<CubeObserver> observerList = new ArrayList<>();

    public Cube(Point center, Double edgeLength) {
        this.cubeId = IdGenerator.generateId();
        this.center = center;
        this.edgeLength = edgeLength;
    }

    public Long getCubeId() {
        return cubeId;
    }

    public void setCubeId(Long cubeId) {
        this.cubeId = cubeId;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Double getEdgeLength() {
        return edgeLength;
    }

    public void setEdgeLength(Double edgeLength) {
        this.edgeLength = edgeLength;
        notifyChange();
    }

    @Override
    public void attach(CubeObserver observer) {
        if (observer != null) {
            observerList.add(observer);
        }
    }

    @Override
    public void detach(CubeObserver observer) {
        observerList.remove(observer);
    }

    @Override
    protected Cube clone() throws CloneNotSupportedException {
        Point center = this.center.clone();
        Cube cloneCub = new Cube(center, this.edgeLength);
        return cloneCub;
    }

    @Override
    public void notifyChange() {
        if (!observerList.isEmpty()) {
            CubeEvent event = new CubeEvent(this);
            observerList.forEach(o -> o.parameterChange(event));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube that = (Cube) o;

        if (cubeId != null ? !cubeId.equals(that.cubeId) : that.cubeId != null) return false;
        if (center != null ? !center.equals(that.center) : that.center != null) return false;
        return edgeLength != null ? edgeLength.equals(that.edgeLength) : that.edgeLength == null;
    }

    @Override
    public int hashCode() {
        int result = cubeId != null ? cubeId.hashCode() : 0;
        result = 31 * result + (center != null ? center.hashCode() : 0);
        result = 31 * result + (edgeLength != null ? edgeLength.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Cube{");
        stringBuilder.append("cubeId=").append(cubeId);
        stringBuilder.append(", center=").append(center);
        stringBuilder.append(", edgeLength=").append(edgeLength);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }


}
