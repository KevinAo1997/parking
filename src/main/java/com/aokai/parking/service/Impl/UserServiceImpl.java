package com.aokai.parking.service.Impl;

import com.aokai.parking.dao.UserMapper;
import com.aokai.parking.model.qo.UserReq;
import com.aokai.parking.po.User;
import com.aokai.parking.service.UserService;
import com.aokai.parking.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/3/29 19:23
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer updateUserState(Integer state, Integer id) {
        return userMapper.updateUserState(state, id);
    }

    @Override
    public User checkUser(UserReq userReq) {
        String username = userReq.getUsername();
        String password = MD5Util.string2MD5(userReq.getPassword());
        // 通过账号和密码获取用户信息
        return userMapper.checkUser(username, password);
    }
}
