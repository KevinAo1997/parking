package com.aokai.parking.model.qo;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/8 22:56
 */
@Data
@ToString
public class UpdateUserReq implements Serializable {

    private static final long serialVersionUID = 2718795532507839272L;

    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 名称
     */
    @NotBlank
    private String name;

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
    @NotBlank
    private String description;
}
