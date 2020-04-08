package com.aokai.parking.service;

import com.aokai.parking.model.qo.InsertUserReq;
import com.aokai.parking.model.qo.UpdateUserReq;
import com.aokai.parking.model.qo.UpdateUserTypeReq;
import com.aokai.parking.model.qo.UserReq;
import com.aokai.parking.po.User;

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
     * @param userID
     * @param status
     * @return
     */
    Boolean updateStatus(Integer userID, Integer status);

    /**
     * 删除用户
     * @param userID
     * @return
     */
    Boolean deleteUser(Integer userID);

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
     * @param userID
     * @param oldPassword
     * @return
     */
    Boolean checkPassword(Integer userID, String oldPassword);

    /**
     * 修改用户密码
     * @param userID
     * @param newPassword
     * @return
     */
    Boolean updatePassword(Integer userID, String newPassword);
}
