package com.aokai.parking.model.qo.order;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;
import org.omg.CORBA.INTERNAL;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/10 14:02
 */
@Data
@ToString
public class AddCarOrderReq implements Serializable {

    private static final long serialVersionUID = -3578030297656937551L;

    /**
     * 省份
     */
    private String province;

    /**
     * 车牌号
     */
    private String carnumber;

    /**
     * 客户姓名
     */
    private String customername;

    /**
     * 客户号码
     */
    private String customerphone;

    /**
     * 车库ID
     */
    private Integer garageId;

    /**
     * 车位ID
     */
    private Integer carId;

    /**
     * 员工ID
     */
    private Integer userId;
}
