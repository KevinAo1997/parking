package com.aokai.parking.dao;

import com.aokai.parking.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {

    Integer updateUserState(@Param("state")Integer state, @Param("id")Integer id);

    /**
     * 通过账号和密码获取用户信息
     * @param username
     * @param password
     * @return
     */
    User checkUser(@Param("username") String username, @Param("password") String password);
}
