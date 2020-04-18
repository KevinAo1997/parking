package com.aokai.parking.dao;

import com.aokai.parking.po.Order;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OrderMapper extends Mapper<Order> {


    /**
     * 获取当天的车辆订单
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<Order> getTodayOrderList(@Param("startTime")LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime);

    /**
     * 获取当前车位车辆信息
     * @param carId
     * @return
     */
    Order getCarOrder(@Param("carId") Integer carId);

    /**
     * 车辆车库修改订单
     * @param province
     * @param carnumber
     * @param date
     * @return
     */
    Integer updateCarOrder(@Param("province") String province, @Param("carnumber") String carnumber,
            @Param("date") Date date);

    /**
     * 根据车牌号查询订单
     * @param province
     * @param carnumber
     * @return
     */
    Order getOrderByCarNum(@Param("province") String province, @Param("carnumber") String carnumber);

    List<Order> selectOrder();
}
