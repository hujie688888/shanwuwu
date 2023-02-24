package com.example.shanwuwu.service;

import com.example.shanwuwu.entity.User;
import com.example.shanwuwu.mapper.UserMapper;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public interface Verification {
     String verificationAccount(String userName);

}
