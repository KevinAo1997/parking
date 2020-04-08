package com.aokai.parking.controller;

import com.aokai.parking.enums.ApplicationEnum;
import com.aokai.parking.model.qo.UserReq;
import com.aokai.parking.model.vo.result.FailResult;
import com.aokai.parking.model.vo.result.Result;
import com.aokai.parking.model.vo.result.SuccessResult;
import com.aokai.parking.po.User;
import com.aokai.parking.service.UserService;
import com.aokai.parking.utils.TokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/3/29 19:15
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 用户登录
     * @param userReq
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody @Validated UserReq userReq) {
        // 通过账号密码获取用户信息
        User user = userService.checkUser(userReq);
        if (user == null) {
            return new FailResult<>(ApplicationEnum.USER_OR_PWD_ERR);
        }
        // 生成token
        String token = TokenUtil.sign(user);
        return new SuccessResult<>(token);
    }







    @RequestMapping(value = "/updateUserState", method = RequestMethod.POST)
    public String updateUserState(Integer id, Integer state) {
        Integer flag = userService.updateUserState(state, id);
        System.out.println(flag);
        String msg = null;
        if (flag == 1) {
            msg = "OK";
            return msg;
        } else {
            return msg;
        }
    }

}
