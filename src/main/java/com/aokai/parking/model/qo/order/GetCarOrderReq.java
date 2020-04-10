package com.aokai.parking.model.qo.order;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/10 19:55
 */
@Data
@ToString
public class GetCarOrderReq implements Serializable {

    private static final long serialVersionUID = 4168827128491568655L;

    /**
     * 车辆ID
     */
    private Integer carId;
}
