package com.aokai.parking.model.vo;

import com.aokai.parking.model.dto.GarageInfo;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 15:34
 */
@Data
@ToString
public class GarageListResp implements Serializable {

    private static final long serialVersionUID = -353196969316482039L;

    /**
     * 车库列表信息
     */
    private List<GarageInfo> garageInfoList;
}
