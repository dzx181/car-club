package com.zxq.entity.vo;


import com.zxq.entity.Member;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConsumeVO implements Serializable {

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
    private Member member;

    /**
     * 创建时间
     */
    private Date createDate;


    public static final String ID = "id";

    public static final String CONSUME_ANALYES = "consume_analyes";

    public static final String CONSUME_DAY = "consume_day";

    public static final String CONSUME_MONTH = "consume_month";

    public static final String MEMBER_ID = "member_id";

    public static final String CREATE_DATE = "create_date";

}

