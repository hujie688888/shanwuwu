package com.example.shanwuwu.service;

import com.example.shanwuwu.entity.UserVip;

public interface UserVipService {

    UserVip queryVip(String userId);

    String openVip(UserVip userVip);

    String updateVip(UserVip userVip);
}
