package com.practice.no3;

import java.util.List;

public class School {

    private List<FlagClass> flagClasses ;


    public List<FlagClass> getFlagClasses() {
        return flagClasses;
    }

    public void setFlagClasses(List<FlagClass> flagClasses) {
        this.flagClasses = flagClasses;
    }


    @Override
    public String toString() {
        return "School{" +
                "flagClasses=" + flagClasses +
                '}';
    }
}
