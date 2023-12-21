springboot整合nacos
参考官方文档：https://nacos.io/zh-cn/docs/quick-start-spring-boot.html

nacos项目路径：E:\github\nacos-server-2.1.0
直接用ide打开运行

nacos--配置功能
通过调用 Nacos Open API 向 Nacos server 发布配置：dataId 为example，内容为useLocalCache=true
命令：
curl -X POST "http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=example&group=DEFAULT_GROUP&content=useLocalCache=true"


nacos--服务发现功能
通过调用 Nacos Open API 向 Nacos server 注册一个名称为 example 服务
命令：
curl -X POST "http://127.0.0.1:8848/nacos/v1/ns/instance?serviceName=example&ip=127.0.0.1&port=8080"
















