package com.aokai.parking.model.qo.car;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 17:23
 */
@Data
@ToString
public class UpdateCarReq implements Serializable {

    private static final long serialVersionUID = -2873872652303338590L;

    /**
     * 车位ID
     */
    private Integer id;

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
    private String carType;

    /**
     * 价格
     */
    private Double c;

    /**
     * 小时
     */
    private Double carPriceTime;

    /**
     * 车库ID名称
     */
    private Integer garageId;
}
