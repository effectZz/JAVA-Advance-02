package com.spring.learn.mapper;

import com.spring.learn.model.entity.UserDemo;

import java.util.List;

public interface UserDemoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDemo record);

    int insertSelective(UserDemo record);

    UserDemo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDemo record);

    int updateByPrimaryKey(UserDemo record);


    //手动添加的
    List<UserDemo> getUser();
}