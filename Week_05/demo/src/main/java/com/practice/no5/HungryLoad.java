package com.practice.no5;

public class HungryLoad {

    private static final HungryLoad HUNGRY_LOAD = new HungryLoad();

    private HungryLoad(){};

    public static HungryLoad getHungryLoad(){
        return HUNGRY_LOAD;
    }
}
