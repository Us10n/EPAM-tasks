package com.epamjwd.task2.observer;

public interface CustomObservable {
    void attach(CubeObserver observer);
    void detach(CubeObserver observer);
    void notifyChange();
}
