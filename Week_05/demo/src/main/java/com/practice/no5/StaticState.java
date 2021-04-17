package com.practice.no5;

public class StaticState {

    private static class StaticStateHolder{
        private static final StaticState STATIC_STATE = new StaticState();
    }
    private StaticState(){};

    public static StaticState getStaticState(){
        return StaticStateHolder.STATIC_STATE;
    }
}
