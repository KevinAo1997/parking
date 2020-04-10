package com.aokai.parking.service.Impl;

import com.aokai.parking.dao.CarMapper;
import com.aokai.parking.dao.OrderMapper;
import com.aokai.parking.model.dto.OrderInfo;
import com.aokai.parking.model.qo.AddCarOrderReq;
import com.aokai.parking.model.vo.GetCarOrderResp;
import com.aokai.parking.model.vo.TodayOrderResp;
import com.aokai.parking.po.Order;
import com.aokai.parking.service.OrderService;
import com.aokai.parking.utils.BeanUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 19:09
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CarMapper carMapper;

    @Override
    public TodayOrderResp getTodayOrderList() {
        TodayOrderResp todayOrderResp = new TodayOrderResp();
        List<OrderInfo> orderInfoList = new ArrayList<>();

        // 当天开始
        LocalDateTime startTime = LocalDateTime.now().with(LocalDate.MIN);
        // 当天的最后一刻
        LocalDateTime endTime = LocalDateTime.now().with(LocalDate.MAX);
        // 获取当天的车辆订单
        List<Order> orderList = orderMapper.getTodayOrderList(startTime, endTime);
        if (CollectionUtils.isEmpty(orderList)) {
            return null;
        }
        Integer carTotalCount = orderList.size();
        orderInfoList = BeanUtil.copyPropertiesByFastJson(orderList, OrderInfo.class);
        todayOrderResp.setOrderInfoList(orderInfoList);
        todayOrderResp.setCarTotalCount(carTotalCount);

        return todayOrderResp;
    }

    @Override
    public GetCarOrderResp getCarOrder(Integer carId) {
        GetCarOrderResp getCarOrderResp = new GetCarOrderResp();
        // 获取当前车位车辆信息
        Order order = orderMapper.getCarOrder(carId);
        if (order == null) {
            return null;
        }
        BeanUtils.copyProperties(order, getCarOrderResp);
        return getCarOrderResp;
    }

    @Override
    public Boolean addCarOrder(AddCarOrderReq addCarOrderReq) {
        Order order = new Order();
        BeanUtils.copyProperties(addCarOrderReq, order);
        order.setStarttime(new Date());
        order.setStatus(0);
        // 车辆入库新增订单
        Integer addCarorder = orderMapper.insert(order);
        // 车位信息状态更改
        Integer updateCarStatus = carMapper.updateStatus(addCarOrderReq.getCarId());
        if (addCarorder > 0 && updateCarStatus > 0) {
            return true;
        }
        return false;
    }
}
