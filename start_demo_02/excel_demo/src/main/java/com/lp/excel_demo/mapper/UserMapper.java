package com.lp.excel_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lp.excel_demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author lipeng
 * @Date 2022/11/3 11:29
 * @Version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User>, BatchInsertMapper<User>{}
