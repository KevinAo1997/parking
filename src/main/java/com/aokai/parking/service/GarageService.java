package com.aokai.parking.service;

import com.aokai.parking.model.qo.InsertGarageReq;
import com.aokai.parking.model.qo.updateGarageReq;
import com.aokai.parking.model.vo.GarageListResp;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 15:30
 */
public interface GarageService {

    /**
     * 获取车库列表
     * @return
     */
    GarageListResp getGarageList();

    /**
     * 删除车库
     * @param garageId
     * @return
     */
    Boolean deleteGarage(Integer garageId);

    /**
     * 更新车库信息
     * @param updateGarageReq
     * @return
     */
    Boolean updateGarage(updateGarageReq updateGarageReq);

    /**
     * 检查车库名是否存在
     * @param garageName
     * @return
     */
    Boolean checkGarageName(String garageName);

    /**
     * 新增车库信息
     * @param insertGarageReq
     * @return
     */
    Boolean insertGarage(InsertGarageReq insertGarageReq);
}
