package com.example.shanwuwu.service;

import com.example.shanwuwu.entity.UserVip;

public interface UserVipService {

    UserVip queryVip(String userId);

    int openVip(UserVip userVip);

    int updateVip(UserVip userVip);
}
