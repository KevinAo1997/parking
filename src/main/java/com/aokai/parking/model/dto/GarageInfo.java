package com.aokai.parking.model.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 15:33
 */
@Data
@ToString
public class GarageInfo implements Serializable {

    private static final long serialVersionUID = 386097102178524150L;

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
     * 车位总数
     */
    private Integer garageTotal;

    /**
     * 价格
     */
    private Double garagePrice;

    /**
     * 小时
     */
    private Double garagePricetime;
}
