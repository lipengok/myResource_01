package com.lp.excel_demo.mapper;

import java.util.List;

/**
 * 批量插入的Mapper, 用xml配置文件自定义批量插入，
 * 避免MyBatis的逐条插入降低性能
 *
 * @param <T>
 * @Author lipeng
 * @Date 2023/2/1 13:46
 * @Version 1.0
 */
public interface BatchInsertMapper<T> {

    void batchInsert(List<T> list);
}
