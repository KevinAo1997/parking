package com.aokai.parking.model.vo;

import com.aokai.parking.model.dto.MessageInfo;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 14:07
 */
@Data
@ToString
public class MessageListResp implements Serializable {

    private static final long serialVersionUID = -1638641471593386595L;

    /**
     * 公告列表
     */
    private List<MessageInfo> messageInfoList;
}
