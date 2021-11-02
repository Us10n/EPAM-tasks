package com.epamjwd.task2.repository.impl;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.repository.Specification;

public class IdSpecification implements Specification {
    private final Long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Cube cube) {
        return cube.getCubeId().equals(id);
    }
}
