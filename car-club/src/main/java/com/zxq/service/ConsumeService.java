package com.zxq.service;

import com.zxq.entity.Consume;
import com.zxq.entity.vo.ConsumeVO;

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
public interface ConsumeService  {
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
    String selectConsume(Consume consume, Integer page, HttpServletRequest request);

    /**
     * 查询消费id
     * @param consumeID
     * @return
     */
    ConsumeVO selectConsumeByID(Integer consumeID);
}
