package com.epamjwd.task2.entity;

public class CubeParameter {
    private double surfaceArea;
    private double volume;

    public CubeParameter() {
    }

    public CubeParameter(double surfaceArea, double volume) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeParameter that = (CubeParameter) o;
        return Double.compare(that.surfaceArea, surfaceArea) == 0 && Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = (int) (result * 31 + surfaceArea);
        result = (int) (result * 31 + volume);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder= new StringBuilder("CubeParameter{");
        stringBuilder.append("surfaceArea=").append(surfaceArea);
        stringBuilder.append(", volume=").append(volume);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
