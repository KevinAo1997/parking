package com.aokai.parking.controller;

import com.aokai.parking.enums.ApplicationEnum;
import com.aokai.parking.model.qo.car.DeleteCarReq;
import com.aokai.parking.model.qo.car.GetCarListReq;
import com.aokai.parking.model.qo.car.InsertCarReq;
import com.aokai.parking.model.qo.car.UpdateCarReq;
import com.aokai.parking.model.vo.result.FailResult;
import com.aokai.parking.model.vo.result.Result;
import com.aokai.parking.model.vo.result.SuccessResult;
import com.aokai.parking.po.Car;
import com.aokai.parking.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 16:30
 */
@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    private CarService carService;



    /**
     * 分页获取停车位列表
     * @param getCarListReq
     * @return
     */
    @RequestMapping(value = "/getCarList", method = RequestMethod.POST)
    @ResponseBody
    public Result getCarList(@RequestBody @Validated GetCarListReq getCarListReq) {
        Integer pageNum = getCarListReq.getPageNum() == null ? 1 : getCarListReq.getPageNum();
        Integer pageSize = getCarListReq.getPageSize() == null ? 10 : getCarListReq.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        // 根据车库ID获取停车位列表
        List<Car> carList = carService.getCarList(getCarListReq.getGarageId());
        if (CollectionUtils.isEmpty(carList)) {
            return new SuccessResult<>(carList);
        }
        // 分页获取
        PageInfo<Car> carPageInfo = new PageInfo<>(carList);
        return new SuccessResult<>(carPageInfo);
    }


    /**
     * 新增车位信息
     * @param insertCarReq
     * @return
     */
    @RequestMapping(value = "/insertCar", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCar(@RequestBody @Validated InsertCarReq insertCarReq) {
        // 检查车位名称是否存在
        Boolean isCarName = carService.checkCarName(insertCarReq.getCarName(),0,insertCarReq.getGarageId());
        if (isCarName) {
            return new FailResult<>(ApplicationEnum.NAME_REPETITION);
        }
        // 新增车位信息
        Boolean insertCar = carService.insertCar(insertCarReq);
        if (insertCar) {
            return new SuccessResult<>();
        }
        return new FailResult<>();
    }

    /**
     * 修改车位信息
     * @param updateCarReq
     * @return
     */
    @RequestMapping(value = "/updateCar", method = RequestMethod.POST)
    @ResponseBody
    public Result updateCar(@RequestBody @Validated UpdateCarReq updateCarReq) {
        // 检查车位名称是否存在
        Boolean isCarName = carService.checkCarName(updateCarReq.getCarName(),updateCarReq.getId(),updateCarReq.getGarageId());
        if (isCarName) {
            return new FailResult<>(ApplicationEnum.NAME_REPETITION);
        }
        // 更新车位信息
        Boolean updateCar = carService.updateCar(updateCarReq);
        if (updateCar) {
           return new SuccessResult<>();
        }
        return new FailResult<>();
    }

    /**
     * 删除车位信息
     * @param deleteCarReq
     * @return
     */
    @RequestMapping(value = "/deleteCar", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteCar(@RequestBody @Validated DeleteCarReq deleteCarReq) {
        // 检查车位是否已占用
        Boolean isCarStatus = carService.checkCarStatus(deleteCarReq.getCarId());
        if (isCarStatus) {
            return new FailResult<>(ApplicationEnum.CAR_SATATUS_USING);
        }
        // 删除车位信息
        Boolean deleteCar = carService.deleteCar(deleteCarReq.getCarId(),deleteCarReq.getGarageId());
        if (deleteCar) {
           return new SuccessResult<>();
        }
        return new FailResult<>();
    }



}
