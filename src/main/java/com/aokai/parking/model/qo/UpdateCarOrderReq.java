package com.aokai.parking.model.qo;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/10 17:08
 */
@Data
@ToString
public class UpdateCarOrderReq implements Serializable {

    private static final long serialVersionUID = -731250507036143124L;

    /**
     * 省份
     */
    private String province;

    /**
     * 车牌号
     */
    private String carnumber;

}
