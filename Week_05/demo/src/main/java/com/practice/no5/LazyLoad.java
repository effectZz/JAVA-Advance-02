package com.practice.no5;

public class LazyLoad {

    private static LazyLoad lazyLoad;

    private LazyLoad(){}

    public static LazyLoad getLazyLoad(){
        if (null == lazyLoad) {
            synchronized (LazyLoad.class){
                if (null == lazyLoad) {
                    lazyLoad = new LazyLoad();
                }
            }
        }
        return lazyLoad;
    }

}
