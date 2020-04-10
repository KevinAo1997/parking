package com.aokai.parking.model.qo;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/10 14:50
 */
@Data
@ToString
public class DeleteUserReq implements Serializable {

    private static final long serialVersionUID = 6015489975515610828L;

    /**
     * 用户ID
     */
    private Integer userId;
}
