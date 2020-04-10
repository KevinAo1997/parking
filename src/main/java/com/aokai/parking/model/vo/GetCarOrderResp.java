package com.aokai.parking.model.vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/10 13:51
 */
@Data
@ToString
public class GetCarOrderResp implements Serializable {

    private static final long serialVersionUID = -1196297655172921184L;

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
     * 开始时间
     */
    private Date starttime;
}
