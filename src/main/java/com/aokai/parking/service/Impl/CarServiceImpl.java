package com.aokai.parking.service.Impl;

import com.aokai.parking.dao.CarMapper;
import com.aokai.parking.dao.GarageMapper;
import com.aokai.parking.model.qo.car.InsertCarReq;
import com.aokai.parking.model.qo.car.UpdateCarReq;
import com.aokai.parking.po.Car;
import com.aokai.parking.po.Garage;
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

    @Autowired
    private GarageMapper garageMapper;

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
        return car != null;
    }

    @Override
    public Boolean insertCar(InsertCarReq insertCarReq) {
        Car car = new Car();
        BeanUtils.copyProperties(insertCarReq, car);
        car.setCarStatus(1);
        // 新增车位
        Integer insert = carMapper.insert(car);
        // 车库车位总数加1
        Garage garage = garageMapper.selectByPrimaryKey(insertCarReq.getGarageId());
        garage.setGarageTotal(garage.getGarageTotal() + 1);
        garageMapper.updateByPrimaryKeySelective(garage);

        return insert > 0;
    }

    @Override
    public Boolean updateCar(UpdateCarReq updateCarReq) {
        Car car = new Car();
        BeanUtils.copyProperties(updateCarReq, car);
        // 更新车位信息
        Integer updateCar = carMapper.updateByPrimaryKeySelective(car);
        return updateCar > 0;
    }

    @Override
    public Boolean checkCarStatus(Integer carId) {
        // 检查车位是否已占用
        return ! carMapper.checkCarStatus(carId);
    }

    @Override
    public Boolean deleteCar(Integer garageId, Integer carId) {
        // 删除车位信息
        Integer delete = carMapper.deleteCar(carId);

        // 车库车位总数减1
        Garage garage = garageMapper.selectByPrimaryKey(garageId);
        garage.setGarageTotal(garage.getGarageTotal() - 1);
        garageMapper.updateByPrimaryKeySelective(garage);
        return delete > 0;
    }
}
