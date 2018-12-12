package com.zxq.service;

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
public interface UserService  {
    int insertUser(User userPO);

    int deleteUser(List<Integer> userIDs);

    int updateUser(User userPO);

    String selectUser(Integer page, User userPO, HttpServletRequest request);

    List<User> findUsername(User user);

    boolean isDeleteItself(Integer[] caption, Integer userID);

    User selectUserByID(Integer userID);

    User selectUserByNameAndPass(User user);
}
