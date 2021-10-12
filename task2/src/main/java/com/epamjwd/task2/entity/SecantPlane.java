package com.epamjwd.task2.entity;

public class SecantPlane {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public SecantPlane(Point a, Point b, Point c) {
        this.pointA = a;
        this.pointB = b;
        this.pointC = c;
    }

    public SecantPlane(Point[] points) {
        this.pointA = points[0];
        this.pointB = points[1];
        this.pointC = points[2];
    }

    public Point getA() {
        return pointA;
    }

    public void setA(Point a) {
        this.pointA = a;
    }

    public Point getB() {
        return pointB;
    }

    public void setB(Point b) {
        this.pointB = b;
    }

    public Point getC() {
        return pointC;
    }

    public void setC(Point c) {
        this.pointC = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecantPlane that = (SecantPlane) o;

        if (pointA != null ? !pointA.equals(that.pointA) : that.pointA != null) return false;
        if (pointB != null ? !pointB.equals(that.pointB) : that.pointB != null) return false;
        if (pointC != null ? !pointC.equals(that.pointC) : that.pointC != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;

        hash = 31 * hash + ((pointA == null) ? 0 : pointA.hashCode());
        hash = 31 * hash + ((pointB == null) ? 0 : pointB.hashCode());
        hash = 31 * hash + ((pointC == null) ? 0 : pointC.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        return "SecantPlane{" +
                "a=" + pointA +
                ", b=" + pointB +
                ", c=" + pointC +
                '}';
    }
}
