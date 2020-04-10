package com.aokai.parking.model.qo;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/10 9:57
 */
@Data
@ToString
public class GetCarListReq extends PageReq implements Serializable {

    private static final long serialVersionUID = -7772190167297123216L;

    /**
     * 车库ID
     */
    private Integer garageId;
}
