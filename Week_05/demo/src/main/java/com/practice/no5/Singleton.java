package com.practice.no5;

public enum Singleton {
    INSTANCE;
    private String name;

    public void byEnum(){
        System.out.println("枚举方式实现单例");
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}