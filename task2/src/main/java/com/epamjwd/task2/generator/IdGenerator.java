package com.epamjwd.task2.generator;

public class IdGenerator {
    private static long id = 0;

    private IdGenerator() {
    }

    public static long generateId() {
        return id++;
    }
}
