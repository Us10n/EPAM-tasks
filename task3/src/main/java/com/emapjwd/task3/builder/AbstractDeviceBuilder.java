package com.emapjwd.task3.builder;

import com.emapjwd.task3.entity.AbstractDevice;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractDeviceBuilder{
    protected Set<AbstractDevice> deviceSet;

    public AbstractDeviceBuilder() {
        this.deviceSet = new HashSet<>();
    }

    public Set<AbstractDevice> getDeviceSet() {
        return deviceSet;
    }

    abstract public void buildDeviceSet(String xmlFileName);
}
