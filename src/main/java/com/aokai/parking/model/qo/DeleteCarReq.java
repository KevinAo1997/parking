package com.aokai.parking.model.qo;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/10 16:30
 */
@Data
@ToString
public class DeleteCarReq implements Serializable {

    private static final long serialVersionUID = -5741503961677114681L;

    /**
     * 车位DI
     */
    private Integer carId;
}
