package com.zxq.service;

import com.zxq.entity.Employ;
import com.zxq.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
public interface EmployService {
    /**
     * 添加员工
     *
     * @param employ
     * @return
     */
    int insertEmploy(Employ employ);

    /**
     * 删除员工
     *
     * @param employIDs
     * @return
     */
    int deleteEmploy(List<Integer> employIDs);

    /**
     * 修改员工
     *
     * @param employ
     * @return
     */
    int updateEmploy(Employ employ);

    /**
     * 查询员工
     *
     * @param employ
     * @return
     */
    String selectEmploy(Integer page, Employ employ, HttpServletRequest request);

    /**
     * 查询员工id
     *
     * @param employID
     * @return
     */
    Employ selectEmployByID(Integer employID);


}
