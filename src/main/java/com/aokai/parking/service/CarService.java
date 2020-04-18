package com.aokai.parking.service;

import com.aokai.parking.model.qo.car.InsertCarReq;
import com.aokai.parking.model.qo.car.UpdateCarReq;
import com.aokai.parking.po.Car;
import java.util.List;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 16:31
 */
public interface CarService {

    /**
     * 根据车库ID获取停车位列表
     * @param garageId
     * @return
     */
    List<Car> getCarList(Integer garageId);

    /**
     * 检查车位名称是否存在
     * @param carName
     * @param garageId
     * @return
     */
    Boolean checkCarName(String carName, Integer garageId);

    /**
     * 新增车位
     * @param insertCarReq
     * @return
     */
    Boolean insertCar(InsertCarReq insertCarReq);

    /**
     * 更新车位信息
     * @param updateCarReq
     * @return
     */
    Boolean updateCar(UpdateCarReq updateCarReq);

    /**
     * 检查车位是否已占用
     * @param carId
     * @return
     */
    Boolean checkCarStatus(Integer carId);

    /**
     * 删除车位信息
     *
     * @param garageId
     * @param carId
     * @return
     */
    Boolean deleteCar(Integer garageId, Integer carId);
}
