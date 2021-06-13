package com.example.demo.no4;

import java.util.Arrays;
import java.util.List;

public class No4Test {

    public static void main(String[] args) {

        //放入一个string的缓存
        Cache.put("str-key","value");

        //放入一个集合缓存，并且为10s
        Cache.put("int-key", Arrays.asList(1,2,3,4,6),10000);

        //
        String str = Cache.get("str-key");
        System.out.println(str);

        List list = Cache.get("int-key");
        System.out.println(list);

        //清理
        Cache.remove("str-key");
    }
}
