package com.lp.spring_jpa.jdbc;

import com.lp.spring_jpa.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * jdbc操作db演示
 *
 * @Author lipeng
 * @Date 2023/1/12 9:54
 * @Version 1.0
 */
@Slf4j
public class DemoJdbc {
    private static String username = "root";
    private static String password = "123456";
    private static String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2 创建和数据库之间的连接
        Connection conn = DriverManager.getConnection(url,username,password);
        // 3.准备发送SQL
        String sql = "select * from user";
        PreparedStatement pstm = conn.prepareStatement(sql);
        // 4.执行SQL，接收结果集
        ResultSet rs = pstm.executeQuery();
        // 5 处理结果集
        List list = new ArrayList<User>();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String psw = rs.getString("psw");
            String photo = rs.getString("photo");
            String information = rs.getString("information");
            String school = rs.getString("school");
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setPsw(psw);
            user.setPhoto(photo);
            user.setInformation(information);
            user.setSchool(school);
            list.add(user);
        }
        log.info("user list=>[{}]", list);
        // 6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }


}
