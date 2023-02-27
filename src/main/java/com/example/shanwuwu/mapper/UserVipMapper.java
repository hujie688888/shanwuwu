package com.example.shanwuwu.mapper;

import com.example.shanwuwu.entity.User;
import com.example.shanwuwu.entity.UserVip;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserVipMapper {

    UserVip queryVip(String userId);

    int openVip(UserVip userVip);

    int updateVip(UserVip userVip);
}
