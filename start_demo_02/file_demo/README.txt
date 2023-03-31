目录：
1，excel文件导入导出。
-- poi实现excel的导入/导出。
2，springboot整合阿里云图片存储：OSS。
-- 文件上传/下载。
3，字符串的加密解密。
-- 通过异或运算进行加密



excel文件导入导出
excel文件导入导出：https://blog.csdn.net/qq_33223299/article/details/78916457
poi实现excel文件导入导出

excel文件导出
    导出对象：student
post localhost:8080/file/export
{
	"fileName":"student",
	"students":[
		{
			"stuNo":"909090",
    		"name":"jack",
    		"sex":"男",
		    "age":24,
		    "stuGrade":"良好",
		    "stuClass":"计算机科学与技术 一班",
		    "score1":89.5,
		    "score2":89.5,
			"score3":90,
		    "score":270,
		    "level":12
		},
		{
			"stuNo":"909091",
    		"name":"tom",
    		"sex":"男",
		    "age":24,
		    "stuGrade":"良好",
		    "stuClass":"计算机科学与技术 一班",
		    "score1":89.5,
		    "score2":89.5,
			"score3":90,
		    "score":270,
		    "level":12
		}
	]
}

文件导入
    导入对象：student
post localhost:8080/student/import
{
	"xslName":"students",
	"sheetName":"student-01"
}

文件导出
    导出对象：user
    增强的导出
    1，新增可连续请求在一个工作簿创建多个sheet，再次丢同一个sheet写入数据的时候会覆盖之前的数据。
    2，新增密码加密不可见。
post localhost:8080/user/export
{
	"fileName":"user",
	"sheetName":"user-01",
	"list":[
		{
			"id":8989989,
			"name":"jack",
			"psw":"981021xx",
			"information":"user export test",
			"photo":"www.baidu.com",
			"school":"蚌埠学院"
		}
	]
}    