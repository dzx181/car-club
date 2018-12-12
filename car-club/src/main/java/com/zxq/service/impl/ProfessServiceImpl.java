package com.zxq.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxq.dao.ProfessDao;
import com.zxq.entity.Profess;
import com.zxq.entity.vo.ProfessVO;
import com.zxq.service.ProfessService;
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
public class ProfessServiceImpl implements ProfessService {
    @Autowired
    private ProfessDao professDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertProfess(Profess profess) {
        return professDao.insertProfess(profess);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteProfess(List<Integer> professIDs) {
        return professDao.deleteProfess(professIDs);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateProfess(Profess profess) {
        return professDao.updateProfess(profess);
    }

    @Override
    public String selectProfess(Profess profess, Integer page, HttpServletRequest request) {
        //模糊查询保留值
        if (profess != null) { request.setAttribute("blurProfess", profess); }
        if (page == null) {
            page = 0;
        }
        //page为初始页，pageSize表一页显示多少条
        PageHelper.startPage(page, ConstUtil.PAGESIZE);
        List<ProfessVO> list = professDao.selectProfess(profess);
        PageInfo pageInfo = new PageInfo(list);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("professVOList", list);
        return "profess/professList";
    }

    @Override
    public ProfessVO selectProfessByID(Integer professID) {
        return professDao.selectProfessByID(professID);
    }
}
