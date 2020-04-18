package com.aokai.parking.service;

import com.aokai.parking.model.qo.user.InsertUserReq;
import com.aokai.parking.model.qo.user.SearchUserReq;
import com.aokai.parking.model.qo.user.UpdateUserReq;
import com.aokai.parking.model.qo.user.UpdateUserTypeReq;
import com.aokai.parking.model.qo.user.UserReq;
import com.aokai.parking.po.User;
import java.util.List;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/3/29 19:19
 */
public interface UserService {

    /**
     * 获取用户账号信息
     * @param userReq
     * @return
     */
    User checkUser(UserReq userReq);

    /**
     * 更改用户权限类型
     * @param updateUserTypeReq
     * @return
     */
    Boolean updateType(UpdateUserTypeReq updateUserTypeReq);

    /**
     * 更改用户状态
     * @param userId
     * @param status
     * @return
     */
    Boolean updateStatus(Integer userId, Integer status);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    Boolean deleteUser(Integer userId);

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    Boolean checkUserName(String username);

    /**
     * 新增用户
     * @param insertUserReq
     * @return
     */
    Boolean insertUser(InsertUserReq insertUserReq);

    /**
     * 编辑用户信息
     * @param updateUserReq
     * @return
     */
    Boolean updateUser(UpdateUserReq updateUserReq);

    /**
     * 检查用户密码
     * @param userId
     * @param oldPassword
     * @return
     */
    Boolean checkPassword(Integer userId, String oldPassword);

    /**
     * 修改用户密码
     * @param userId
     * @param newPassword
     * @return
     */
    Boolean updatePassword(Integer userId, String newPassword);

    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();

    /**
     * 搜索用户
     * @param searchUserReq
     * @return
     */
    List<User> searchUser(SearchUserReq searchUserReq);
}
