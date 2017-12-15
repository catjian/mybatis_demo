package com.mybatistest.service;

import com.mybatistest.domain.User;

import java.util.List;

/**
 * Created by zhang_jian on 2017/12/15.
 */
public interface UserService {

    boolean insertNewUserInfo(User user);

    boolean deleteUserInfo(User user);

    boolean updataUserInfo(User user);

    User selectUserInfo(User user);

    List<User> selectAllUserInfo();

}
