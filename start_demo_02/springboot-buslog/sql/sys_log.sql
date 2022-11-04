CREATE TABLE `NewTable` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键' ,
`title`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '模块标题' ,
`business_type`  int(2) NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）' ,
`method`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '方法名称' ,
`request_method`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求方式' ,
`oper_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作人员' ,
`oper_url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求URL' ,
`oper_ip`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '主机地址' ,
`oper_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='操作日志记录'
AUTO_INCREMENT=1585197503834284034
ROW_FORMAT=COMPACT;