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
public class Employ implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 员工性别
     */
    private String sex;

    /**
     * 员工电话
     */
    private String telphone;

    /**
     * 员工生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 入职日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryDate;

    /**
     * 基本工资
     */
    private String basicSalary;

    /**
     * 是否全勤
     */
    private String fullWork;

    /**
     * 1表在职，2表离职，3表其他
     */
    private Integer status;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String SEX = "sex";

    public static final String TELPHONE = "telphone";

    public static final String BIRTHDAY = "birthday";

    public static final String ENTRYDATE = "entryDate";

    public static final String BASICSALARY = "basicSalary";

    public static final String FULLWORK = "fullWork";

    public static final String STATUS = "status";

}
