package com.zxq.service;


import com.zxq.entity.Profess;
import com.zxq.entity.vo.ProfessVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
public interface ProfessService {
    /**
     * 添加业务
     * @param profess
     * @return
     */
    int insertProfess(Profess profess);

    /**
     * 删除业务
     * @param professIDs
     * @return
     */
    int deleteProfess(List<Integer> professIDs);

    /**
     * 修改业务
     * @param profess
     * @return
     */
    int updateProfess(Profess profess);

    /**
     * 查询业务
     * @param profess
     * @return
     */
    String selectProfess(Profess profess, Integer page, HttpServletRequest request);

    /**
     * 查询业务id
     * @param professID
     * @return
     */
    ProfessVO selectProfessByID(Integer professID);
}
