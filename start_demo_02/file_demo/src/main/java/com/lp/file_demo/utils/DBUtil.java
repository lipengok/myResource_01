package com.lp.file_demo.utils;

import com.lp.file_demo.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lipeng
 * @Date 2022/7/8 16:14
 * @Version 1.0
 */
public class DBUtil {
    private static String DriverName = "com.mysql.jdbc.Driver";
    private static String Url="jdbc:mysql://localhost:3306/test";
    private static String UserName = "root";
    private static String PassWord = "123456";
    private static Connection Con;
    public static Student[] Students = null;
    //查询条件
    public static Student QueryCon = null;
    //从数据库读取到的数据
    public static List<Map<String,Object>> DataList = null;

    //获取数据库连接
    public static Connection getConnection(){
        try {
            Class.forName(DriverName);
            try {
                Con = DriverManager.getConnection(Url,UserName,PassWord);
                Con.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Con;
    }

    //设置查询条件
    public static void setQueryCondition(){
        QueryCon = new Student();
        QueryCon.setStuGrade("小一");
    }

    //根据查询条件查询符合条件的记录
    public static void queryDbData(){
        DataList = new ArrayList<Map<String,Object>>();
        StringBuffer sqlStr = new StringBuffer("select stuNo,name,sex,age,stuGrade,stuClass,score1,score2,score3,score,level from Student where 1=1");
        if(QueryCon.getStuGrade()!=null && !"".equals(QueryCon.getStuGrade()))
            sqlStr.append(" and stuGrade='"+QueryCon.getStuGrade()+"'");
        Statement sta=null;
        try {
            sta = Con.createStatement();
            ResultSet tmpResult = sta.executeQuery(sqlStr.toString());
            while(tmpResult.next()){
                Map<String,Object> rowMap = new HashMap<String,Object>();
                rowMap.put("stuNo", tmpResult.getString(1));
                rowMap.put("name", tmpResult.getString(2));
                rowMap.put("sex", tmpResult.getString(3));
                rowMap.put("age", tmpResult.getInt(4));
                rowMap.put("stuGrade", tmpResult.getString(5));
                rowMap.put("stuClass", tmpResult.getString(6));
                rowMap.put("score1", tmpResult.getDouble(7));
                rowMap.put("score2", tmpResult.getDouble(8));
                rowMap.put("score3", tmpResult.getDouble(9));
                rowMap.put("score", tmpResult.getDouble(10));
                rowMap.put("level", tmpResult.getInt(11));
                DataList.add(rowMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(DataList.size()<1)
            DataList=null;
    }

    //Map转化为实体
    public static void convertMap2Entity(List<Map<String,Object>> list){
        if(list!=null && list.size()>0){
            Students = new Student[list.size()];
            for(int i=0;i<list.size();i++){
                Map<String,Object> tmpMap=list.get(i);
                Students[i] = new Student();
                if(tmpMap.containsKey("stuNo")){
                    Students[i].setStuNo(tmpMap.get("stuNo").toString());
                }
                if(tmpMap.containsKey("name")){
                    Students[i].setName(tmpMap.get("name").toString());
                }
                if(tmpMap.containsKey("sex")){
                    Students[i].setSex(tmpMap.get("sex").toString());
                }
                if(tmpMap.containsKey("age")){
                    Students[i].setAge(Integer.parseInt(tmpMap.get("age").toString()));
                }
                if(tmpMap.containsKey("stuGrade")){
                    Students[i].setStuGrade(tmpMap.get("stuGrade").toString());
                }
                if(tmpMap.containsKey("stuClass")){
                    Students[i].setStuClass(tmpMap.get("stuClass").toString());
                }
                if(tmpMap.containsKey("score1")){
                    Students[i].setScore1(Double.parseDouble(tmpMap.get("score1").toString()));
                }
                if(tmpMap.containsKey("score2")){
                    Students[i].setScore2(Double.parseDouble(tmpMap.get("score2").toString()));
                }
                if(tmpMap.containsKey("score3")){
                    Students[i].setScore3(Double.parseDouble(tmpMap.get("score3").toString()));
                }
                if(tmpMap.containsKey("score")){
                    Students[i].setScore(Double.parseDouble(tmpMap.get("score").toString()));
                }
                if(tmpMap.containsKey("level")){
                    Students[i].setLevel(Integer.parseInt(tmpMap.get("level").toString()));
                }
            }
        }
    }
}
