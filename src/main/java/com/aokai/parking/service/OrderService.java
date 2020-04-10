package com.aokai.parking.service;

import com.aokai.parking.model.qo.AddCarOrderReq;
import com.aokai.parking.model.vo.GetCarOrderResp;
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

    /**
     * 获取当前车位车辆信息
     * @param carId
     * @return
     */
    GetCarOrderResp getCarOrder(Integer carId);

    /**
     * 车辆入库新增订单
     * @param addCarOrderReq
     * @return
     */
    Boolean addCarOrder(AddCarOrderReq addCarOrderReq);
}
