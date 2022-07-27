用户登录JWT JSON Web Token：https://www.cnblogs.com/javastack/p/15898860.html
spring实现简单的过滤器：https://blog.csdn.net/Tong_zhi/article/details/102922121


比较清晰的jwt使用教程：

jwt工具说明：
1，生成的token中不带有过期时间，token的过期时间由redis进行管理
2，UserTokenDTO中不带有敏感信息，如password字段不会出现在token中

实体类分类说明：
vo：业务与web流转。
dto：业务内部流转。
pojo：表联合。

拦截器说明：
1，拦截器中主要做两件事，一是对token进行校验，二是判断token是否需要进行续期 token校验：
2，判断id对应的token是否不存在，不存在则token过期
若token存在则比较token是否一致，保证同一时间只有一个用户操作
token自动续期： 为了不频繁操作redis，只有当离过期时间只有30分钟时才更新过期时间