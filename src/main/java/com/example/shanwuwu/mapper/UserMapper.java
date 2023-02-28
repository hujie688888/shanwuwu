package com.example.shanwuwu.mapper;

import com.example.shanwuwu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    List<User> findAll();

    User findUser(String userAccount);

    int register(User user);

    User login(User user);

    int updateUser(User user);
}
