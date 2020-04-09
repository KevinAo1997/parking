package com.aokai.parking.service;

import com.aokai.parking.model.qo.InsertMessageReq;
import com.aokai.parking.model.vo.MessageListResp;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/8 23:47
 */
public interface MessageService {

    /**
     * 新增公告
     * @param insertMessageReq
     * @return
     */
    Boolean insertMessage(InsertMessageReq insertMessageReq);

    /**
     * 删除公告
     * @param messageId
     * @return
     */
    Boolean deleteMessage(Integer messageId);

    /**
     * 获取公告列表
     * @return
     */
    MessageListResp getMessageList();
}
