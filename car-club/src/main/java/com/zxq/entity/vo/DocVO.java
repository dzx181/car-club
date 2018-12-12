package com.zxq.entity.vo;


import com.zxq.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

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
public class DocVO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String title;
    private String filename;
    private String remark;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createDate;
    private MultipartFile srcfile;
    private User user;

}
