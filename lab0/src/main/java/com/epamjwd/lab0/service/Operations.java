package com.epamjwd.lab0.service;

import com.epamjwd.lab0.entity.CustomNumber;

import java.util.List;

abstract public class Operations {

    abstract CustomNumber add(List<CustomNumber> nums);
    abstract CustomNumber sub(List<CustomNumber> nums);
    abstract CustomNumber mul(List<CustomNumber> nums);
    abstract CustomNumber div(List<CustomNumber> nums);
}
