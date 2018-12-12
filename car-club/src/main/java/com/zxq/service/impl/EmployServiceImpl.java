package com.zxq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxq.dao.EmployDao;
import com.zxq.entity.Employ;
import com.zxq.service.EmployService;
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
public class EmployServiceImpl implements EmployService {
    @Autowired
    private EmployDao employDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertEmploy(Employ employ) {
        return employDao.insertEmploy(employ);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteEmploy(List<Integer> employIDs) {
        return employDao.deleteEmploy(employIDs);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateEmploy(Employ employ) {
        return employDao.updateEmploy(employ);
    }

    @Override
    public String selectEmploy( Integer page,Employ employ, HttpServletRequest request) {
        //模糊查询保留值
        if (employ != null) {
                request.setAttribute("blurEmploy", employ);
        }
        if (page == null) {
            page = 0;
        }
        //page为初始页，pageSize表一页显示多少条
        PageHelper.startPage(page, ConstUtil.PAGESIZE);
        List<Employ> list = employDao.selectEmploy(employ);
        PageInfo pageInfo = new PageInfo(list);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("employVOList", list);
        return "employ/employList";
    }

    @Override
    public Employ selectEmployByID(Integer employID) {
        return employDao.selectEmployByID(employID);
    }
}
