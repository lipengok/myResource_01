目录：
1，定义dubbo的接口

#spring-boot整合dubbo的时候jar包的引入问题
dubbo使用时必须引入zokeeper的jar包，springboot整合的时候会将一系列jar放到一块。
<!-- Spring Boot Dubbo 依赖 -->
<dependency>
    <groupId>com.alibaba.boot</groupId>
    <artifactId>dubbo-spring-boot-starter</artifactId>
    <version>0.2.0</version>
</dependency>

#参考文档
链接地址：https://www.cnblogs.com/chy18883701161/p/12783892.html
本次演示并没有完全按照参考文档来。

#通过zookeeper客户端：操作dubbo服务
1，打开zk客户端。
2，查看所有的dubbo服务：  ls /dubbo
3，清空所有的服务：  deleteall /dubbo

#严重错误
错误描述：
consumer里面引入dubbo服务的时候是引入的api统一接口，不是接口实现。
如果是接口的实现就会出现服务没发现的错误。
错误解决：
@Reference
private UserServiceImpl userService;
改成
@Reference
private UserService userService;

#细节错误
provider在提供服务的时候，发现dubbo的代码并没有被发现。
错误解决：
在启动类上面添加注解@DubboComponentScan(basePackages = "com.lp.dubbo_demo_provider")
设置扫描的包名称，这样dubbo代码就可以被发现。


#http请求和dubbo两种通讯方式对比
我可以用HTTP请求就行，为什么还会出现dubbo这种通信的方式？
dubbo通信方式到底有什么优势呢？
1，http请求时短连接，dubbo是长连接。
可以有效避免频繁的创建tcp连接。
2，就安全而言，http是远远优于dubbo。
所以一般dubbo用于内网通讯，外网通讯得用http请求。
3，http连接安全，dubbo传输效率高。
4，http请求用于client-server，dubbo用于server-server。

#演示部署说明
dubbo_demo，dubbo_demo_consumer，dubbo_demo_provider
这三个jar包应该分别部署在不同的服务器中，他们直接的通讯使用dubbo，对外通讯使用http。







