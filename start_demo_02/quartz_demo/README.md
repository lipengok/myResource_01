使用教程
@Schedule:  https://blog.csdn.net/qq_33375499/article/details/105856253
线程池：https://www.cnblogs.com/zincredible/p/10984459.html

操作：
post    localhost:8080/ticket/sendTickets
{
	"delay":2,
	"scope":20,
	"name":"store_ticket",
	"ticketNum":25
	
}

post    localhost:8080/ticket/buy
{
	"id":89999999,
	"name":"jack",
	"psw":"787878",
	"information":"test none",
	"photo":"baidu.com",
	"school":"蚌埠学院"
}

get     localhost:8080/ticket/init/10

get     localhost:8080/ticket/getTickets