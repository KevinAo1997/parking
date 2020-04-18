package com.aokai.parking.model.qo.message;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/18 18:52
 */
@Data
@ToString
public class DeleteMessageReq implements Serializable {

    private static final long serialVersionUID = -5606294593945078829L;

    /**
     * 公布ID
     */
    private Integer messageId;
}
