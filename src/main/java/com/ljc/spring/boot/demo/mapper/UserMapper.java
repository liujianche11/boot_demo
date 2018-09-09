package com.ljc.spring.boot.demo.mapper;

import com.ljc.spring.boot.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserMapper {

    public  User getUser(Long id);

    public void addUser(User user);
//    List<User> getAll();
//
//    void updateUser(User user);
//
//    void deleteUser(Long id);
}
