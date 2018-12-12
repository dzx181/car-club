package com.zxq.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 1：管理员账户 2会员账户
     */
    private Integer status;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;


    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String STATUS = "status";

    public static final String CREATEDATE = "createDate";

}
