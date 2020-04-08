package com.aokai.parking.service;

import com.aokai.parking.model.qo.UserReq;
import com.aokai.parking.po.User;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/3/29 19:19
 */
public interface UserService {

    Integer updateUserState(Integer state, Integer id);

    /**
     * 获取用户账号信息
     * @param userReq
     * @return
     */
    User checkUser(UserReq userReq);
}
