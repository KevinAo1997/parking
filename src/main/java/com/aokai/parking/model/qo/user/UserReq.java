package com.aokai.parking.model.qo.user;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/6 10:23
 */
@Data
@ToString
public class UserReq implements Serializable {

    private static final long serialVersionUID = -767466085068449365L;

    /**
     * 用户名账号
     */
    @NotBlank
    private String username;

    /**
     * 用户密码
     */
    @NotBlank
    private String password;

}
