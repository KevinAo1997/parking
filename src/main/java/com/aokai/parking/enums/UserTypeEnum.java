package com.aokai.parking.enums;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/8 19:27
 */
@Getter
@AllArgsConstructor
public enum  UserTypeEnum {

    ADMIN("管理员"),
    EMPLOYEE("普通职员");

    private String desc;


    public Serializable getValue() {
        return name();
    }
}
