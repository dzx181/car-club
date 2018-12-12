package com.zxq.dao;

import com.zxq.entity.Employ;


import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
public interface EmployDao {
    /**
     * 添加员工
     * @param employ
     * @return
     */
    int insertEmploy(Employ employ);

    /**
     * 删除员工
     * @param employIDs
     * @return
     */
    int deleteEmploy(List<Integer> employIDs);

    /**
     * 修改员工
     * @param employ
     * @return
     */
    int updateEmploy(Employ employ);

    /**
     * 查询员工
     * @param employ
     * @return
     */
    List<Employ> selectEmploy(Employ employ);

    /**
     * 查询员工id
     * @param employID
     * @return
     */
    Employ selectEmployByID(Integer employID);


}
