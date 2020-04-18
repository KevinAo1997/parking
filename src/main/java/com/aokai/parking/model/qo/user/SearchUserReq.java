package com.aokai.parking.model.qo.user;

import com.aokai.parking.model.qo.PageReq;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/10 19:41
 */
@Data
@ToString
public class SearchUserReq extends PageReq implements Serializable {

    private static final long serialVersionUID = -4088646062377032650L;

    /**
     * 工号
     */
    private String code;

    /**
     * 账号
     */
    private String username;


    /**
     * 名称
     */
    private String name;

}
