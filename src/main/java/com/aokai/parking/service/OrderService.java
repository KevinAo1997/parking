package com.aokai.parking.service;

import com.aokai.parking.model.vo.TodayOrderResp;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 19:09
 */
public interface OrderService {

    /**
     * 获取今日车辆信息
     * @return
     */
    TodayOrderResp getTodayOrderList();
}
