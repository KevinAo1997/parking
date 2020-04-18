package com.aokai.parking.model.qo.user;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/8 20:00
 */
@Data
@ToString
public class InsertUserReq implements Serializable {

    private static final long serialVersionUID = -6568258585271537507L;

    /**
     * 工号
     */
    @NotBlank
    private String code;

    /**
     * 账号
     */
    @NotBlank
    private String username;


    /**
     * 名称
     */
    @NotBlank
    private String name;

    /**
     * 性别
     */
    @NotBlank
    private String sex;

    /**
     * 邮箱
     */
    @NotBlank
    private String email;

    /**
     * 电话
     */
    @NotBlank
    private String phone;

    /**
     * 签名描述
     */
    private String description;

}
