package com.zxq.entity.vo;

import com.zxq.entity.Member;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProfessVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 业务名称
     */
    private String serviceName;

    /**
     * 车辆型号
     */
    private String vehicle;

    /**
     * 创建日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /**
     * 关联到会员id
     */
    private Member member;

    /**
     * 投保的种类
     */
    private String insuranceType;


    public static final String ID = "id";

    public static final String SERVICE_NAME = "service_name";

    public static final String VEHICLE = "vehicle";

    public static final String CREATE_DATE = "create_date";

    public static final String COURSETIME = "courseTime";

    public static final String MEMBER_ID = "member_id";

    public static final String INSURANCE_TYPE = "insurance_type";

}
