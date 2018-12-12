package com.zxq.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxq.entity.User;
import com.zxq.dao.UserDao;
import com.zxq.service.UserService;
import com.zxq.util.ConstUtil;
import com.zxq.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
@Service
public class UserServiceImpl  implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertUser(User user) {
        if (user == null || user.toString().equals("")) {
            logger.info("User为空");
            return 0;
        } else {
            String saltDB = ConstUtil.MD5_SALT;
            user.setPassword(MD5Util.inputPassToDBpass(user.getPassword(), saltDB));
            return userDao.insertUser(user);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteUser(List<Integer> userIDs) {
        return userDao.deleteUser(userIDs);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public String selectUser(Integer page, User user, HttpServletRequest request) {
        //模糊查询保留值
        if (user != null) {
            if (user.getUsername() != null || user.getStatus() != null)
            {request.setAttribute("blurUser", user);}
        }
        if (page == null) {
            page = 0;
        }
        //page为初始页，pageSize表一页显示多少条
        PageHelper.startPage(page, ConstUtil.PAGESIZE);
        List<User> list = userDao.selectUser(user);
        PageInfo pageInfo = new PageInfo(list);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("userVOList", list);
        return "user/userList";
    }


    @Override
    public List<User> findUsername(User user) {
        if (user == null || user.toString().equals("")) {
            logger.info("User为空");
            return null;
        } else {
            return userDao.findUsername(user);
        }

    }

    @Override
    public boolean isDeleteItself(Integer[] caption, Integer userID) {
        boolean flag = false;
        for (int i = 0; i < caption.length; i++) {
            if (caption[i].equals(userID)) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public User selectUserByID(Integer userID) {
        return userDao.selectUserByID(userID);
    }

    @Override
    public User selectUserByNameAndPass(User user) {
        if (user == null || user.toString().equals("")) {
            logger.info("User为空");
            return null;
        } else {
            String saltDB =  ConstUtil.MD5_SALT;
            user.setPassword(MD5Util.inputPassToDBpass(user.getPassword(), saltDB));
            return userDao.selectUserByNameAndPass(user);
        }
    }

}
