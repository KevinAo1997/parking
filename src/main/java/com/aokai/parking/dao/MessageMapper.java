package com.aokai.parking.dao;

import com.aokai.parking.po.Message;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface MessageMapper extends Mapper<Message> {
}
