package com.aokai.parking.model.qo;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 16:45
 */
@Data
@ToString
public class InsertCarReq implements Serializable {

    private static final long serialVersionUID = -8311486966038823240L;

    /**
     * 车位名称
     */
    private String carName;

    /**
     * 车位位置
     */
    private String carLocation;

    /**
     * 车位类型：小型车和大型车
     */
    private Integer carType;

    /**
     * 价格
     */
    private Double carPrice;

    /**
     * 小时
     */
    private Double carPriceTime;

    /**
     * 车库ID名称
     */
    private Integer garageId;
}
