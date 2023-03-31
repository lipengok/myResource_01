目录：
1，log4j日志的配置。
//todo
2，elasticsearch的基本增删改查。
3，es联合数据库，实现数据库在新增的时候，将索引添加到es里面。


#ES相关的url操作
1，获取所有的index
GET http://localhost:9200/_cat/indices?v&pretty
2，删除指定的索引
DELETE http://localhost:9200/indexName
3，查询索引的所有文档
GET http://localhost:9200/indexName/_search
(需带下面的请求体，查多个索引的话可以把地址中的indexName改为indexName,indexName)
{
    "query":{
        "match_all":{

        }
    }
}
4，添加文档
POST http://localhost:9200/indexName/docs/id
requestBody
{
    实体类映射对象
}

