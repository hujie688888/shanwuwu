package com.example.shanwuwu.mapper;

import com.example.shanwuwu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();

    List<User> findUser(String userName);
}
