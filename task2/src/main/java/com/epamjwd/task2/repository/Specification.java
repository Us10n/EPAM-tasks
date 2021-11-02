package com.epamjwd.task2.repository;

import com.epamjwd.task2.entity.Cube;

public interface Specification {
    boolean specify(Cube cube);
}
