package com.aokai.parking.service.Impl;

import com.aokai.parking.dao.CarMapper;
import com.aokai.parking.dao.GarageMapper;
import com.aokai.parking.dao.OrderMapper;
import com.aokai.parking.dao.UserMapper;
import com.aokai.parking.model.dto.OrderInfo;
import com.aokai.parking.model.qo.order.AddCarOrderReq;
import com.aokai.parking.model.qo.order.SearchCarOrderReq;
import com.aokai.parking.model.qo.order.UpdateCarOrderReq;
import com.aokai.parking.model.vo.GetCarOrderResp;
import com.aokai.parking.model.vo.OutCarOrderResp;
import com.aokai.parking.model.vo.SearchCarOrderResp;
import com.aokai.parking.model.vo.TodayOrderResp;
import com.aokai.parking.po.Car;
import com.aokai.parking.po.Garage;
import com.aokai.parking.po.Order;
import com.aokai.parking.po.User;
import com.aokai.parking.service.OrderService;
import com.aokai.parking.utils.BeanUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GarageMapper garageMapper;

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
        order.setStarttime(LocalDateTime.now());
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

    @Override
    public OutCarOrderResp updateCarOrder(UpdateCarOrderReq updateCarOrderReq) {
        OutCarOrderResp outCarOrderResp = new OutCarOrderResp();

        String province = updateCarOrderReq.getProvince();
        String carnumber = updateCarOrderReq.getCarnumber();

        // 查询订单
        Order order = orderMapper.getOrderByCarNum(province, carnumber);
        if (order == null) {
            return null;
        }
        // 获取用户信息
        User user = userMapper.selectByPrimaryKey(order.getUserId());
        if (user != null) {
            outCarOrderResp.setUserCode(user.getCode());
            outCarOrderResp.setUserName(user.getName());
        }
        // 获取车位信息
        Car car = carMapper.selectByPrimaryKey(order.getCarId());
        if (car != null) {
            outCarOrderResp.setCarName(car.getCarName());
            outCarOrderResp.setCarPrice(car.getCarPrice());
            outCarOrderResp.setCarPriceTime(car.getCarPriceTime());
        }
        // 获取车库信息
        Garage garage = garageMapper.selectByPrimaryKey(order.getGarageId());
        if (garage != null) {
            outCarOrderResp.setGarageName(garage.getGarageName());
        }
        // 更新车位信息
        Car car1 = new Car();
        car1.setId(car.getId());
        car1.setCarStatus(1);
        Integer updateCar = carMapper.updateByPrimaryKeySelective(car1);

        // 当前时间
        LocalDateTime localDateTime = LocalDateTime.now();
        // 计算停车时间
        long time =ChronoUnit.HOURS
                .between(order.getStarttime(), localDateTime);
        // 计算花费
        Double cost = time*car.getCarPrice();
        // 车辆车库修改订单
        Order newOrder = new Order();
        newOrder.setStatus(1);
        newOrder.setTime((double) time);
        newOrder.setCost(cost);
        newOrder.setId(order.getId());
        newOrder.setEndtime(localDateTime);
        Integer updateOrder = orderMapper.updateByPrimaryKeySelective(newOrder);

        outCarOrderResp.setCost(cost);
        outCarOrderResp.setTime((double) time);
        outCarOrderResp.setProvince(updateCarOrderReq.getProvince());
        outCarOrderResp.setCarnumber(updateCarOrderReq.getCarnumber());
        outCarOrderResp.setEndtime(localDateTime);
        outCarOrderResp.setStarttime(order.getStarttime());

        if (updateCar > 0 && updateOrder > 0) {
            return outCarOrderResp;
        }
        return null;
    }

    @Override
    public SearchCarOrderResp searchCarOrder(SearchCarOrderReq searchCarOrderReq) {
        SearchCarOrderResp searchCarOrderResp = new SearchCarOrderResp();

        String province = searchCarOrderReq.getProvince();
        String carnumber = searchCarOrderReq.getCarnumber();

        // 查询订单
        Order order = orderMapper.getOrderByCarNum(province, carnumber);
        if (order == null) {
            return null;
        }
        searchCarOrderResp.setCustomername(order.getCustomername());
        searchCarOrderResp.setCustomerphone(order.getCustomerphone());
        searchCarOrderResp.setProvince(province);
        searchCarOrderResp.setCarnumber(carnumber);
        // 获取车位信息
        Car car = carMapper.selectByPrimaryKey(order.getCarId());
        if (car != null) {
            searchCarOrderResp.setCarName(car.getCarName());
        }
        // 获取车库信息
        Garage garage = garageMapper.selectByPrimaryKey(order.getGarageId());
        if (garage != null) {
            searchCarOrderResp.setGarageName(garage.getGarageName());
        }
        return searchCarOrderResp;
    }
}
