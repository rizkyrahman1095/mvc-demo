package com.project.demomvcspring.util;

public class RandomNum {

    public static long getRandom(long min, long max){
        long number= min + (long) (Math.random()*(max-min));
        return number;
    }
}
