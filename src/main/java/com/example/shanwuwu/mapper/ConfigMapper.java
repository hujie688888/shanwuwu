package com.example.shanwuwu.mapper;

import com.example.shanwuwu.entity.BaseConfig;
import com.example.shanwuwu.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ConfigMapper {
    List<BaseConfig> queryConfig();

    BaseConfig queryId(String id);

}
