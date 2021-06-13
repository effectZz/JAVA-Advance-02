package com.example.demo.no1;

import com.example.demo.no1.entity.User;
import com.example.demo.no1.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public void updateUserById(int id){
        userMapper.updateUserById(id);
    };


    public User selectUseryById(int id) {
        return userMapper.selectUseryById(id);
    }
}