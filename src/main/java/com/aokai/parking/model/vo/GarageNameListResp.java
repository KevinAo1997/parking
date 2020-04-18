package com.aokai.parking.model.vo;

import com.aokai.parking.model.dto.GarageNameAndIdInfo;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/18 22:49
 */
@Data
@ToString
public class GarageNameListResp implements Serializable {

    private static final long serialVersionUID = -2249666487656787780L;

    /**
     * 车库名称与ID列表
     */
    private List<GarageNameAndIdInfo> garageNameAndIdInfos;
}
