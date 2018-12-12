package com.zxq.dao;

import com.zxq.entity.User;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
public interface UserDao  {
    int insertUser(User user);

    int deleteUser(List<Integer> userIDs);

    int updateUser(User user);

    List<User> selectUser(User user);

    User selectUserByID(User user);

    List<User> findUsername(User user);

    User selectUserByID(Integer userID);

    User selectUserByNameAndPass(User user);

}
