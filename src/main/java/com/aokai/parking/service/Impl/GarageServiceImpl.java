package com.aokai.parking.service.Impl;

import com.aokai.parking.dao.CarMapper;
import com.aokai.parking.dao.GarageMapper;
import com.aokai.parking.model.dto.GarageInfo;
import com.aokai.parking.model.qo.garage.InsertGarageReq;
import com.aokai.parking.model.qo.garage.updateGarageReq;
import com.aokai.parking.po.Garage;
import com.aokai.parking.service.GarageService;
import com.aokai.parking.utils.BeanUtil;
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
    public List<GarageInfo> getGarageList() {
        List<GarageInfo> garageInfoList = new ArrayList<>();
        // 获取车库列表
        List<Garage> garageList = garageMapper.selectAll();
        if (CollectionUtils.isEmpty(garageList)) {
            return null;
        }
        garageInfoList = BeanUtil.copyPropertiesByFastJson(garageList, GarageInfo.class);

        return garageInfoList;
    }

    @Override
    public Boolean deleteGarage(Integer garageId) {
        // 删除车库
        Integer delete = garageMapper.deleteByPrimaryKey(garageId);
        // 删除车库里的车位
        Integer deleteCar = carMapper.deleteCarByGarageId(garageId);
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
        // 新增车库信息
        Integer insert = garageMapper.insert(garage);
        return insert > 0;
    }
}
