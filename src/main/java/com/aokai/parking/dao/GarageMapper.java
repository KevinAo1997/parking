package com.aokai.parking.dao;

import com.aokai.parking.po.Garage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface GarageMapper extends Mapper<Garage> {

    /**
     * 检查车库名称是否存在
     * @param garageName
     * @return
     */
    Garage checkGarageName(@Param("garageName") String garageName);
}
