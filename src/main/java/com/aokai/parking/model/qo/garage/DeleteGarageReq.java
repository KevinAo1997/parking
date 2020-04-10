package com.aokai.parking.model.qo.garage;

import java.io.Serializable;
import java.net.Inet4Address;
import lombok.Data;
import lombok.ToString;
import org.omg.CORBA.INTERNAL;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/10 16:35
 */
@Data
@ToString
public class DeleteGarageReq implements Serializable {

    private static final long serialVersionUID = 6000666726189673912L;

    /**
     * 车库ID
     */
    private Integer garageId;
}
