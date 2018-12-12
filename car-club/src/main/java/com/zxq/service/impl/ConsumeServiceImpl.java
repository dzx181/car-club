package com.zxq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxq.entity.Consume;
import com.zxq.dao.ConsumeDao;
import com.zxq.entity.vo.ConsumeVO;
import com.zxq.service.ConsumeService;
import com.zxq.util.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
@Service
public class ConsumeServiceImpl  implements ConsumeService {
    @Autowired
    private ConsumeDao consumeDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertConsume(Consume consume) {
        return consumeDao.insertConsume(consume);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteConsume(List<Integer> consumeIDs) {
        return consumeDao.deleteConsume(consumeIDs);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateConsume(Consume consume) {
        return consumeDao.updateConsume(consume);
    }

    @Override
    public String selectConsume(Consume consume, Integer page, HttpServletRequest request) {
        //模糊查询保留值
        if (consume != null) {
            if (consume.getMemberId() != null) {
                request.setAttribute("blurConsume", consume);
            }
        }
        if (page == null) {
            page = 0;
        }
        //page为初始页，pageSize表一页显示多少条
        PageHelper.startPage(page, ConstUtil.PAGESIZE);
        List<Consume> list = consumeDao.selectConsume(consume);
        PageInfo pageInfo = new PageInfo(list);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("consumeVOList", list);
        return "consume/consumeList";
    }

    @Override
    public ConsumeVO selectConsumeByID(Integer consumeID) {
        return consumeDao.selectConsumeByID(consumeID);
    }
}
