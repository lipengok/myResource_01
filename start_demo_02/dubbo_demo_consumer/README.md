dubbo的消费者

查看Dubbo服务-通过zk客户端:https://www.cnblogs.com/huasky/p/10214642.html
1，打开zk客户端。
2，查看所有的dubbo服务：  ls /dubbo
3，清空所有的服务：  deleteall /dubbo

严重错误
错误描述：
consumer里面引入dubbo服务的时候是引入的api统一接口，不是接口实现。
如果是接口的实现就会出现服务没发现的错误。
错误解决：
@Reference
private UserServiceImpl userService;
改成
@Reference
private UserService userService;
