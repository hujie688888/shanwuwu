package com.example.shanwuwu.service.serviceimp;

import com.example.shanwuwu.entity.User;
import com.example.shanwuwu.mapper.UserMapper;
import com.example.shanwuwu.service.Verification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @projectName: shanwuwu
 * @package: com.example.shanwuwu.service.serviceimp
 * @className: verificationAccount
 * @author: hujie
 * @description: TODO
 * @date: 2023/2/22 17:09
 * @version: 1.0
 */
public class VerificationAccount implements Verification {

    @Autowired
    private UserMapper userMapper;

    /**
     * @param user
     * @return
     */
    @Override
    public String verificationAccount(String userName) {
        if (userName == null) {
            return "验证失败，请输入账号";
        }
        User user = new User();
        user.setUserName("胡杰");
        List<User> restUser= userMapper.findUser(user.getUserName());
        if(restUser == null){
            return "验证失败，请输入账号";
        }
        //根据账号查询数据库，验证账号正确性
        return "验证成功";
    }
}