package com.aokai.parking.controller;

import com.aokai.parking.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 20:47
 */
@RestController
@RequestMapping(value = "management")
public class ManagementController {

    @Autowired
    private ManagementService managementService;
//
//    /**
//     * 车辆入库
//     * @param insertGarageReq
//     * @return
//     */
//    @RequestMapping(value = "/carInto", method = RequestMethod.POST)
//    @ResponseBody
//    public Result carInto(@RequestBody @Validated InsertGarageReq insertGarageReq) {
//        // 车辆入库
//        Boolean isCarInto = managementService.checkGarageName(insertGarageReq.getGarageName());
//        if (isCarInto) {
//            return new FailResult<>(ApplicationEnum.NAME_REPETITION);
//        }
//        // 新增车库信息
//        Boolean insertGarage = garageService.insertGarage(insertGarageReq);
//        if (insertGarage) {
//            new SuccessResult<>();
//        }
//        return new FailResult<>();
//    }



}
