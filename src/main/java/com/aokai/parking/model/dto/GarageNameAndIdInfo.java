package com.aokai.parking.model.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/18 22:47
 */
@Data
@ToString
public class GarageNameAndIdInfo implements Serializable {

    private static final long serialVersionUID = 8175307757237323202L;

    /**
     * 车库名称
     */
    private String garageName;

    /**
     * 车库ID
     */
    private Integer garageId;
}
