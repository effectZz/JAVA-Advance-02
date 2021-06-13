package com.example.demo.no1.mapper;

import com.example.demo.no1.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectUseryById(int id);

    void updateUserById(int id);
}
