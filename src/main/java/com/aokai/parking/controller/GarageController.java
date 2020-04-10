package com.aokai.parking.controller;

import com.aokai.parking.enums.ApplicationEnum;
import com.aokai.parking.model.dto.GarageInfo;
import com.aokai.parking.model.qo.DeleteGarageReq;
import com.aokai.parking.model.qo.InsertGarageReq;
import com.aokai.parking.model.qo.PageReq;
import com.aokai.parking.model.qo.updateGarageReq;
import com.aokai.parking.model.vo.GarageListResp;
import com.aokai.parking.model.vo.result.FailResult;
import com.aokai.parking.model.vo.result.Result;
import com.aokai.parking.model.vo.result.SuccessResult;
import com.aokai.parking.po.User;
import com.aokai.parking.service.GarageService;
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
 * @date : Created in 2020/4/9 15:29
 */
@RestController
@RequestMapping(value = "/garage")
public class GarageController {

    @Autowired
    private GarageService garageService;

    /**
     * 获取车库列表
     * @return
     */
    @RequestMapping(value = "/getGarageList", method = RequestMethod.POST)
    @ResponseBody
    public Result getGarageList(@RequestBody @Validated PageReq pageReq) {
        // 获取车库列表
        List<GarageInfo> garageInfoList = garageService.getGarageList();
        if (CollectionUtils.isEmpty(garageInfoList)) {
            return new SuccessResult<>(null);
        }
        // 分页获取
        Integer pageNum = pageReq.getPageNum() == null ? 1 : pageReq.getPageNum();
        Integer pageSize = pageReq.getPageSize() == null ? 10 : pageReq.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<GarageInfo> garageInfoPageInfo = new PageInfo<>(garageInfoList);
        return new SuccessResult<>(garageInfoPageInfo);
    }


    /**
     * 删除车库
     * @param deleteGarageReq
     * @return
     */
    @RequestMapping(value = "/deleteGarage", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteGarage(@RequestBody @Validated DeleteGarageReq deleteGarageReq) {
        // 删除车库
        Boolean isDelete = garageService.deleteGarage(deleteGarageReq.getGarageId());
        if (isDelete) {
           return new SuccessResult<>();
        }
        return new FailResult<>();
    }

    /**
     * 更新车库信息
     * @param updateGarageReq
     * @return
     */
    @RequestMapping(value = "/updateGarage", method = RequestMethod.POST)
    @ResponseBody
    public Result updateGarage(@RequestBody @Validated updateGarageReq updateGarageReq) {
        // 更新车库信息
        Boolean isUpdate = garageService.updateGarage(updateGarageReq);
        if (isUpdate) {
           return new SuccessResult<>();
        }
        return new FailResult<>();
    }

    /**
     * 新增车库信息
     * @param insertGarageReq
     * @return
     */
    @RequestMapping(value = "/insertGarage", method = RequestMethod.POST)
    @ResponseBody
    public Result insertGarage(@RequestBody @Validated InsertGarageReq insertGarageReq) {
        // 检查车库名是否存在
        Boolean isGarageName = garageService.checkGarageName(insertGarageReq.getGarageName());
        if (isGarageName) {
            return new FailResult<>(ApplicationEnum.NAME_REPETITION);
        }
        // 新增车库信息
        Boolean insertGarage = garageService.insertGarage(insertGarageReq);
        if (insertGarage) {
            new SuccessResult<>();
        }
        return new FailResult<>();
    }



}
