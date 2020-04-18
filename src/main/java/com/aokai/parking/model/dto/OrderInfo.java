package com.aokai.parking.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 19:55
 */
@Data
@ToString
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = -5055549930539282986L;

    /**
     * 主键
     */
    private Integer id;

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
     * 状态
     */
    private Integer status;

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
