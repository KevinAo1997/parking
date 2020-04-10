package com.aokai.parking.model.qo.message;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.w3c.dom.Text;

/**
 * Description :   .
 *
 * @author : aokai
 * @date : Created in 2020/4/8 23:51
 */
@Data
@ToString
public class InsertMessageReq implements Serializable {

    private static final long serialVersionUID = -7742214179456506008L;

    /**
     * 用户ID
     */
    @NotNull
    private Integer userID;

    /**
     * 标题
     */
    @NotBlank
    private String title;

    /**
     * 内容
     */
    @NotBlank
    private String content;
}
