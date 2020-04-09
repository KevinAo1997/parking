package com.aokai.parking.service.Impl;

import com.aokai.parking.dao.OrderMapper;
import com.aokai.parking.model.dto.OrderInfo;
import com.aokai.parking.model.vo.TodayOrderResp;
import com.aokai.parking.po.Order;
import com.aokai.parking.service.OrderService;
import com.aokai.parking.utils.BeanUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
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
}
