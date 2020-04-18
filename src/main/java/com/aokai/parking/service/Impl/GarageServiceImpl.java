package com.aokai.parking.service.Impl;

import com.aokai.parking.dao.CarMapper;
import com.aokai.parking.dao.GarageMapper;
import com.aokai.parking.model.dto.GarageInfo;
import com.aokai.parking.model.qo.garage.InsertGarageReq;
import com.aokai.parking.model.qo.garage.updateGarageReq;
import com.aokai.parking.model.vo.TotalCarInfoResp;
import com.aokai.parking.po.Car;
import com.aokai.parking.po.Garage;
import com.aokai.parking.service.GarageService;
import com.aokai.parking.utils.BeanUtil;
import com.github.pagehelper.PageInfo;
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
 * @date : Created in 2020/4/9 15:30
 */
@Service
@Slf4j
public class GarageServiceImpl implements GarageService {

    @Autowired
    private GarageMapper garageMapper;

    @Autowired
    private CarMapper carMapper;

    @Override
    public PageInfo<GarageInfo> getGarageList() {
        List<GarageInfo> garageInfoList;
        // 分页获取车库列表
        List<Garage> garageList = garageMapper.selectAll();
        PageInfo<Garage> garagePageInfo = new PageInfo<>(garageList);

        // 复制车库集合
        garageInfoList =  BeanUtil.copyPropertiesByFastJson(garagePageInfo.getList(), GarageInfo.class);

        // 转换成分页
        PageInfo<GarageInfo> garageInfoPageInfo = new PageInfo<>();
        BeanUtils.copyProperties(garagePageInfo, garageInfoPageInfo);
        garageInfoPageInfo.setList(garageInfoList);

        return garageInfoPageInfo;
    }

    @Override
    public Boolean deleteGarage(Integer garageId) {
        // 根据车库ID查询车位信息
        List<Car> carList = carMapper.getCarList(garageId);
        if (! CollectionUtils.isEmpty(carList)) {
            for (Car car : carList) {
                if (car.getCarStatus().equals(0)) {
                    return false;
                }
            }
            // 删除车库里的车位
            Integer deleteCar = carMapper.deleteCarByGarageId(garageId);
        }
        // 删除车库
        Integer delete = garageMapper.deleteByPrimaryKey(garageId);

        return delete > 0 ;
    }

    @Override
    public Boolean updateGarage(updateGarageReq updateGarageReq) {
        // 更新车库信息
        Garage garage = new Garage();
        BeanUtils.copyProperties(updateGarageReq, garage);
        Integer update = garageMapper.updateByPrimaryKeySelective(garage);
        return update > 0;
    }

    @Override
    public Boolean checkGarageName(String garageName) {
        // 检查车库名称是否存在
        Garage garage = garageMapper.checkGarageName(garageName);
        return garage != null;
    }

    @Override
    public Boolean insertGarage(InsertGarageReq insertGarageReq) {
        Garage garage = new Garage();
        BeanUtils.copyProperties(insertGarageReq, garage);
        garage.setGarageTotal(0);
        // 新增车库信息
        Integer insert = garageMapper.insert(garage);
        return insert > 0;
    }

    @Override
    public Garage getGarage(Integer garageId) {
        // 获取具体车库信息
        Garage garage = garageMapper.selectByPrimaryKey(garageId);
        return garage;
    }

    @Override
    public TotalCarInfoResp getTotalCarInfo() {
        TotalCarInfoResp totalCarInfoResp = new TotalCarInfoResp();
        // 获取车库总数量
        Integer garageTotalNum = garageMapper.selectTotal();

        // 获取车位总数量
        Integer carTotalNum = carMapper.selectTotal();

        // 获取已使用的车辆数量
        Integer usingCarNum = carMapper.selectUsingCarTotal();

        // 空闲的车辆数量
        Integer unUsedCarNum = carTotalNum - usingCarNum;

        totalCarInfoResp.setCarTotalNum(carTotalNum);
        totalCarInfoResp.setGarageTotalNum(garageTotalNum);
        totalCarInfoResp.setUnUsedCarNum(unUsedCarNum);
        totalCarInfoResp.setUsingCarNum(usingCarNum);
        return totalCarInfoResp;
    }
}
