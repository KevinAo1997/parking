package com.aokai.parking.model.qo;

import com.aokai.parking.enums.UserTypeEnum;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/8 19:26
 */
@Data
@ToString
public class UpdateUserTypeReq implements Serializable {

    private static final long serialVersionUID = -6593039670052818816L;

    /**
     * 用户ID
     */
    @NotNull
    private Integer userId;

    /**
     * 用户类型
     */
    @NotNull
    private UserTypeEnum  userTypeEnum;
}
