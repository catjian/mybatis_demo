package com.mybatistest.DAO;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhang_jian on 2017/12/15.
 */
public interface Dao {

    boolean insertObject(String sqlId, Object data);
    boolean deleteObject(String sqlId, Object data);
    boolean updataObject(String sqlId, Object data);
    Object selectObject(String sqlId, Object data);
    <T> List<T> selectAll(String sqlId);
}
