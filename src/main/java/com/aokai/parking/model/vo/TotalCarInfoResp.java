package com.aokai.parking.model.vo;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/18 14:41
 */
@Data
@ToString
public class TotalCarInfoResp implements Serializable {

    private static final long serialVersionUID = -1106108820887514298L;

    /**
     * 车位总数
     */
    private Integer carTotalNum;

    /**
     * 车库总数
     */
    private Integer GarageTotalNum;

    /**
     * 正在使用的车位
     */
    private Integer usingCarNum;

    /**
     * 空闲的车位
     */
    private Integer usedCarNum;
}
