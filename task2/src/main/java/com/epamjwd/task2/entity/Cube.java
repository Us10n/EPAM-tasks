package com.epamjwd.task2.entity;

public class Cube extends Shape {
    private Point center;
    private Double edgeLength;

    public Cube() {
    }

    public Cube(Point center, Double edgeLength) {
        this.center = center;
        this.edgeLength = edgeLength;
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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;
        if (center != null ? !center.equals(cube.center) : cube.center != null) return false;
        return edgeLength != null ? edgeLength.equals(cube.edgeLength) : cube.edgeLength == null;
    }

    @Override
    public int hashCode() {
        int result = center != null ? center.hashCode() : 0;
        result = 31 * result + (edgeLength != null ? edgeLength.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cube{");
        sb.append("cubeId=").append(shapeId);
        sb.append(", center=").append(center);
        sb.append(", edgeLength=").append(edgeLength);
        sb.append('}');
        return sb.toString();
    }
}
