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
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 会员姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号码
     */
    private String telphone;

    /**
     * 微信
     */
    private String weChatID;

    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 重要程度：1代表重点，2代表优质，3一般，4放弃，5未知
     */
    private Integer importanceGrade;

    /**
     * 入教会费
     */
    private String pay;

    /**
     * 是否续费
     */
    private String ifContinu;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String SEX = "sex";

    public static final String TELPHONE = "telphone";

    public static final String WECHATID = "weChatID";

    public static final String BIRTHDAY = "birthday";

    public static final String IMPORTANCEGRADE = "importanceGrade";

    public static final String PAY = "pay";

    public static final String IFCONTINU = "ifContinu";

}
