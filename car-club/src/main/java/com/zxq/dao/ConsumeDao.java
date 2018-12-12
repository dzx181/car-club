package com.zxq.dao;

import com.zxq.entity.Consume;
import com.zxq.entity.vo.ConsumeVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
public interface ConsumeDao  {
    /**
     * 添加消费
     * @param consume
     * @return
     */
    int insertConsume(Consume consume);

    /**
     * 删除消费
     * @param consumeIDs
     * @return
     */
    int deleteConsume(List<Integer> consumeIDs);

    /**
     * 修改消费
     * @param consume
     * @return
     */
    int updateConsume(Consume consume);

    /**
     * 查询消费
     * @param consume
     * @return
     */
    List<Consume> selectConsume(Consume consume);

    /**
     * 查询消费id
     * @param consumeID
     * @return
     */
    ConsumeVO selectConsumeByID(Integer consumeID);

}
