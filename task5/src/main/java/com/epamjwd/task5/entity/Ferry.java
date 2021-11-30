package com.epamjwd.task5.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ferry implements Runnable {
    private static final Logger logger = LogManager.getLogger();
    private static Ferry instance;
    private static AtomicBoolean isCreated = new AtomicBoolean(false);
    private static final Lock lock = new ReentrantLock();

    private static final Integer maxWeight = 5000;
    private static final Integer maxSquare = 4000;
    private AtomicInteger currentSquare = new AtomicInteger(0);
    private AtomicInteger currentWeight = new AtomicInteger(0);

    public static Ferry getInstance() {
        if (!isCreated.get()) {
            try {
                lock.lock();
                if (instance == null) {
                    instance = new Ferry();
                    isCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    @Override
    public void run() {
        shipCars();
    }

    public void obtainPlace(Car car) {
        try {
            lock.lock();
            if (currentSquare.get() + car.getSquare() > maxSquare
                    || currentWeight.get() + car.getWeight() > maxWeight) {
                Thread ferryThread = new Thread(this);
                ferryThread.start();
                ferryThread.join();
            }

            currentWeight.set(currentWeight.get() + car.getWeight());
            currentSquare.set(currentSquare.get() + car.getSquare());
            TimeUnit.SECONDS.sleep(2);
            logger.info("The car " + Thread.currentThread().getName()
                    + " took place on ferry (Current weight=" + currentWeight.get()
                    + ", Current square=" + currentSquare.get() + ")");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void shipCars() {
        try {
            logger.info("Ferry shipping cars");
            TimeUnit.SECONDS.sleep(4);
            currentWeight.set(0);
            currentSquare.set(0);
            logger.info("Ferry finished shipping cars");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
