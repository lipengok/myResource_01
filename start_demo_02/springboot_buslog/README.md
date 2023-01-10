https://www.cnblogs.com/wang1221/p/16834662.html

mybatis-plus插入数据的时候中文乱码
原配置
spring.datasource.url=jdbc:mysql://localhost:3306/test?serverTimezone=UTC
修改后
# 数据库连接地址
spring.datasource.url=jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8