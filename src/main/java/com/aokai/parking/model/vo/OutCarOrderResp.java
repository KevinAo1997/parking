package com.aokai.parking.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/10 17:19
 */
@Data
@ToString
public class OutCarOrderResp implements Serializable {

    private static final long serialVersionUID = -5933221196847076617L;

    /**
     * 省份
     */
    private String province;

    /**
     * 车牌号
     */
    private String carnumber;

    /**
     * 开始时间
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime starttime;

    /**
     * 结束时间
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime endtime;

    /**
     * 花费
     */
    private Double cost;

    /**
     * 停用时长
     */
    private Double time;

    /**
     * 车库名称
     */
    private String garageName;

    /**
     * 车位名称
     */
    private String carName;

    /**
     * 员工名称
     */
    private String userName;

    /**
     * 员工号码
     */
    private String userCode;

    /**
     * 价格
     */
    private Double carPrice;

    /**
     * 小时
     */
    private Double carPriceTime;

}
