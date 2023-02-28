package com.example.shanwuwu.service.serviceImpl;

import com.example.shanwuwu.entity.BaseConfig;
import com.example.shanwuwu.entity.User;
import com.example.shanwuwu.entity.UserVip;
import com.example.shanwuwu.mapper.ApiKeyMapper;
import com.example.shanwuwu.mapper.ConfigMapper;
import com.example.shanwuwu.mapper.UserMapper;
import com.example.shanwuwu.mapper.UserVipMapper;
import com.example.shanwuwu.service.UserVipService;
import com.example.shanwuwu.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @projectName: shanwuwu
 * @package: com.example.shanwuwu.service.serviceimp
 * @className: UserVipServiceImp
 * @author: hujie
 * @description: TODO
 * @date: 2023/2/27 9:13
 * @version: 1.0
 */
@Service
public class UserVipServiceImpl implements UserVipService {

    @Autowired
    UserVipMapper userVipMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ConfigMapper configMapper;

    @Autowired
    ApiKeyMapper apiKeyMapper;
    /**
     * @param userId
     * @return
     */
    @Override
    public UserVip queryVip(String userId) {
        UserVip userVip = new UserVip();
        if (userId != null) {
            userVip = userVipMapper.queryVip(userId);
        }
        return userVip;
    }

    /**
     * @param userVip
     * @return
     */
    @Override
    public String openVip(UserVip userVip) {
        //开通会员 入参套餐ID，用户ID，会员标识Y
        // 1.修改user 表 会员标识为Y
        // 2.uservip表新一条明细数据

        if (userVip == null) {
            return "请输入参数";
        }
        User user = new User();
        user.setId(userVip.getUserId());
        user.setVipFlag("Y");
        userMapper.updateUser(user);//开通会员

        //查询配置表获取套餐信息
        BaseConfig config = configMapper.queryId(userVip.getConfigId());
        if(config == null){
            return "请配置套餐数据";
        }
        UserVip insertUserVip = new UserVip();
        insertUserVip.setUserId(userVip.getUserId());
        insertUserVip.setConfigId(userVip.getConfigId());
        insertUserVip.setSetMeal(config.getSetMeal());
        insertUserVip.setOriginalPrice(config.getOriginalPrice());
        insertUserVip.setPreferentialPrice(config.getPreferentialPrice());
        insertUserVip.setOpenDate(new Date());
        insertUserVip.setExpiresDate(new DateUtils().computationTime(new Date(),userVip.getSetMeal()));
        int open = userVipMapper.openVip(insertUserVip);
        if (open>0) {
            return "开通成功";
        }
        return "开通失败";
    }

    /**
     * @param userVip
     * @return
     */
    @Override
    public String updateVip(UserVip userVip) {
        return "";
    }

    /**
     * @return
     */
    @Override
    public String queryApiKey() {
        return apiKeyMapper.queryApiKey();
    }


}
