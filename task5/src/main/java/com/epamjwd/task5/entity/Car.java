package com.epamjwd.task5.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Car implements Runnable {
    private static final Logger logger = LogManager.getLogger();

    private CarState state;
    private int weight;
    private int square;

    public Car(int weight, int square, CarState state) {
        this.weight = weight;
        this.square = square;
        this.state = state;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public CarState getState() {
        return state;
    }

    public void setState(CarState state) {
        this.state = state;
    }

    @Override
    public void run() {
        logger.info("Car thread " + Thread.currentThread().getName() + " was run");
        Ferry.getInstance().obtainPlace(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (car.weight != weight) return false;
        return car.square == square;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(weight);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(square);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("weight=").append(weight);
        sb.append(", square=").append(square);
        sb.append(", state=").append(state);
        sb.append('}');
        return sb.toString();
    }
}
