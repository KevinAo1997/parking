package com.aokai.parking.model.qo.user;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/18 14:57
 */
@Data
@ToString
public class UpdateUserStatusReq implements Serializable {

    private static final long serialVersionUID = -5173815933914321296L;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 状态
     */
    private Integer status;
}
