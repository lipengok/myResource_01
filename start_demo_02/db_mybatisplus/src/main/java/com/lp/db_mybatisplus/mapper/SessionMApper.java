package com.lp.db_mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lp.db_mybatisplus.entity.Seesion;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/29 16:15
 * @Version 1.0
 */
public interface SessionMApper extends BaseMapper<Seesion> {

    List<Seesion> findAll();

    Seesion findById(Integer id);
}
