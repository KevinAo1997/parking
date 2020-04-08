package com.aokai.parking.dao;

import com.aokai.parking.po.Garage;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface GarageMapper extends Mapper<Garage> {
}
