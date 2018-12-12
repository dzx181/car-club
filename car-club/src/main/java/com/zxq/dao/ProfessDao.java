package com.zxq.dao;

import com.zxq.entity.Profess;
import com.zxq.entity.Profess;
import com.zxq.entity.vo.ProfessVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
public interface ProfessDao {
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
    List<ProfessVO> selectProfess(Profess profess);


    /**
     * 根据id查找业务
     * @return
     */
    ProfessVO selectProfessByID(Integer professID);

}
