package com.aokai.parking.model.qo;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 15:48
 */
@Data
@ToString
public class updateGarageReq implements Serializable {

    private static final long serialVersionUID = 622282519440053523L;

    /**
     * 车库ID
     */
    private Integer id;

    /**
     * 车库名称
     */
    private String garageName;

    /**
     * 车库位置
     */
    private String garageLocation;

    /**
     * 车库描述
     */
    private String garageDescription;

    /**
     * 价格
     */
    private Double garagePrice;

    /**
     * 小时
     */
    private Double garagePricetime;
}
