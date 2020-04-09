package com.aokai.parking.service.Impl;

import com.aokai.parking.dao.GarageMapper;
import com.aokai.parking.model.dto.GarageInfo;
import com.aokai.parking.model.qo.InsertGarageReq;
import com.aokai.parking.model.qo.updateGarageReq;
import com.aokai.parking.model.vo.GarageListResp;
import com.aokai.parking.po.Garage;
import com.aokai.parking.service.GarageService;
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

    @Override
    public GarageListResp getGarageList() {
        GarageListResp garageListResp = new GarageListResp();
        List<GarageInfo> garageInfoList = new ArrayList<>();
        // 获取车库列表
        List<Garage> garageList = garageMapper.selectAll();
        if (CollectionUtils.isEmpty(garageList)) {
            return null;
        }
        BeanUtils.copyProperties(garageList, garageInfoList);
        garageListResp.setGarageInfoList(garageInfoList);

        return garageListResp;
    }

    @Override
    public Boolean deleteGarage(Integer garageId) {
        // 删除车库
        Integer delete = garageMapper.deleteByPrimaryKey(garageId);
        if (delete > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateGarage(updateGarageReq updateGarageReq) {
        // 更新车库信息
        Garage garage = new Garage();
        BeanUtils.copyProperties(updateGarageReq, garage);
        Integer update = garageMapper.updateByPrimaryKey(garage);
        if (update > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkGarageName(String garageName) {
        // 检查车库名称是否存在
        Garage garage = garageMapper.checkGarageName(garageName);
        if (garage == null) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean insertGarage(InsertGarageReq insertGarageReq) {
        Garage garage = new Garage();
        BeanUtils.copyProperties(insertGarageReq, garage);
        // 新增车库信息
        Integer insert = garageMapper.insert(garage);
        if (insert > 0) {
            return true;
        }
        return false;
    }
}
