package com.aokai.parking.controller;

import com.aokai.parking.model.qo.message.InsertMessageReq;
import com.aokai.parking.model.vo.MessageListResp;
import com.aokai.parking.model.vo.result.FailResult;
import com.aokai.parking.model.vo.result.Result;
import com.aokai.parking.model.vo.result.SuccessResult;
import com.aokai.parking.service.MessageService;
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
 * @date : Created in 2020/4/8 23:45
 */
@RestController
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 新增公告
     * @param insertMessageReq
     * @return
     */
    @RequestMapping(value = "/insertMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result insertMessage(@RequestBody @Validated InsertMessageReq insertMessageReq) {
        // 新增公告
        Boolean isInsertMessage = messageService.insertMessage(insertMessageReq);
        if (isInsertMessage) {
            return new SuccessResult<>();
        }
        return new FailResult<>();
    }


    /**
     * 删除公告
     * @param messageId
     * @return
     */
    @RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteMessage(@RequestBody @Validated Integer messageId) {
        // 删除公告
        Boolean isDeleteMessage = messageService.deleteMessage(messageId);
        if (isDeleteMessage) {
            return new SuccessResult<>();
        }
        return new FailResult<>();
    }

    /**
     * 获取公告列表
     * @return
     */
    @RequestMapping(value = "/getMessageList", method = RequestMethod.POST)
    @ResponseBody
    public Result getMessageList() {
        // 获取公告列表
        MessageListResp messageListResp = messageService.getMessageList();
        return new SuccessResult<>(messageListResp);
    }

}
