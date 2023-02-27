package com.example.shanwuwu.service.serviceImpl;


import com.example.shanwuwu.entity.BaseConfig;
import com.example.shanwuwu.mapper.ConfigMapper;
import com.example.shanwuwu.mapper.UserVipMapper;
import com.example.shanwuwu.service.BaseConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: shanwuwu
 * @package: com.example.shanwuwu.service.serviceImpl
 * @className: BaseConfigServiceImpl
 * @author: hujie
 * @description: TODO
 * @date: 2023/2/27 11:51
 * @version: 1.0
 */
@Service
public class BaseConfigServiceImpl implements BaseConfigService {

    @Autowired
    ConfigMapper configMapper;
    /**
     * @return
     */
    @Override
    public List<BaseConfig> queryConfig() {
        List<BaseConfig> configList = configMapper.queryConfig();
        return configList;
    }
}
