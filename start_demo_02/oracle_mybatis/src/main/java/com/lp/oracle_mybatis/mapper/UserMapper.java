package com.lp.oracle_mybatis.mapper;

import com.lp.oracle_mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 映射Sql，定义接口
 *
 * @Author lipeng
 * @Date 2023/6/5 14:14
 * @Version 1.0
 */
public interface UserMapper {

    /**
     * 根据id查询
     *
     * @param id 唯一主键id    @Param对应参数属性注解
     * @return
     */
    List<User> findById(@Param("id")Integer id);

    /**
     * 根据name查询
     *
     * @param name 用户名
     * @return
     */
    List<User> findByName(@Param("name")String name);

    /**
     * 根据name模糊查询
     *
     * @param name 用户名
     * @return
     */
    List<User> findLikeName(@Param("name")String name);

    /**
     * 分页查询
     *
     * @param start 开始行号
     * @param end   结束行号
     * @return
     */
    List<User> pageList(@Param("start")Integer start, @Param("end")Integer end);

    /**
     * 分页查询
     *
     * @param start 开始行号
     * @param end   结束行号
     * @return
     */
    List<User> pageList2(@Param("start")Integer start, @Param("end")Integer end);

    /**
     * 分页查询
     *
     * @param start 开始行号
     * @param end   结束行号
     * @param name  模糊查询的字段
     * @return
     */
    List<User> pageList3(@Param("start")Integer start, @Param("end")Integer end, @Param("end")String name);

    /**
     * 批量插入
     *
     * @param list 要插入的数据
     */
    void insertUsers(@Param("list")List<User> list);

    /**
     * 批量插入
     *
     * @param user 要插入的数据
     */
    void insertUser(@Param("user")User user);
}
