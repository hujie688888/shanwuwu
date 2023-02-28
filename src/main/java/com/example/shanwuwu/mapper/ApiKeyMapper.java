package com.example.shanwuwu.mapper;

import com.example.shanwuwu.entity.ApiKeyConfig;
import com.example.shanwuwu.entity.BaseConfig;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ApiKeyMapper {
    String queryApiKey();

}
