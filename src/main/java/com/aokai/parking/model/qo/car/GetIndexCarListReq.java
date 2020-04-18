package com.aokai.parking.model.qo.car;

import com.aokai.parking.model.qo.PageReq;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/18 19:41
 */
@Data
@ToString
public class GetIndexCarListReq extends PageReq implements Serializable {

    private static final long serialVersionUID = 8421807580639707393L;

    /**
     * 车库名称
     */
    private String garageName;
}
