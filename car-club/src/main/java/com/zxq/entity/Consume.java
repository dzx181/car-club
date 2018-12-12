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
public class Consume implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消费分析
     */
    private Integer id;

    /**
     * 消费分析
     */
    private String consumeAnalyes;

    /**
     * 日消费
     */
    private String consumeDay;

    /**
     * 月消费
     */
    private String consumeMonth;

    /**
     * 会员id,关联到会员表
     */
    private Integer memberId;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;


    public static final String ID = "id";

    public static final String CONSUME_ANALYES = "consume_analyes";

    public static final String CONSUME_DAY = "consume_day";

    public static final String CONSUME_MONTH = "consume_month";

    public static final String MEMBER_ID = "member_id";

    public static final String CREATE_DATE = "create_date";

}
