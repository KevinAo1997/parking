package com.aokai.parking.service.Impl;

import com.aokai.parking.dao.MessageMapper;
import com.aokai.parking.model.qo.InsertMessageReq;
import com.aokai.parking.po.Message;
import com.aokai.parking.service.MessageService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/8 23:47
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Boolean insertMessage(InsertMessageReq insertMessageReq) {
        Message message = new Message();
        message.setUserId(insertMessageReq.getUserID());
        message.setTitle(insertMessageReq.getTitle());
        message.setContent(insertMessageReq.getContent());
        message.setCreattime(new Date());

        // 新增公告
        Integer insertMessage = messageMapper.insert(message);
        if (insertMessage > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteMessage(Integer messageId) {
        // 删除公告
        Integer isDeleteMessage = messageMapper.deleteByPrimaryKey(messageId);
        if (isDeleteMessage > 0) {
            return true;
        }
        return false;
    }
}
