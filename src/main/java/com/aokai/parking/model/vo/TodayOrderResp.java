package com.aokai.parking.model.vo;

import com.aokai.parking.model.dto.OrderInfo;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 20:03
 */
@Data
@ToString
public class TodayOrderResp implements Serializable {

    private static final long serialVersionUID = 7335790424038319359L;

    /**
     * 今日业务列表
     */
    private List<OrderInfo> orderInfoList;

    /**
     * 车辆总数
     */
    private Integer carTotalCount;

    /**
     * 今日总营业额
     */
    private Integer costTotal;
}
