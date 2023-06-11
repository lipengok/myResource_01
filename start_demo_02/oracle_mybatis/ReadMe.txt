springboot+mybatis+oracle 整合

测试：
post localhost:8080/user/insertUser
{
    "code": "200",
    "msg": "success",
    "data": {
        "id": 24,
        "name": "jok",
        "psw": "131421",
        "photo": "www.baidu.com",
        "information": "information demo",
        "school": "bb_univercity",
        "address": "江苏省_南京市_雨花台区"
    }
}

## 目录
1，参考连接：https://blog.csdn.net/a290450134/article/details/82773394
2，操作流程
3，问题记录
    问题1
    配置出错--报错内容：jdbcUrl is required with driverClassName
    参考：https://blog.csdn.net/weixin_40085570/article/details/80968099
    总结：spring.datasource.url=jdbc:oracle:thin:@127.0.0.1:1521:orcle
    需要替换成：spring.datasource.jdbc-url=jdbc:oracle:thin:@127.0.0.1:1521:orcle