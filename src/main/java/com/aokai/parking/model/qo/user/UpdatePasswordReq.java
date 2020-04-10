package com.aokai.parking.model.qo.user;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/10 0:04
 */
@Data
@ToString
public class UpdatePasswordReq implements Serializable {

    private static final long serialVersionUID = -7850543084096622016L;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 旧密码
     */
    private String oldPassword;

    /**
     * 新密码
     */
    private String newPassword;
}
