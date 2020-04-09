package com.aokai.parking.controller;

import com.aokai.parking.model.vo.MessageListResp;
import com.aokai.parking.model.vo.TodayOrderResp;
import com.aokai.parking.model.vo.result.Result;
import com.aokai.parking.model.vo.result.SuccessResult;
import com.aokai.parking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 19:08
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 今日车辆信息
     * @return
     */
    @RequestMapping(value = "/getTodayOrderList", method = RequestMethod.POST)
    @ResponseBody
    public Result getTodayOrderList() {
        // 获取今日车辆信息
        TodayOrderResp todayOrderResp = orderService.getTodayOrderList();
        return new SuccessResult<>(todayOrderResp);
    }





}
