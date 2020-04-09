package com.aokai.parking.service.Impl;

import com.aokai.parking.dao.MessageMapper;
import com.aokai.parking.dao.UserMapper;
import com.aokai.parking.model.dto.MessageInfo;
import com.aokai.parking.model.qo.InsertMessageReq;
import com.aokai.parking.model.vo.MessageListResp;
import com.aokai.parking.po.Message;
import com.aokai.parking.po.User;
import com.aokai.parking.service.MessageService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    private UserMapper userMapper;

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

    @Override
    public MessageListResp getMessageList() {
        MessageListResp messageListResp = new MessageListResp();
        // 获取公告信息
        List<Message> messageList = messageMapper.selectAll();
        if (CollectionUtils.isEmpty(messageList)) {
            return null;
        }
        // 获取用户IDS
        List<Integer> userIds = messageList.stream().map(Message::getUserId).collect(Collectors.toList());
        // 根据用户ID获取用户信息
        List<User> userList = userMapper.selectUserByUserIds(userIds);

        List<MessageInfo> messageInfoList = new ArrayList<>();
        // 遍历
        for (Message message : messageList) {
            MessageInfo messageInfo = new MessageInfo();
            BeanUtils.copyProperties(message, messageInfo);

            Optional<User> userOptional = userList.stream().filter(o-> Objects.equals(o.getId(), message.getUserId())).findAny();
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                messageInfo.setName(user.getName());
            }
            messageInfoList.add(messageInfo);
        }
        messageListResp.setMessageInfoList(messageInfoList);
        return messageListResp;
    }
}
