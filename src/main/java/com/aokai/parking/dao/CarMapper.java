package com.aokai.parking.dao;

import com.aokai.parking.po.Car;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CarMapper extends Mapper<Car> {

    /**
     * 根据车库ID获取停车位列表
     * @param garageId
     * @return
     */
    List<Car> getCarList(@Param("garageId") Integer garageId);

    /**
     * 检查车位名称是否存在
     * @param carName
     * @param garageId
     * @return
     */
    Car checkCarName(@Param("carName") String carName, @Param("garageId") Integer garageId);

    /**
     * 检查车位是否已占用
     * @param carId
     * @return
     */
    Boolean checkCarStatus(@Param("carId") Integer carId);

    /**
     * 删除车位信息
     * @param carId
     * @return
     */
    Integer deleteCar(@Param("carId") Integer carId);

    /**
     * 车位信息状态更改
     * @param carId
     * @return
     */
    Integer updateStatus(@Param("carId") Integer carId);

    /**
     * 删除车库里的车位
     * @param garageId
     * @return
     */
    Integer deleteCarByGarageId(@Param("garageId") Integer garageId);
}
