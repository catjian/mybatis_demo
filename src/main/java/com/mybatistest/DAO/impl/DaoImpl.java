package com.mybatistest.DAO.impl;

import com.mybatistest.DAO.Dao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhang_jian on 2017/12/15.
 */
@Repository("DAO")
public class DaoImpl implements Dao{

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public boolean insertObject(String sqlId, Object data) {
        Integer isSuccess = sqlSessionTemplate.insert(sqlId,data);
        return isSuccess==0?false:true;
    }

    @Override
    public boolean deleteObject(String sqlId, Object data) {
        Integer isSuccess = sqlSessionTemplate.delete(sqlId,data);
        return isSuccess==0?false:true;
    }

    @Override
    public boolean updataObject(String sqlId, Object data) {
        Integer isSuccess = sqlSessionTemplate.update(sqlId,data);
        return isSuccess==0?false:true;
    }

    @Override
    public Object selectObject(String sqlId, Object data) {
        Object selectResp = sqlSessionTemplate.selectOne(sqlId, data);
        return selectResp;
    }

    @Override
    public <T> List<T> selectAll(String sqlId) {
        List<T> seletResp = sqlSessionTemplate.selectList(sqlId);
        return seletResp;
    }
}
