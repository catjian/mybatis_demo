package com.mybatistest.service.impl;

import com.mybatistest.DAO.Dao;
import com.mybatistest.domain.User;
import com.mybatistest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang_jian on 2017/12/15.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    Dao dao;

    @Override
    public boolean insertNewUserInfo(User user) {
        return dao.insertObject("com.mybatistest.UserMapper.insertUserInfo",user);
    }

    @Override
    public boolean deleteUserInfo(User user) {
        return dao.deleteObject("com.mybatistest.UserMapper.deleteUserInfo",user);
    }

    @Override
    public boolean updataUserInfo(User user) {
        return dao.updataObject("com.mybatistest.UserMapper.updataUserInfo",user);
    }

    @Override
    public User selectUserInfo(User user) {
        return (User) dao.selectObject("com.mybatistest.UserMapper.selectUserByName", user);
    }

    @Override
    public List<User> selectAllUserInfo() {
        return dao.selectAll("com.mybatistest.UserMapper.selectAll");
    }
}
