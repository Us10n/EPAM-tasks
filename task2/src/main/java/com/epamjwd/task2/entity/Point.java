package com.epamjwd.task2.entity;

public class Point {
    private Double x;
    private Double y;
    private Double z;

    public Point(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(Double[] args) {
        this.x = args[0];
        this.y = args[1];
        this.z = args[2];
    }


    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    @Override
    protected Point clone() throws CloneNotSupportedException {
        return new Point(x, y, z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x.equals(point.x) && y.equals(point.y) && z.equals(point.z);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + x.intValue();
        hash = 31 * hash + y.intValue();
        hash = 31 * hash + z.intValue();
        return hash;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
