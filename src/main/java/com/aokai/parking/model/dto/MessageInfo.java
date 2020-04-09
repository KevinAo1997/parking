package com.aokai.parking.model.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/9 14:08
 */
@Data
@ToString
public class MessageInfo implements Serializable {

    private static final long serialVersionUID = 7389592566657013305L;

    /**
     * 公告ID
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 创建时间
     */
    private Date creattime;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 内容
     */
    private String content;

    /**
     * 用户名称
     */
    private String name;

}
