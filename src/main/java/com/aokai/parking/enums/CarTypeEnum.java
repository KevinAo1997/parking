package com.aokai.parking.enums;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/10 10:05
 */
@Getter
@AllArgsConstructor
public enum CarTypeEnum {

    SMALL_CAR("小型车"),
    LARGER_CAR("大型车");

    private String desc;


    public Serializable getValue() {
        return name();
    }
}
