package com.aokai.parking.model.qo.garage;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/16 23:07
 */
@Data
@ToString
public class GetGarageReq implements Serializable {

    private static final long serialVersionUID = 2019404088535014733L;

    /**
     * 车库ID
     */
    private Integer garageId;
}
