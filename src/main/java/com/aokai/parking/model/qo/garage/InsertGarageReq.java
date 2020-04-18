package com.aokai.parking.model.qo.garage;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 16:17
 */
@Data
@ToString
public class InsertGarageReq implements Serializable {

    private static final long serialVersionUID = 1673713545274830743L;

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

//    /**
//     * 车位总数
//     */
//    private Integer garageTotal;

    /**
     * 价格
     */
    private Double garagePrice;

    /**
     * 小时
     */
    private Double garagePricetime;
}
