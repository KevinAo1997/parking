package com.aokai.parking.service.Impl;

import com.aokai.parking.dao.UserMapper;
import com.aokai.parking.enums.UserTypeEnum;
import com.aokai.parking.model.qo.InsertUserReq;
import com.aokai.parking.model.qo.UpdateUserReq;
import com.aokai.parking.model.qo.UpdateUserTypeReq;
import com.aokai.parking.model.qo.UserReq;
import com.aokai.parking.po.User;
import com.aokai.parking.service.UserService;
import com.aokai.parking.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public User checkUser(UserReq userReq) {
        String username = userReq.getUsername();
        String password = MD5Util.string2MD5(userReq.getPassword());
        // 通过账号和密码获取用户信息
        return userMapper.checkUser(username, password);
    }

    @Override
    public Boolean updateType(UpdateUserTypeReq updateUserTypeReq) {
        String userType = updateUserTypeReq.getUserTypeEnum().name();
        Integer userId = updateUserTypeReq.getUserId();

        // 更改用户权限类型
        Integer update = userMapper.updateType(userType, userId);
        if (update > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateStatus(Integer userID, Integer status) {
        // 更改用户状态
        Integer update = userMapper.updateStatus(userID, status);
        if (update > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUser(Integer userID) {
        // 删除用户
        Integer delete = userMapper.deleteUser(userID);
        if (delete > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkUserName(String username) {
        // 判断用户名是否存在
        User user = userMapper.checkUserName(username);
        if (user == null) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean insertUser(InsertUserReq insertUserReq) {
        User user = new User();
        user.setCode(insertUserReq.getCode());
        user.setDescription(insertUserReq.getDescription());
        user.setEmail(insertUserReq.getEmail());
        user.setName(insertUserReq.getName());
        user.setPhone(insertUserReq.getPhone());
        user.setSex(insertUserReq.getSex());
        user.setUsername(insertUserReq.getUsername());
        user.setPassword(MD5Util.string2MD5(insertUserReq.getUsername()));
        user.setStatus(1);
        user.setType(UserTypeEnum.EMPLOYEE.name());

        // 新增用户
        Integer insertUer = userMapper.insert(user);
        if (insertUer > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateUser(UpdateUserReq updateUserReq) {
        User user = new User();
        user.setId(updateUserReq.getId());
        user.setName(updateUserReq.getName());
        user.setEmail(updateUserReq.getEmail());
        user.setDescription(updateUserReq.getDescription());
        user.setPhone(updateUserReq.getPhone());

        Integer updateUser = userMapper.updateByPrimaryKey(user);
        if (updateUser > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkPassword(Integer userID, String oldPassword) {
        // 查询用户密码
        String userPassword = userMapper.checkPassword(userID);
        if (userPassword == null || !userPassword.equals(MD5Util.string2MD5(oldPassword))) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean updatePassword(Integer userID, String newPassword) {
        // 修改用户密码
        Integer updatePassword = userMapper.updatePassword(userID, newPassword);
        if (updatePassword > 0) {
            return true;
        }
        return false;
    }
}
