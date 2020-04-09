package com.aokai.parking.service.Impl;

import com.aokai.parking.dao.CarMapper;
import com.aokai.parking.model.qo.InsertCarReq;
import com.aokai.parking.model.qo.UpdateCarReq;
import com.aokai.parking.po.Car;
import com.aokai.parking.service.CarService;
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
 * @date : Created in 2020/4/9 16:31
 */
@Slf4j
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> getCarList(Integer garageId) {
         // 根据车库ID获取停车位列表
        List<Car> carList = carMapper.getCarList(garageId);
        if (CollectionUtils.isEmpty(carList)) {
            return null;
        }
        return carList;
    }

    @Override
    public Boolean checkCarName(String carName, Integer garageId) {
        // 检查车位名称是否存在
        Car car = carMapper.checkCarName(carName, garageId);
        if (car == null) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean insertCar(InsertCarReq insertCarReq) {
        Car car = new Car();
        BeanUtils.copyProperties(insertCarReq, car);
        // 新增车位
        Integer insert = carMapper.insert(car);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateCar(UpdateCarReq updateCarReq) {
        Car car = new Car();
        BeanUtils.copyProperties(updateCarReq, car);
        // 更新车位信息
        Integer updateCar = carMapper.updateByPrimaryKey(car);
        if (updateCar > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkCarStatus(Integer carId) {
        // 检查车位是否已占用
        return carMapper.checkCarStatus(carId);
    }

    @Override
    public Boolean deleteCar(Integer carId) {
        // 删除车位信息
        Integer delete = carMapper.deleteCar(carId);
        if (delete > 0) {
            return true;
        }
        return false;
    }
}
